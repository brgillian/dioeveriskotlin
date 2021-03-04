package one.digitalinnovationcollections
fun main(){

    val joao = Funcionario("Joao",  1000.0, "CLT")
    val pedro = Funcionario("Pedro", 2000.0, "PJ")
    val maria = Funcionario("Maria", 4000.0, "CLT")

    val funcionarios = listOf(joao, pedro, maria)
    funcionarios.forEach { println(it) }
    Separador()

    println(funcionarios.find {it.nome == "Maria" })

    Separador()

    funcionarios
        .sortedBy { it.salario }
        .forEach { println(it) }
    Separador()

    funcionarios
        .groupBy { it.tipoContratacao }
        .forEach { println(it) }


}



