<?php

require_once "conexaoMysql.php";
$pdo = mysqlConnect();

$nome = $cpf = $email = $telefone = $dataNascimento = "";

if (isset($_POST["nome"]))
  $nome = $_POST["nome"];

if (isset($_POST["cpf"]))
  $cpf = $_POST["cpf"];

if (isset($_POST["email"]))
  $email = $_POST["email"];

if (isset($_POST["telefone"]))
  $telefone = $_POST["telefone"];

if (isset($_POST["dataNascimento"]))
  $dataNascimento = $_POST["dataNascimento"];

$sql = <<<SQL
  INSERT INTO paciente 
    (nome, cpf, email, telefone, dataNascimento)
  VALUES (?, ?, ?, ?, ?)
SQL;

try {
  $pdo->beginTransaction();

  $stmt = $pdo->prepare($sql);
  if (!$stmt->execute([
    $nome, $cpf, $email, $telefone, $dataNascimento
  ])) throw new Exception('Falha na inserção');

  $pdo->commit();

  header("location: restritoPaciente.php");
  exit();
} 
catch (Exception $e) {
  $pdo->rollBack();
  if ($e->errorInfo[1] === 1062)
    exit('Dados duplicados: ' . $e->getMessage());
  else
    exit('Falha ao cadastrar os dados: ' . $e->getMessage());
}
