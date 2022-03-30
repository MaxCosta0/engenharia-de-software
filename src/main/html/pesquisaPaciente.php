<?php

class Paciente
{
    public $nome;
    public $cpf;
    public $email;
    public $telefone;
    public $dataNascimento;

    function __construct($nome, $cpf, $email, $telefone, $dataNascimento) 
    {
        $this->nome = $nome;
        $this->cpf = $cpf;
		$this->email = $email;
		$this->telefone = $telefone;
		$this->dataNascimento = $dataNascimento;
    }
}

require "conexaoMysql.php";
$pdo = mysqlConnect();

if (isset($_GET["nomePaciente"]))
    $nomePaciente = $_GET["nomePaciente"];

try {
    $sql = <<<SQL
    SELECT nome, cpf, email, telefone, dataNascimento
    FROM paciente
    WHERE nome = ?
    SQL;

    $stmt = $pdo->prepare($sql);
    $stmt->execute([$nomePaciente]);

    $new_data = new DateTime($row['dataNascimento']);
    $dataNascimento = $new_data->format('Y-m-d');

	while ($row = $stmt->fetch()) {
				  
        $paciente = new Paciente($row['nome'], $row['cpf'], $row['email'], 
                                 $row['telefone'] , $dataNascimento);  

	}  

    echo json_encode($paciente);
} 
catch (Exception $e) {
    $msgErro = $e->getMessage();
    echo $msgErro;
}
