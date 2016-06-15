<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Grupo - Tela Inicial</title>


 <script type="text/javascript" src= "js/bootstrap-datepicker.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"  />
<link rel="stylesheet" href= "css/datepicker.css" />
<script type="text/javascript" src="js/jquery.js" ></script> 
  <script type="text/javascript" src="js/bootstrap.js" ></script>
 
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<link href="css/normalize.css" rel="stylesheet">


<!--Icons-->
<script src="js/lumino.glyphs.js"></script>

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

<style type="text/css">
	
	@import url('http://fonts.googleapis.com/css?family=Lato:300');
@import url('http://weloveiconfonts.com/api/?family=entypo');
	
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

* {
  margin: 0;
  padding: 0;
}

html, body {
  height: 100%;
}

body {
/*
  background: #ddd;*/
}

.content {
  padding: 10px;
  font: 300 20px Lato, sans-serif;
  text-align: center;
  color: #ooo;
  background: #eee;
  margin-top: 15%;
}


.tabelaPrincipal{

background-color: #C1CDCD;
font-weight: bolder;
text-align: center;
color: 
}

#tabelaPrincipal2{
	text-align: center;
	font-weight: bolder;
}

#alert{
	height: 40px;
	margin: 0px;
	width: 40%;

}


</style>
<link rel="stylesheet" href="css2/style.css">

</head>

<script type="text/javascript">

$(document).ready(function(){
	var percentual = $("#barra").text();
	if(percentual <= 50){
		document.getElementById("barraProgresso").style.backgroundColor = "#9BCD9B";
	}else if(percentual <= 69){
		document.getElementById("barraProgresso").style.backgroundColor = "#FFD700";
	}else{
		document.getElementById("barraProgresso").style.backgroundColor = "red";
	}
});

</script>

<script>
      $(document).ready(function () {
        $('#data3').datepicker({
            format: "dd/mm/yyyy",
            language: "pt-BR",
            autoclose: true,
            
        });
      });
    </script>

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
                                        <p class="text-left small">${usuario.email}
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
			<li><a href="usuario.linkHome.action"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> HOME</a></li>
			
			<li><a href="#" data-toggle="modal" data-target="#modal3"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> USUÁRIOS DO GRUPO</a></li>
			
			
			<li class="parent "> <!-- MENU DROPDOW = NOVO -->
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-1"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg>LANÇAMENTO</span>  
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="#" data-toggle="modal" data-target="#modal1">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> DESPESA
						</a>
					</li>
					<li>
						<a class="" href="#" data-toggle="modal" data-target="#modal2">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> RECEITA
						</a>
					</li>
					
				</ul>
			</li>
			<li role="presentation" class="divider"></li>
			
			<c:if test="${usuarioCriador == usuario.idUsuario}">
			
			<li><a href="usuario.linkConsultaUsuario.action"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> CONVIDAR UM AMIGO</a></li>
			</c:if>
			
			<li class="parent "> <!-- MENU DROPDOW = relatorios -->
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-3"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg>RELATÓRIOS</span>  
				</a>
				
				<ul class="children collapse" id="sub-item-3">
					<li>
						<a class="" href="lancamento.relatorioPdf.action?idGrupo=${idGrupo}" data-toggle="modal" data-target="">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> PDF ITEXT
						</a>
					</li>
					<li>
						<a class="" href="lancamento.relatorioPdfIreportDespesas.action?idGrupo=${idGrupo}" data-toggle="modal" data-target="">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> PDF DESPESAS
						</a>
					</li>
					<li>
						<a class="" href="lancamento.relatorioPdfIreportReceitas.action?idGrupo=${idGrupo}" data-toggle="modal" data-target="">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> PDF RECEITAS
						</a>
					</li>
					<li>
						<a class="" href="lancamento.relatorioCsv.action?idGrupo=${idGrupo}" data-toggle="modal" data-target="">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> EXCEL
						</a>
					</li>
					
				</ul>
			</li>
			
			
		</ul>

	</div><!--/.sidebar-->
		
		
		
		
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main"><!--Div da parte da direita-->		
	
	
	
		
		<br>
		<h3>Bem vindo ao Grupo ${grupologado.nome} </h3>
		
		<c:if test="${totalDespesas >0 && totalReceitas > 0}">
		
		<br	>
		<center><h6 style="font-weight: bolder; font-size: 15px;">Comprometimento da Renda : <strong><b id="barra"> ${percRenda}</b><b>%</b></b></strong></h6></center>
		<div id="barraProgresso"  class="progress-wrap progress" data-progress-percent="${percRenda}">
  			<div class="progress-bar progress"  ></div>
		</div>
		<br	>
		
		</c:if> 
		
		<script src="js2/index.js"></script>
		
		<c:if test="${totalDespesas == 0}">
			<th></th>
		      <th></th>
		      <th></th>
		      <th></th>
		      <th></th>
		      <th></th>
		</c:if>
		
		<c:if test="${totalDespesas != 0}">
		
		<!-- Tabela das Despesas -->
		<div class="alert alert-danger" id="alert">
		<h4>Despesas: Total de R$ ${totalDespesas}</h4>
		</div>	
		<br>
		
		<table class="table table-striped table-hover">
		  <thead>
		    <tr class="tabelaPrincipal">
		      <th>Data de Vencimento</th>
		      <th>Nome da Despesa</th>
		      <th>Quem Lançou</th>
		      <th>Valor</th>
		      <th>Excluir</th>
		      <th>Alterar</th>
		    </tr>
		  </thead>
	
		  <tbody>
		    
		     <c:forEach items="${despesasGrupos}" var="despesa">
		     
		    <tr id="tabelaPrincipal2" class="info" onclick="location.href = '#';" style="cursor: pointer;">
		      
		      <td>${despesa.dataVencimento}</td>
		      <td>${despesa.nomeLancamento}</td>
		      <td>${despesa.usuarioLancador}</td>
		      <td>${despesa.valorLancamento}</td>
		      
		      <c:if test="${despesa.usuarioLancador.equals(usuario.nome)}">
		      
		      <td><a href="lancamento.delete.action?idLancamento=${despesa.idLancamento}&idGrupo=${grupologado.idGrupo}"><div class="glyphicon glyphicon-trash"></div></a></td>
		      <td><a href="lancamento.linkAlterar.action?idLancamento=${despesa.idLancamento}&idGrupo=${grupologado.idGrupo}"><div class="glyphicon glyphicon-pencil"></div></a></td>
		   </c:if>
		   <c:if test="${despesa.usuarioLancador != usuario.nome}">
		   		<td></td>
		      <td></td>
		   
		   </c:if>
		    </tr>
		    
		    </c:forEach>
		    
		    	    
		  </tbody>
		</table> 
		
