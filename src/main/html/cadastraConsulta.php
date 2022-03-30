<?php
    
require "conexaoMysql.php";
$pdo = mysqlConnect();
    
$nome = $email = "";
$dataConsulta = $horarioConsulta = "";

if (isset($_POST["nome"]))
    $nome = $_POST["nome"];

if (isset($_POST["email"]))
    $email = $_POST["email"];

    if (isset($_POST["especialidade"]))
    $especialidade = $_POST["especialidade"];

if (isset($_POST["medicoEspecialista"]))
    $medicoEspecialista = $_POST["medicoEspecialista"];

if (isset($_POST["dataConsulta"]))
    $dataConsulta = $_POST["dataConsulta"];

if (isset($_POST["horarioConsulta"]))
    $horarioConsulta = $_POST["horarioConsulta"];


try {

  $sql = <<<SQL
  INSERT INTO agenda (nome, email, especialidade, nomeMedico, dataConsulta, horarioConsulta)
  VALUES (?, ?, ?, ?, ?, ?)
SQL;
 
  $stmt = $pdo->prepare($sql);
  $stmt->execute([$nome, $email, $especialidade, $medicoEspecialista, $dataConsulta, $horarioConsulta]);

  header("location: restritocadastrarPaciente.php");
  exit();
} 
catch (Exception $e) {  
  //error_log($e->getMessage(), 3, 'log.php');
  if ($e->errorInfo[1] === 1062)
    exit('Dados duplicados: ' . $e->getMessage());
  else
    exit('Falha ao cadastrar os dados: ' . $e->getMessage());
}