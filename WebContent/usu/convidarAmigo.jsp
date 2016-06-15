<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Grupo - Tela Inicial</title>

<link rel="stylesheet" href="css/bootstrap.css"  />
<script type="text/javascript" src="js/jquery.js" ></script> 
  <script type="text/javascript" src="js/bootstrap.js" ></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
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

.footer {

  padding: 10px 0;
  text-align: center;
}

.social {
  display: inline-block;
  width: 70px;
  height: 70px;
  margin: 0 10px;
  line-height: 70px;
  font-family: Entypo;
  font-size: 35px;
  text-align: center;
  color: #bbb;
  border-radius: 50%;
  background: #eee;
  overflow: hidden;
  transition: color .3s;
}

.social:hover {
  color: #59d;
  cursor: pointer;
}

</style>

<script type="text/javascript">
     $(document).ready(
      function(){
    	   var calcular = function(){
    		   $.ajax({
		    			      type : "POST",
		    			      url  : "Controle",
		    			      data : { "num1"  : $("#num1").val(),
		    			    	       "num2" : $("#num2").val(),
		    			    	       "opcao" : $("#opcao").val()

		    			       },
		    			      success : function(msg){
		    			    	  //O que eu imprimir no Servlet resgato em mensagem
		    			    	  $("#resposta").html(msg); //seta a resposta
		    			      },
		    			      error :function(e){
		    			    	  $("#resposta").html("Error:" + e.status);
		    			      }
    	          	});
    	   		}
 
		    	   //Jquery ao ativar o Botão ao Clicar no botão os dados irão
		    	   //ir e voltar
		    	   $("#opcao").change(function() {
		    		    calcular();
		    		    
		    	   										});
    	   
// 		    	   $("#opcao").keyup(function() {
// 		   		    cadastrar();
// 		   	   									});
    	    
      
      	});

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
                                        <p class="text-left small">${usuario.email}
                                        <p class="text-left">
                                            <a href="usuario.linkAlterarUsuario.action" class="btn btn-primary btn-block btn-sm">Atualizar dados</a>
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
			
			<li role="presentation" class="divider"></li>
		
		</ul>

	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main"><!--Div da parte da direita-->			
		
		<br><br><br>

		<div class="container">
		<div class="row" >
		<s:form action="usuario.consultaUsuario" method="post" cssClass="navbar-search pull-left">
		<input type="text" name="email" id="email" class="form-control" placeholder="Busca por Email">
		<br>
		<s:submit value="Pesquisar" cssClass="btn btn-primary"></s:submit>
		</s:form>
		</div>
		</div>
		<br><br>
		${msgUsu}
		
		<!-- Tabela de Usuario -->
		<c:if test="${usuarioResp.nome != null}">
		<h3>Usuario</h3>
		<br>
		<table class="table table-striped table-hover">
		  <thead>
		    <tr>
		      <th>Nome</th>
		      <th>Email</th>
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
		     
		    <tr class="info">
		      
		      <td>${usuarioResp.nome}</td>
		      <td>${usuarioResp.email}</td>
		      
		      <th><a href="usuario.enviarMensagem.action?idUsuarioResp=${usuarioResp.idUsuario}">
		      <button class="btn btn-primary" >Convidar</button></a>
		      </th>
		      
		      
		    </tr>
		    
		    
		    	    
		  </tbody>
		</table> 
		</c:if>	 
		   
		   ${msgMsg}
		  
    
    
    
    
    <!-- Modal 3 - Lista de usuários do grupo -->
    
    <div class="modal fade" id="modal1" role="dialog">
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
		     </tr>
		  </thead>
		  <tbody>
		    <tr class="info" onclick="location.href = '#';" style="cursor: pointer;">
		      <td>Usuario 1</td>
		    </tr>
		    
		    <tr class="info" onclick="location.href = '#';" style="cursor: pointer;">
		      <td>Usuario 2</td>
		    </tr>
	    
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
