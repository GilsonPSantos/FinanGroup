conn system/hxl3janr

drop user projetoFinalGilson cascade;

create user projetoFinalGilson identified by coti
default tablespace users
quota 100m on users;

grant create table, create session, create procedure, create view,
		create materialized view, create user, connect, create trigger,
		create sequence to projetoFinalGilson;

conn projetoFinalGilson/coti

drop table usuario cascade constraint;
drop sequence seq_usuario;
drop sequence seq_lancamento;
drop table lancamento cascade constraint;
drop table carteiraUsuario cascade constraint;
drop table grupo cascade constraint;
drop sequence seq_grupo;
drop table adicionaUsuario cascade constraint;
drop table carteiraGrupo cascade constraint;
drop sequence seq_mensagem;
drop table mensagem cascade constraint;
drop procedure adicionaLancamentoUsuario;
drop procedure criarGrupo;
drop procedure adicionaLancamentoGrupo;
drop procedure aceitarGrupo;

create sequence seq_usuario;

create table usuario (
idUsuario number(5) primary key,
nomeUsuario varchar(50),
email varchar(35) unique,
senha varchar(100),
celular varchar(20),
ativo number(2)
);

create sequence seq_lancamento;

create table lancamento(
	idLancamento number(5) primary key,
	nomeLancamento varchar(30),
	tipoLancamento number(2), --0 - receita e 1 - despesa
	dataLancamento date, -- Se for receita é dataCadastro e se for despesa é dataVencimento
	valorLancamento number(10,2),
	status number(2)
);

create sequence seq_grupo;

create table grupo (
	idGrupo number(5) primary key,
	nomeGrupo varchar(20) unique,
	status number(2),
	id_usuario number(5),
	foreign key (id_usuario) references usuario (idUsuario)
);

create table adicionaUsuario (
	id_Usuario number(5),
	id_Grupo number(5),
	unique(id_Usuario, id_Grupo),
	foreign key (id_usuario) references usuario(idUsuario),
	foreign key (id_Grupo) references grupo(idGrupo)
);

create table carteiraGrupo (
	id_Grupo number(5),
	id_Usuario number(5),
	id_lancamento number(5),
	primary key(id_Grupo, id_Usuario, id_Lancamento),
	foreign key (id_Grupo) references grupo(idGrupo),
	foreign key (id_Usuario) references usuario(idUsuario),
	foreign key (id_Lancamento) references lancamento(idLancamento)
);


create sequence seq_mensagem;
--status da mensagem = 0(aceita), 1(não aceita)
create table mensagem(
	idMensagem number(5) primary key,
	mensagem varchar(100),
	status number(2),
	id_Grupo number(5),
	id_UsuarioDestino number(5),
	unique (id_Grupo , id_UsuarioDestino),
	foreign key (id_Grupo) references grupo(idGrupo),
	foreign key (id_UsuarioDestino) references usuario(idUsuario)
);


set serveroutput on size 10000;

-- Quando o usuário criar um grupo já setar na tabela do grupo o id dele..

create or replace procedure criarGrupo(pidUsuario in number, pnomeGrupo in varchar, 
					pStatus in number)
as
begin
	insert into grupo values (seq_Grupo.nextval, pnomeGrupo, pStatus, pidUsuario);
	insert into adicionaUsuario values(pidUsuario, seq_Grupo.currval);
	commit;
	dbms_output.put_line('Dados Gravados ...');
	Exception when others then
	 Rollback;
	 dbms_output.put_line('Error :' || sqlerrm);  
	 
end; 
/

--Quando um usuário de um grupo adiciona lançamento nesse grupo essa procedure já atualiza a carteira do grupo..

create or replace procedure adicionaLancamentoGrupo(pidUsuario in number,pidGrupo in number, pnomeLancamento in varchar, 
					ptipoLancamento in number, pdataLancamento in date, pvalorLancamento in number, pstatus in number)
as
begin
	insert into lancamento values (seq_lancamento.nextval, pnomeLancamento, ptipoLancamento,
									pdataLancamento,pvalorLancamento,pstatus );
	insert into carteiraGrupo values(pidGrupo, pidUsuario, seq_lancamento.currval);
	commit;
	dbms_output.put_line('Dados Gravados ...');
	Exception when others then
	 Rollback;
	 dbms_output.put_line('Error :' || sqlerrm);  
	 
end; 
/

--Procedure para quando o usuário aceitar o convite no grupo na tabela mensagem, ele já ser inserido no grupo...

create or replace procedure aceitarGrupo(pidUsuario in number,pidGrupo in number)
as
begin
	insert into adicionaUsuario values (pidUsuario,pidGrupo);
	
	update mensagem set status = 0 where id_UsuarioDestino = pidUsuario;
	commit;
	dbms_output.put_line('Dados Gravados ...');
	
	Exception when others then
	 Rollback;
	 dbms_output.put_line('Error :' || sqlerrm);  
	 
end; 
/

set linesize 400
column senha format a20
column nomeusuario format a20
select * from usuario;


--Achar o usuário que enviou a mensagem e o grupo para exiber na consulta de mensagem do usuário--	

select nomeUsuario as UsuarioOrigem, idGrupo, nomeGrupo as Grupo, mensagem, idMensagem from usuario u inner join grupo g on u.idUsuario = g.id_usuario inner join mensagem m 
	on m.id_grupo = g.idGrupo where m.id_usuarioDestino = 1 and m.status = 1;

	
	
 
 --Achar o id do grupo e do usuario criador dos grupos aos quais pertencem o usuario logado--	
 select idGrupo, nomeGrupo,idUsuario, nomeUsuario as usuarioCriador from usuario u 
 inner join grupo g on 
 u.idusuario = g.id_Usuario 
 inner join adicionaUsuario au on au.id_grupo = g.idGrupo where au.id_usuario = 2 and g.status = 1;
 
 
--Achar os lançamentos de despesas (tipo = 1) e receitas (tipo = 0) de um grupo
 select idLancamento, nomeLancamento, dataLancamento, valorlancamento, nomeUsuario as usuarioLancador
 		from lancamento l inner join carteiraGrupo cg on l.idLancamento = cg.id_Lancamento inner join
 		usuario u on cg.id_usuario = u.idUsuario where cg.id_grupo = 1 and l.status = 1 and l.tipoLancamento = 1;
 
 
 --Achar todos os usuarios de um grupo
 
 select idUsuario, nomeUsuario, email, id_Grupo  from usuario u inner join adicionaUsuario au on au.id_usuario = u.idUsuario 
 		where au.id_grupo = 22 and u.ativo = 1;
 
 --Achar o criador do grupo
 
select idUsuario from usuario u inner join grupo g on u.idUsuario = g.id_usuario where g.idGrupo = 9;
 		
 --Achar o usuario que lancou a despesa
select idUsuario from usuario u inner join carteiraGrupo cg on u.idUsuario = cg.id_usuario
	where id_lancamento = 

