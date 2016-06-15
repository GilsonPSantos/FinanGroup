<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alteração Cadastral - FinanGroup</title>

<link rel="stylesheet" href="css/bootstrap.css"  />
<script type="text/javascript" src="js/jquery.js" ></script> 
  <script type="text/javascript" src="js/bootstrap.js" ></script>
<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/styles.css" rel="stylesheet">


<!--Icons-->
<script src="js/lumino.glyphs.js"></script>

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

<style type="text/css">
	
@import "bourbon";

body {
	background: #eee !important;	
}

.wrapper {	
	margin-top: 80px;
  margin-bottom: 80px;
}

.form-signin {
  max-width: 380px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,0.1);  

  .form-signin-heading,
	.checkbox {
	  margin-bottom: 30px;
	}

	.checkbox {
	  font-weight: normal;
	}

	.form-control {
	  position: relative;
	  font-size: 16px;
	  height: auto;
	  padding: 10px;
		@include box-sizing(border-box);

		&:focus {
		  z-index: 2;
		}
	}

	input[type="text"] {
	  margin-bottom: -1px;
	  border-bottom-left-radius: 0;
	  border-bottom-right-radius: 0;
	}

	input[type="password"] {
	  margin-bottom: 20px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
}
	
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



</style>

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
			
			
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main"><!--Div da parte da direita-->			
		
		
		<div class="form group" > 
   <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        
    <h4 class="modal-title">Alterar Dados Cadastrais</h4>
   </div>
   <div class="modal-body">
     
     <s:form method="post" action="usuario.alterar"
           cssClass="form-group" theme="simple" id="form1" role="form">
           
           
      <s:hidden name="usuario.idUsuario"></s:hidden> 
      
       <label for="nome">Nome</label>
      <s:textfield label="nome" name="usuario.nome" id="nome" cssClass="form-control"></s:textfield>

        <br/><br/>      
       <label for="email">Email</label>
      <s:textfield label="email" name="usuario.email" id="email" cssClass="form-control"></s:textfield>
      
      
     <br/><br/>         
      
     <label for="celular">Celular</label>
     <s:textfield label="email" name="usuario.celular" id="email" cssClass="form-control"></s:textfield>
      
      <br/><br/>
      <s:submit cssClass="btn btn-primary" value="Alterar Dados"></s:submit>
     
     ${msgAlterar}
     <br/> 
     
    
     </s:form>
     </div>
   </div>
  </div>
 </div>
 
		
		
		
   								
	
	</div>	<!--/.main-->

	
	
</body>

</html>
