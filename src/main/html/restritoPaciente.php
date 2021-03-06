<?php

require "conexaoMysql.php";
$pdo = mysqlConnect();

try {

  $sql_1 = <<<SQL
  SELECT nome, cpf, email, telefone, dataNascimento
  FROM paciente 
  SQL;

  $stmt_1 = $pdo->query($sql_1);

  $sql_2 = <<<SQL
  SELECT nome, cpf, email, telefone, dataNascimento
  FROM paciente 
  WHERE nome = ?
  SQL;

  $stmt_2 = $pdo->prepare($sql_2);
  $stmt_2->execute([$nome]);

} catch (Exception $e) {
  exit('Ocorreu uma falha: ' . $e->getMessage());
}
?>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-popRpmFF9JQgExhfw5tZT4I9/CI5e2QcuUZPOVXb1m7qUmeR2b50u+YFEYe1wgzy"
		crossorigin="anonymous"></script>


	<title>Login Paciente</title>

	<style>
		body {
			font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
			padding-top: 80px;
		}

		p {
			font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
			line-height: 1.5rem;

			margin: 0px;
			width: 100%;
			padding: 0px;
		}

		header {
			background-color: DarkSlateBlue;
			color: rgb(27, 26, 26);
			text-align: center;
			margin: 0px;
			width: 100%;
			padding: 0px;
		}

		ul {
			margin: 0px;
			width: 100%;
			padding: 0px;
		}


		main {
			font-size: 0.9rem;
			background-color: rgb(245, 245, 245);

			border: 2px solid rgb(75, 75, 75);
			border-radius: 10px;

			margin: 10px;
			padding: 5px;
		}

		.tabs section {
			display: none;
		}

		section.tabActive {
			display: block;
		}

		h2 {
			text-align: center;
			font-size: 1.75em;
			padding: 10px;
		}

		h1 {
			text-align: center;
			font-size: 1.75em;
			color: white;
			margin-top: 15px;
			font-weight: bold;
		}

		.caixaCentralizada {
			font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
			width: 45%;
			padding: 20px;
			background-color: rgb(245, 245, 245);
			border: 2px solid rgb(75, 75, 75);
			border-radius: 10px;
			position: absolute;
			left: 50%;
			top: 50%;
			transform: translate(-50%, -50%);
		}

		input {
			display: block;
			margin: 8px 0px 25px;
			padding: 0px;
			width: 100%;
			border: 0.6px solid rgb(75, 75, 75);
			border-radius: 4px;
		}

		input:focus {
			outline: none;
			border: 0.6px solid rgb(0, 97, 224);
			box-shadow: 0px 0px 8px rgb(151, 190, 241);
		}

		button {
			padding-top: 10px;
			text-align: center;
			margin: 0 auto;
		}
	</style>
</head>

<body>

	<!--Navbar-->
	<div id="navbar">
		<nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color: rgb(0, 97, 224);">
			<div class="container-fluid">
				<a href="#" class="navbar-brand gray">Nome do Hospital</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>


				<a class="btn btn-outline-light" href="http://geanfernandes.atwebpages.com/web_site/index.html">Sair</a>
			</div>
	</div>
	</nav>
	</div>
	<!--/Navbar-->

