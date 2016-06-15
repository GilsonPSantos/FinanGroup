<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<style type="text/css">
#teste{
background-color: #E6E6FA;

}

</style>


</head>

<body>
	<div class="container">
		<h2>Gravação Usuário</h2>
		<button type="button" class="btn btn-info btn-lg" 
				data-toggle="modal" data-target="#modal1">Gravação Usuario</button>
	
		<button type="button" class="btn btn-info btn-lg" 
				data-toggle="modal" data-target="#modal2">Login</button>
	
	<div class="modal fade" id="modal1" role="dialog">
	<div class="modal-dialog" >
	<div class="modal-content" id="teste">
		<div class="modal-header">
			<button class="close" data-dismiss="modal">Fechar</button>
		<h4 class="modal-title">Dados Usuário</h4>
		</div>
	<div class="modal-body">
		
		<form action="Controle?cmd=gravar" method="post" class="form-group">
			
			<label for="nomeUsuario">Nome Usuário:</label>
			<input 	type="text" name="nomeUsuario" id="nomeUsuario" 
					placeholder="Entre com o Nome" pattern="[a-z A-Z]+" class="form-control">
			
			<label for="email">Login:</label>
			<input 	type="email" name="email" id="email" 
					placeholder="Entre com o Email" 
					title="Entre com o Email" 
					class="form-control">
			
			<label for="senha">Senha:</label>
			<input 	type="password" name="senha" id="senha" 
					placeholder="Entre com a Senha" pattern="[a-zA-Z0-9]+" 
					class="form-control">
			
			<label for="datacadastro">Data Cadastro:</label>
			<input 	type="date" name="datacadastro" id="datacadastro" 
					placeholder="Entre com a Data" class="form-control" 
					title="Entre com a DataCadastro">
			<br><br>
			<input type="submit" value="Enviar os Dados" class="btn btn-primary" />
			</form>
	</div>
	
	
	</div>
	</div>
	
	</div>
	
	<!-- MODAL 2 -->
	
	
	<div class="modal fade" id="modal2" role="dialog">
	<div class="modal-dialog" >
	<div class="modal-content" id="teste">
		<div class="modal-header">
			<button class="close" data-dismiss="modal">Fechar</button>
		<h4 class="modal-title">Dados Usuário</h4>
		</div>
	<div class="modal-body">
		
		<form action="Controle?cmd=gravar" method="post" class="form-group">
			
			<label for="nomeUsuario">Nome Usuário:</label>
			<input 	type="text" name="nomeUsuario" id="nomeUsuario" 
					placeholder="Entre com o Nome" pattern="[a-z A-Z]+" class="form-control">
			
			<label for="email">Login:</label>
			<input 	type="email" name="email" id="email" 
					placeholder="Entre com o Email" 
					title="Entre com o Email" 
					class="form-control">
			
			<label for="senha">Senha:</label>
			<input 	type="password" name="senha" id="senha" 
					placeholder="Entre com a Senha" pattern="[a-zA-Z0-9]+" 
					class="form-control">
			
			<label for="datacadastro">Data Cadastro:</label>
			<input 	type="date" name="datacadastro" id="datacadastro" 
					placeholder="Entre com a Data" class="form-control" 
					title="Entre com a DataCadastro">
			<br><br>
			<input type="submit" value="Enviar os Dados" class="btn btn-primary" />
		</form>
	
	</div>
	
	
	</div>
	</div>
	
	</div>
	</div>

</body>
</html>