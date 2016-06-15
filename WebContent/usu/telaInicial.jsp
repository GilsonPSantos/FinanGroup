<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tela Inicial - FinanGroup</title>

<link rel="stylesheet" href="css/bootstrap.css"  />
<script type="text/javascript" src="js/jquery.js" ></script> 
  <script type="text/javascript" src="js/bootstrap.js" ></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">


<!--Icons-->
<script src="js/lumino.glyphs.js"></script>

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

<style type="text/css">
	
.navbar-login
{
    width: 305px;
    padding: 10px;
    padding-bottom: 0px;
}

.navbar-login-session
{
    padding: 10px;
    padding-bottom: 0px;
    padding-top: 0px;
}

.icon-size
{
    font-size: 87px;
}
#navBar{
	height: 60px;
}

body{
	background-color: #F0FFF0;
}

.tabelaPrincipal{

background-color: #C1CDCD;
font-weight: bolder;
text-align: center;
color: 
}

.tabelaPrincipal2{
	text-align: center;
	font-weight: bolder;
}

tr{
	
}

  

</style>

<script>
function confirmaExclusao() {
    confirm("Deseja realmente cancelar seu cadastro?");
}



</script>

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header" id="navBar">
				
				<a class="navbar-brand" href="#"><span>Finan</span>Group</a>
				
					
					<ul class="nav navbar-nav navbar-right"><!-- div do logout-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span> 
                        <strong>Usuario</strong>
                        <span class="glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="navbar-login">
                                <div class="row">
                                    <div class="col-lg-4">
                                        <p class="text-center">
                                            <span class="glyphicon glyphicon-user icon-size"></span>
                                        </p>
                                    </div>
                                    <div class="col-lg-8">
                                        <p class="text-left"><strong>${usuario.nome}</strong></p>
                                        <p class="text-left small">${usuario.email}</p>
                                         <p class="text-left">
                                        	<s:a href="usuario.linkCancelarCadastro.action" 
                                        	onclick="return window.confirm('Deseja Cancelar seu Cadastro?');">Cancelar Conta</s:a>
                                        	</p>
                                        	<p class="text-left">
                                        	<s:a href="usuario.linkAlterarUsuario.action" cssClass="btn btn-primary btn-block btn-sm">Atualizar dados</s:a>
                                        </p>
                                       
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="navbar-login navbar-login-session">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <p>
                                        <s:a href="usuario.logout.action" class="btn btn-danger btn-block" >Sair</s:a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul> <!-- Fim da div do logout-->
				
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar"> <!--Menu lateral-->
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="">
			</div>
		</form>
		<ul class="nav menu">
			<li class="active"><a href="usuario.linkHome.action"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> HOME</a></li>
			
			<li class="parent "> <!-- MENU DROPDOW = NOVO -->
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-1"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg>NOVO</span>  
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="#" data-toggle="modal" data-target="#modal1">
							<svg class="glyph stroked chevron-right" ></svg> GRUPO
						</a>
					</li>
				</ul>
			</li>
			<li role="presentation" class="divider"></li>
			
			
			<li><a href="#" data-toggle="modal" data-target="#modal2"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> MINHAS MENSAGENS</a></li>
			
		</ul>

	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main"><!--Div da parte da direita-->			
		
 		<br><br>
 		
 		
 		<table class="table table-striped" id="tabela">
 	<c:if test="${usuariosGrupos.size() > 0}">
   <thead>
    
     <tr>
         
        <td class="tabelaPrincipal">Nome</td>
        <td class="tabelaPrincipal">Usuário Criador</td>
        <td class="tabelaPrincipal">Excluir</td>
        <td class="tabelaPrincipal">Alterar</td>
        
     </tr>
       
   </thead>
   </c:if>	
   <tbody>
   
     <c:forEach items="${usuariosGrupos}" var="linha">
     
     	<tr class="tabelaPrincipal2">
        	<td onclick="location.href='grupo.linkTelaGrupo.action?idGrupo=${linha.idGrupo}&nomeGrupo=${linha.nomeGrupo}&idUsuario=${linha.idUsuario}'" style="cursor:pointer;">${linha.nomeGrupo}</td>
        	<td onclick="location.href='grupo.linkTelaGrupo.action?idGrupo=${linha.idGrupo}&nomeGrupo=$${linha.nomeGrupo}&idUsuario=${linha.idUsuario}'" style="cursor:pointer;">${linha.nomeUsuarioCriador}</td>
         
      <c:if test="${linha.idUsuario == usuario.idUsuario}">
        	<td><a href="grupo.deletar.action?idGrupo=${linha.idGrupo}" 
        onclick="return window.confirm('Deseja Excluir Esse Grupo?');" 
        class="glyphicon glyphicon-trash">
        	 	
        </a>
        </td>
        <td><a href="grupo.linkAlterar.action?idGrupo=${linha.idGrupo}"
        class="glyphicon glyphicon-pencil">
         </a> </td>
         
     </c:if>
     
     <c:if test="${linha.idUsuario != usuario.idUsuario}">
     
     		<td></td>
        	<td></td>
     
     
     </c:if>
     
     
     
     	</tr>  
      
     </c:forEach>
    
   </tbody>
  
  </table>
 		
 	
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
   		<!-- MODAL 1 - CADASTRO DE GRUPO-->
   		
   		
   		<div class="modal fade" id="modal1" role="dialog">
   <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        Fechar
        </button>
    <h4 class="modal-title">Cdastrar um Grupo</h4>
   </div>
   <div class="modal-body">
     <s:form method="post" action="grupo.cadastrar"
           class="form-group">
           
      <label for="nomeUsuario">Nome do Grupo:</label>
      <input type="text" name="grupo.nome" id="nomeGrupo" 
             placeholder="Entre com o Nome do Grupo"
             title="Entre com o Nome"
             pattern="[a-z A-Z]+" class="form-control"
             required="required">
        <br/><br/>      
     
     <s:submit value="Cadastrar" cssClass= "btn btn-primary" ></s:submit>
     
     </s:form>
     
     </div>
   </div>
  </div>
 </div>
 
   		
   		<!-- MODAL 2 - VERIFICAR LISTA DE MENSAGENS-->
   		
   		
   		<div class="modal fade" id="modal2" role="dialog">
   <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        Fechar
        </button>
    <h4 class="modal-title">Mensagens</h4>
   </div>
   <div class="modal-body">
     
     <!-- Tabela de Mensagens -->
		
		<br>
		<table class="table table-striped table-hover">
		  <thead>
		    <tr>
		      <th>Enviada por</th>
		      <th>Grupo</th>
		      <th>Detalhes</th>
		    </tr>
		  </thead>
		  <tbody>
		     
		     
		    <c:forEach items="${mensagens}" var="msg">
		    <tr class="info">
		      
		      <td>${msg.nomeUsuarioOrigem}</td>
		      <td>${msg.nomeGrupo}</td>
		      <td>${msg.mensagem}</td>
		      <th>
		      <a class="" href="mensagem.aceitarMensagem.action?idGrupo=${msg.idGrupo}" >
		      <button class="btn btn-primary" >Aceitar</button>
		      
		      </a>
		      </th>
		      
		      <th>
		      <a class="" href="mensagem.deletarMensagem.action?idMensagem=${msg.idMensagem}"" >
		      <button class="btn btn-primary" >Recusar</button>
		      
		      </a>
		      </th>
		       
		    </tr>
		   </c:forEach>
			  	    
		  </tbody>
		</table> 
			 
     
     </div>
   </div>
  </div>
 </div>
   		
   		
   	
   								
	
	</div>	<!--/.main-->

	
	
</body>

</html>
