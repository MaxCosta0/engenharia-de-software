
<?php
function php_func(){
echo "Stay Safe";
}
?>
<button onclick="clickMe()"> Click </button>

<script>

function clickMe(){
var result ="<?php php_func(); ?>"
document.write(result);
}
</script>
<h2>Pesquisar Consultas</h2>