</c:if>

		<c:if test="${totalReceitas == 0}">
			<th></th>
		      <th></th>
		      <th></th>
		      <th></th>
		      <th></th>
		      <th></th>
		</c:if>
	<c:if test="${totalReceitas != 0}">

		<!-- Tabela das Receitas -->
		<div id="alert" class="alert alert-danger">
  			<h4>Receitas: Total de R$ ${totalReceitas}</h4>
		
		</div>
		<br>
		<table class="table table-striped table-hover">
		  <thead>
		    <tr class="tabelaPrincipal">
		      <th>Data de Lançamento</th>
		      <th>Nome da Receita</th>
		      <th>Quem Lançou</th>
		      <th>Valor</th>
		      <th>Excluir</th>
		      <th>Alterar</th>
		    </tr>
		  </thead>
		  <tbody>
		    
		     <c:forEach items="${receitasGrupos}" var="receitas">
		     
		    <tr id="tabelaPrincipal2" class="info" onclick="location.href = '#';" style="cursor: pointer;">
		      
		      <td>${receitas.dataVencimento}</td>
		      <td>${receitas.nomeLancamento}</td>
		      <td>${receitas.usuarioLancador}</td>
		      <td>${receitas.valorLancamento}</td>
		      
		      
		      
		      <c:if test="${receitas.usuarioLancador.equals(usuario.nome)}">
		      
		      <td><a href="lancamento.delete.action?idLancamento=${receitas.idLancamento}&idGrupo=${grupologado.idGrupo}"><div class="glyphicon glyphicon-trash"></div></a></td>
		      <td><a href="lancamento.linkAlterar.action?idLancamento=${receitas.idLancamento}&idGrupo=${grupologado.idGrupo}"><div class="glyphicon glyphicon-pencil"></div></a></td>
		   </c:if>
		   <c:if test="${receitas.usuarioLancador != usuario.nome}">
		   		<td></td>
		      <td></td>
		   
		   </c:if>
		    </tr>
		    
		    </c:forEach>
		    
		    	    
		  </tbody>
		</table> 
		
	</c:if>	
		    
    <!-- Modal 1 - cadastro de Despesas -->
    
    <div class="modal fade" id="modal1" role="dialog">
   <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        Fechar
        </button>
    <h4 class="modal-title">Cadastro de Despesas</h4>
   </div>
   <div class="modal-body">
     <s:form method="post" action="lancamento.cadastrar"
           class="form-group">
      
      <s:hidden name="lancamento.tipoLancamento" value="1"></s:hidden>
     
      <input type="hidden" name="idGrupo" value="${idGrupo}">
      <input type="hidden" name="nomeGrupo" value="${nomeGrupo}">
           
      <label for="nomeUsuario">Nome da Despesa:</label>
      <input type="text" name="nomeLancamento" id="nomeLancamento" 
             placeholder="Entre com o Nome da Despesa"
             title="Entre com o Nome da Despesa"
             pattern="[a-z A-Z]+" class="form-control"
             required="required">
        <br/><br/>      
      <label for="email">Data de Vencimento:</label>
      <input type="date" name="lancamento.dataLancamento" id="dataLancamento" 
             placeholder="Entre com a Data de Vencimento"
             title="Entre com a Data de Vencimento"
             class="form-control"
             required="required">
     <br/><br/>         
      <label for="senha">Valor de Vencimento</label>
      <input type="number" name="valorLancamento" id="valorLancamento" 
             placeholder="Entre com o valor da Despesa"
             title="Entre com o valor da Despesa"
             pattern="[0-9\\. ]+" step="0.01"
             class="form-control"  
             required="required">
     <br/><br/>        
     
     <s:submit value="Cadastrar Despesa" cssClass="btn btn-primary"></s:submit>
     
      
     </s:form>
     </div>
   </div>
  </div>
 </div>
 
    
    
   <!-- Modal 2 - cadastro de Receitas -->
    
    <div class="modal fade" id="modal2" role="dialog">
   <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        Fechar
        </button>
    <h4 class="modal-title">Cadastro de Receitas</h4>
   </div>
   <div class="modal-body">
     <s:form method="post" action="lancamento.cadastrar"
           class="form-group">
      
      <s:hidden name="lancamento.tipoLancamento" value="0"></s:hidden>
     
      <input type="hidden" name="idGrupo" value="${idGrupo}">
      <input type="hidden" name="nomeGrupo" value="${nomeGrupo}">
           
      <label for="nomeUsuario">Nome da Receita:</label>
      <input type="text" name="lancamento.nomeLancamento" id="nomeLancamento" 
             placeholder="Entre com o Nome da Receita"
             title="Entre com o Nome da Receita"
             pattern="[a-z A-Z]+" class="form-control"
             required="required">
        <br/><br/>      
       <input type="date" name="lancamento.dataLancamento" id="dataLancamento" 
             placeholder="Entre com a Data de Lançamento"
             title="Entre com a Data de Lançamento"
             class="form-control"
             required="required">
     <br/><br/>         
      <label for="senha">Valor da Receita</label>
      <input type="number" name="valorLancamento" id="valorLancamento" 
             placeholder="Entre com o valor da Receita"
             title="Entre com o valor da Receita"
             pattern="[0-9\\. ]+" step="0.01"
             class="form-control"  
             required="required">
     <br/><br/>        
     
     <s:submit value="Cadastrar Receita" cssClass="btn btn-primary"></s:submit>
     
      
     </s:form>
     </div>
   </div>
  </div>
 </div>
  
    
    <!-- Modal 3 - Lista de usuários do grupo -->
    
    <div class="modal fade" id="modal3" role="dialog">
   <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        Fechar
        </button>
    <h4 class="modal-title">Usuários do Grupo</h4>
   </div>
   <div class="modal-body">
     
     <table class="table table-striped table-hover">
		  <thead>
		    <tr>
		      <th>Usuários</th>
		      <th></th>
		     </tr>
		  </thead>
		  <tbody>
		    
		   <c:forEach items="${usuariosGrupo}" var="usuariosGrupo">
		    
		    <tr class="info" onclick="location.href = '#';" style="cursor: pointer;">
		      <td>${usuariosGrupo.nomeUsuario}</td>
		      
		    </tr>
		   </c:forEach>
		    	    
		  </tbody>
		</table> 
       
     </div>
   </div>
  </div>
 </div>
 
    
  	

		
	</div>	<!--/.main-->

<script src="js/prefixfree.min.js"></script>

</body>

</html>
