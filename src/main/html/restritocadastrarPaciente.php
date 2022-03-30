<?php

require "conexaoMysql.php";
$pdo = mysqlConnect();

try {

  $sql = <<<SQL
  SELECT DISTINCT especialidade
  FROM medico
  WHERE flag=0
  SQL;
 
  $stmt = $pdo->query($sql);

} catch (Exception $e) {
  // error_log($e->getMessage(), 3, 'log.php');
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
				aria-controls="tabpanel2">Marcar Consulta</a>
		</li>
		<li class="nav-item" role="presentation">
			<a class="nav-link" id="tabButton3" href="#tabpanel3" data-toggle="tab" role="tab"
				aria-controls="tabpanel3">Visualizar Minhas Consultas</a>
		</li>
		<li class="nav-item" role="presentation">
			<a class="nav-link" id="tabButton4" href="#tabpanel4" data-toggle="tab" role="tab"
				aria-controls="tabpanel4">Desmarcar Consulta</a>
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

				<div class="container">

					<form action="cadastraConsulta.php" name="formAgendamento" method="POST" >
						<fieldset>
							<h2>Agendar Consulta</h2>
								
								<div class="row g-3">
									<div class="col-sm-6">
										<label for="nome" class="form-label form-label-sm">Nome</label>
										<input type="text" class="form-control form-control-sm" id="nome" name="nome">
									</div>
									<div class="col-sm-6">
										<label for="email" class="form-label form-label-sm">E-mail</label>
										<input type="email" class="form-control form-control-sm" id="email" name="email">
									</div>
									<script>console.log("aqui")</script>
									<div class="col-sm-6">
										<label for="especialidade" class="form-label form-label-sm">Especialidade</label>
										<select class="form-select form-select-sm" name="especialidade" id="selectEspecialidade">
											<option value="Selecione">Selecione</option>
											<?php
											while ($row = $stmt->fetch()) {
												$especialidade = htmlspecialchars($row['especialidade']);
												echo <<<HTML
													<option value="$especialidade">$especialidade</option>
												HTML;
											}
											?>
										</select>
										<script>console.log("aqui")</script>
									</div>
									<div class="col-sm-6">
										<label for="medicoEspecialista" class="form-label form-label-sm">Médico Especialista</label>
										<select class="form-select form-select-sm" name="medicoEspecialista" id="medicoEspecialista">
										</select>
									</div>
									<div class="col-sm-6">
										<label for="dataConsulta" class="form-label form-label-sm">Data Consulta</label>
										<input type="date" class="form-control form-control-sm" id="newDataConsulta" name="dataConsulta">
									</div>
									<div class="col-sm-6">
										<label for="horarioConsulta" class="form-label form-label-sm">Horário disponivel</label>
										<select class="form-select form-select-sm" name="horarioConsulta" id="horarioConsulta">
											<option value="8">08:00</option>
											<option value="9">09:00</option>
											<option value="10">10:00</option>
											<option value="11">11:00</option>
											<option value="12">12:00</option>
											<option value="13">13:00</option>
											<option value="14">14:00</option>
											<option value="15">15:00</option>
											<option value="16">16:00</option>
											<option value="17">17:00</option>
										</select>

									</div>
								</div>
						</fieldset>
						<div class="row g-3">
							<div class="col-sm-4"></div>
							<div class="col-sm-4 divButton">
								<button type="submit" class="col-12 btn btn-primary btn-sm">Agendar Consulta</button>
							</div>
							<div class="col-sm-4"></div>
						</div>
					</form>

						<script>

							window.onload = function () {
								
								const inputEspecialidade = document.getElementById("selectEspecialidade");
								inputEspecialidade.onchange = () => atualizaCampoMedicoEspecialista(inputEspecialidade.value);

								const inputDataConsulta = document.getElementById("newDataConsulta");
								inputDataConsulta.onchange = () => atualizaCampoHorarioConsulta(inputDataConsulta.value);
							}


							function atualizaCampoMedicoEspecialista(especialidade) {
								let campoSelectMedico = document.getElementById("medicoEspecialista");
								while (campoSelectMedico.options.length > 0) {                
									campoSelectMedico.remove(0);
								}  

								buscaEspecialidade(especialidade);
							}


							function buscaEspecialidade(especialidade) {

								let xhr = new XMLHttpRequest();
								xhr.open("GET", "buscaEspecialidade.php?especialidade=" + especialidade, true);

								xhr.onload = function () {

									if (xhr.status != 200) {
										console.error("Falha inesperada: " + xhr.responseText);
										return;
									}

									try {
										var dadosMedicos = JSON.parse(xhr.responseText);
									}
									catch (e) {
										console.error("String JSON inválida: " + xhr.responseText);
										return;
									}

									let campoSelect = document.getElementById("medicoEspecialista"); 
									dadosMedicos.forEach(elemento => {
										var option = document.createElement("option"); 
										option.text = elemento.nome_medico;
										option.value = elemento.nome_medico;
										campoSelect.add(option);
									});
								}

								xhr.onerror = function () {
									console.error("Erro de rede - requisição não finalizada");
								};

								xhr.send();
							}

						</script>
					</div>
				</div>
			</div>
		</div>
		<!--/CADASTRAR-->

		<!--PESQUISAR CONSULTAS-->
		<div class="tab-pane fade" id="tabpanel3" role="tabpanel" aria-labelledby="tabButton3">

			<div class="container">
				<div class="box" id="main_box">

				<h2>Pesquisar Consultas</h2>

				<form action="#" name="formConsultaPaciente" method="POST">
					<fieldset>
						<div class="row g-3">
							<div class="col-sm-8">
								<input type="text" class="form-control form-control-sm" id="inputNomePaciente"name="inputNomePaciente">
							</div>
							<div class="col-sm-4">
							<button class="col-sm-3 btn btn-primary btn-sm">Pesquisar</button>
						</div>	
						</div>
					</fieldset>

				</form>
				
				</div>
			</div>	
		</div>
		<!--PESQUISAR CONSULTAS-->

		<!--ALTERAR-->
		<div class="tab-pane fade" id="tabpanel4" role="tabpanel" aria-labelledby="tabButton4">

			<div class="container">
				<div class="box" id="main_box">

					<h2>Teste</h2>

				</div>
			</div>	
		</div>
		<!--/ALTERAR-->
		
	</div>
	<!--/CONTEUDO DOS TABS-->
</main>

</html>