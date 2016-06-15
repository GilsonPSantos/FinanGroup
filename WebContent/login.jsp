<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Pragma" content="no-cache">
 <meta http-equiv="Cache-Control" content="no-cache">
 <meta http-equiv="Expires" content="0">
 <meta http-equiv="Cache-Control" content="must-revalidate">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>



<link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/bootstrap.css"  />
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/styleLogin.css">
  <script type="text/javascript" src="js/jquery.js" ></script> 
  <script type="text/javascript" src="js/bootstrap.js" ></script> 


<style type="text/css">

body {
    /* height: 100%;
    background-repeat: no-repeat;
    background-color: #003D78; */
    background-image: url("img/login.jpg");
    background-repeat: no-repeat;
    width: 100%;
    //height: 100%;
    margin: 0 auto;
}




</style>

</head>
<body>

<div id="container" class="container">

<div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Efetuar Cadastro</a></li>
        <li class="tab"><a href="#login">Login</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>Faça seu Cadastro</h1>
          
          <s:form action="usuario.cadastrar" method="post" theme="simple" id="form1">
          
          
            <div class="field-wrap">
              <label>
                Nome<span class="req">*</span>
              </label>
              <input type="text" required autocomplete="off" name="usuario.nome" />
            </div>
        
            <div class="field-wrap">
            </div>
         

          <div class="field-wrap">
            <label>
              Email<span class="req">*</span>
            </label>
            <input type="email" required autocomplete="off" name="usuario.email"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Senha<span class="req">*</span>
            </label>
            <input type="password"required autocomplete="off" name="usuario.senha"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Celular<span class="req">*</span>
            </label>
            <input type="tel"required autocomplete="off" name="usuario.celular"/>
          </div>
          
          <s:submit type="submit" cssclass="button button-block" value="Cadastrar"></s:submit>
          
          </s:form>
 <br><br>
 	<c:if test="${resp!=null}">
          <div class="alert alert-danger">
			
			${resp}
			
			</div>
	</c:if>
			
        </div>
        
        <div id="login">   
          <h1>Bem vindo ao FinanGroup!</h1>
          
          <s:form action="usuario.login" method="post" theme="simple" id="form2">
         
          
            <div class="field-wrap">
            <label>
              Email<span class="req">*</span>
            </label>
            <input type="email" name="usuario.email" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Senha<span class="req">*</span>
            </label>
            <input type="password" name="usuario.senha" autocomplete="off"/>
          </div>
          
          <p class="forgot"><a href="#">Esqueci minha senha</a></p>
         
          <s:submit type="submit" cssclass="button button-block">Entrar</s:submit>
          
          ${msgLogin}
          
          </s:form>

        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
  
  <script src="js/index.js"></script>


</div>

</body>
</html>