</body>
<main class="box">
	<!--TABS-->
	<ul class="nav nav-tabs" role="tablist">
		<li class="nav-item" role="presentation">
			<a class="nav-link active" id="tabButton1" href="#tabpanel1" data-toggle="tab" role="tab"
				aria-controls="tabpanel1">Home Paciente</a>
		</li>
		<li class="nav-item" role="presentation">
			<a class="nav-link" id="tabButton2" href="#tabpanel2" data-toggle="tab" role="tab"
				aria-controls="tabpanel2">Cadastrar Paciente</a>
		</li>
		<li class="nav-item" role="presentation">
			<a class="nav-link" id="tabButton3" href="#tabpanel3" data-toggle="tab" role="tab"
				aria-controls="tabpanel3">Consultar Pacientes</a>
		</li>
		<li class="nav-item" role="presentation">
			<a class="nav-link" id="tabButton4" href="#tabpanel4" data-toggle="tab" role="tab"
				aria-controls="tabpanel4">Alterar Paciente</a>
		</li>
		<li class="nav-item" role="presentation">
			<a class="nav-link" id="tabButton5" href="#tabpanel5" data-toggle="tab" role="tab"
				aria-controls="tabpanel5">Deletar Paciente</a>
		</li>
	</ul>
	<!--/TABS-->

	<!--CONTEUDO DOS TABS-->
	<div class="tab-content" id="myCotents">
		<!--HOME-->
		<div class="tab-pane fade show active" id="tabpanel1" role="tabpanel" aria-labelledby="tabButton1">
			<h2>Home Paciente</h2>
			<h2>Bem Vindo!</h2>
		</div>
		<!--/HOME-->

		<!--CADASTRAR-->
		<div class="tab-pane fade" id="tabpanel2" role="tabpanel" aria-labelledby="tabButton2">
			<div class="container">
				<div class="box" id="main_box">

					<!-- Formul??rio -->
					<form action="restritoCadastraPaciente.php" name="formCadastroPaciente" method="POST">
						<fieldset>

							<h2>Formul??rio Paciente</h2>

							<div class="row g-3">
								<div class="col-sm-8">
									<label for="nome" class="form-label form-label-sm">Nome</label>
									<input type="text" class="form-control form-control-sm" id="nome"name="nome">
								</div>
								<div class="col-sm-4">
									<label for="cpf" class="form-label form-label-sm">CPF</label>
									<input type="text" class="form-control form-control-sm" id="cpf" name="cpf">
								</div>
								<div class="col-sm-4">
									<label for="email" class="form-label form-label-sm">E-mail</label>
									<input type="email" class="form-control form-control-sm" id="email" name="email">
								</div>
								<div class="col-sm-4">
									<label for="telefone" class="form-label form-label-sm">Telefone</label>
									<input type="tel" class="form-control form-control-sm" id="telefone" name="telefone"
										placeholder="(xx) xxxxx-xxxx">
								</div>
								<div class="col-sm-4">
									<label for="dataNascimento" class="form-label form-label-sm">Data Nascimento</label>
									<input type="date" class="form-control form-control-sm" id="dataNascimento"
										name="dataNascimento" placeholder="(xx) xxxxx-xxxx">
								</div>
								<!-- <div class="col-sm-8">
										<label for="logradouro" class="form-label form-label-sm">Logradouro</label>
										<input type="text" class="form-control form-control-sm" id="logradouro" name="logradouro">
										<span></span>
									</div>
									<div class="col-sm-8">
										<label for="cidade" class="form-label form-label-sm">Cidade</label>
										<input type="text" class="form-control form-control-sm" id="cidade" name="cidade">
										<span></span>
									</div>
									<div class="col-sm-4">
										<label for="estado" class="form-label form-label-sm">Estado</label>
										<select class="form-select form-select-sm" name="estado" id="estado">
											<option value="Selecione" selected>Selecione</option>
											<option value="ACRE">AC</option>
											<option value="ALAGOAS">AL</option>
											<option value="AMAPA">AP</option>
											<option value="AMAZONAS">AM</option>
											<option value="BAHIA">BA</option>
											<option value="CEARA">CE</option>
											<option value="DISTRITO FEDERAL">DF</option>
											<option value="ESPIRITO SANTO">ES</option>
											<option value="GOIAS">GO</option>
											<option value="MARANHAO">MA</option>
											<option value="MATO GROSSO">MT</option>
											<option value="MATO GROSSO DO SUL">MS</option>
											<option value="MINAS GERAIS">MG</option>
											<option value="PARA">PA</option>
											<option value="PARAIBA">PB</option>
											<option value="PARANA">PR</option>
											<option value="PERNAMBUCO">PE</option>
											<option value="PIAUI">PI</option>
											<option value="RIO DE JANEIRO">RJ</option>
											<option value="RIO GRANDE DO NORTE">RN</option>
											<option value="RIO GRANDE DO SUL">RS</option>
											<option value="RONDONIA">RO</option>
											<option value="RORAIMA">RR</option>
											<option value="SANTA CATARINA">SC</option>
											<option value="SAO PAULO">SP</option>
											<option value="SERGIPE">SE</option>
											<option value="TOCANTINS">TO</option>
										</select>
										<span></span>
									</div> -->
						</fieldset>
						<div class="row g-3">
							<div class="col-sm-4"></div>
							<div class="col-sm-4 divButton">
								<button type="submit" class="col-12 btn btn-primary btn-sm">Cadastrar</button>
							</div>
							<div class="col-sm-4"></div>
						</div>
					</form>
					<!-- Formul??rio -->

				</div>
			</div>
		</div>
		<!--/CADASTRAR-->

		<!--CONSULTAR-->
		<div class="tab-pane fade" id="tabpanel3" role="tabpanel" aria-labelledby="tabButton3">
			<div class="container">
				<div class="box" id="main_box">

					<h2>Consultar Pacientes</h2>
					<!--Tabela de listagem do resultado-->
					<table class="table">
						<thead>
						  <tr>
							<th scope="col">Nome</th>
							<th scope="col">CPF</th>
							<th scope="col">Email</th>
							<th scope="col">Telefone</th>
						  </tr>

						<?php
						while ($row = $stmt_1->fetch()) {
				  
						  $nome = htmlspecialchars($row['nome']);
						  $cpf = htmlspecialchars($row['cpf']);
						  $email = htmlspecialchars($row['email']);
						  $telefone = htmlspecialchars($row['telefone']);
				  
						  echo <<<HTML
									<tr>
										<td>$nome</td> 
										<td>$cpf</td>
										<td>$email</td>
										<td>$telefone</td>
									</tr>      
								HTML;
							}
						?>
					</table>
				</div>
			</div>	
		</div>
		<!--/CONSULTAR-->

		<!--ALTERAR-->
		<div class="tab-pane fade" id="tabpanel4" role="tabpanel" aria-labelledby="tabButton4">

			<div class="container">
				<div class="box" id="main_box">

					<!-- Formul??rio -->
					<form action="restritoCadastraPaciente.php" name="formAlteraPaciente" method="POST">
						<fieldset>

							<h2>Alterar Paciente</h2>

							<form action="pesquisaPaciente" name="formConsultaPaciente" method="POST">
								<fieldset>
									<div class="col-sm-12">
									<label for="nome" class="form-label form-label-sm">Insira o nome do paciente</label>
									<input type="text" class="form-control form-control-sm" id="nomePaciente"name="nomePaciente">
								</fieldset>
							</form>

							<form action="#" name="formEditaPaciente" method="POST">
							<div class="row g-3">
								<div class="col-sm-8">
									<label for="nome" class="form-label form-label-sm">Nome</label>
									<input type="text" class="form-control form-control-sm" id="inputNome" name="nome">
								</div>
								<div class="col-sm-4">
								<label for="cpf" class="form-label form-label-sm">CPF</label>
									<input type="text" class="form-control form-control-sm" id="inputCPF" name="cpf"
										disabled="disabled">
								</div>
								<div class="col-sm-4">
									<label for="email" class="form-label form-label-sm">E-mail</label>
									<input type="email" class="form-control form-control-sm" id="inputEmail" name="email">
								</div>
								<div class="col-sm-4">
									<label for="telefone" class="form-label form-label-sm">Telefone</label>
									<input type="tel" class="form-control form-control-sm" id="inputTelefone" name="telefone">
								</div>
								<div class="col-sm-4">
									<label for="dataNascimento" class="form-label form-label-sm">Data Nascimento</label>
									<input type="date" class="form-control form-control-sm" id="intuptDN"
										name="dataNascimento" disabled="disabled">
								</div>     
								<div class="row g-3">
									<div class="col-sm-4"></div>
									<div class="col-sm-4 divButton">
										<button class="col-12 btn btn-primary btn-sm">Salvar Altera????es</button>
									</div>
									<div class="col-sm-4"></div>
								</div>

								<form>
									<input type="hidden" id= "123" name="ABC" value="Some Value">
									<input type="hidden" class="form-control form-control-sm" id="newnome" name="newnome"
										disabled="disabled">
								</form>

								<script>

								function buscaPaciente(nomePaciente) {

								let xhr = new XMLHttpRequest();
								xhr.open("GET", "pesquisaPaciente.php?nomePaciente=" + nomePaciente, true);

								xhr.onload = function () {
									
									// verifica o c??digo de status retornado pelo servidor
									if (xhr.status != 200) {
									console.error("Falha inesperada: " + xhr.responseText);
									return;
									}

									// converte a string JSON para objeto JavaScript
									try {
									var paciente = JSON.parse(xhr.responseText);
									}
									catch (e) {
									console.error("String JSON inv??lida: " + xhr.responseText);
									return;
									}

									const teste = document.getElementById("123");
									const inputNome = document.getElementById("inputNome");
									const inputCPF = document.getElementById("inputCPF");
									const inputEmail = document.getElementById("inputEmail");
									const inputTelefone = document.getElementById("inputTelefone");
									const inputDataNascimento = document.getElementById("intuptDN");


									if (paciente == null){
										inputNome.value = "null";
										inputCPF.value = "null";
										inputEmail.value = "null";
										inputTelefone.value = "null";
										inputDataNascimento.value = "null";
									}

									if (paciente != null){
										inputNome.value = paciente.nome;
										inputCPF.value = paciente.cpf;
										inputEmail.value = paciente.email;
										inputTelefone.value = paciente.telefone;
										inputDataNascimento.value = paciente.dataNascimento;
									}

								}

								xhr.onerror = function () {
									console.error("Erro de rede - requisi????o n??o finalizada");
								};

								xhr.send();
								}

								window.onload = function () {

								const inputPaciente = document.querySelector("#nomePaciente");

								inputPaciente.onkeyup = () => buscaPaciente(inputPaciente.value);
								}

								</script>
						</fieldset>

						
					</form>
					<!-- Formul??rio -->
			
				</div>
			</div>	
		</div>
		<!--/ALTERAR-->

		<!--DELETAR-->
		<div class="tab-pane fade" id="tabpanel5" role="tabpanel" aria-labelledby="tabButton5">

			<div class="container">
				<div class="box" id="main_box">

					<h2>Consultar Paciente</h2>
					<!--Formulario de consulta-->
					<div class="row g-3">
						<div class="col-sm-8">
							<label for="nome" class="form-label form-label-sm">Nome</label>
							<input type="text" class="form-control form-control-sm" id="nome" name="nome">
						</div>
						<div class="col-sm-4">
							<label for="cpf" class="form-label form-label-sm">CPF</label>
							<input type="text" class="form-control form-control-sm" id="cpf" name="cpf">
						</div>
						<button class="col-sm-4 btn btn-primary btn-sm" type="button">Exluir</button>
					</div>

				</div>
			</div>	
		</div>
		<!--/DELETAR-->

	</div>
	<!--/CONTEUDO DOS TABS-->
</main>

</html>