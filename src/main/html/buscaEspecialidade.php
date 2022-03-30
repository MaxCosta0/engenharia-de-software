<?php

class DadosMedicos {
    public $nome_medico;

    function __construct($nome_medico) 
    {
        $this->nome_medico = $nome_medico;
    }
}

require "conexaoMysql.php";
$pdo = mysqlConnect();

$especialidade = "";

if (isset($_GET["especialidade"]))
    $especialidade = $_GET["especialidade"];

try {
    $sql = <<<SQL
    SELECT nome
    FROM medico 
    WHERE especialidade = ?
SQL;

    $stmt = $pdo->prepare($sql);
    $stmt->execute([$especialidade]);

    $arrayDadosMedicos = [];

    while ($row = $stmt->fetch()) {

        $dadosMedicos = new DadosMedicos($row['nome']);

        $arrayDadosMedicos [] = $dadosMedicos;
    }
    
    echo json_encode($arrayDadosMedicos);
}
catch (Exception $e)
{
    http_response_code(500);

    $msgErro = $e->getMessage();
    echo $msgErro;
}
