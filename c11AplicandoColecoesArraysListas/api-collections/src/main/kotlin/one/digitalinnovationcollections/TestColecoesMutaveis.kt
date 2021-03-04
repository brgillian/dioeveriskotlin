package one.digitalinnovationcollections

fun main(){
    val joao = Funcionario("Joao", 2000.0, "CLT")
    val pedro = Funcionario("Pedro", 1500.0, "PJ")
    val maria = Funcionario("Maria", 4000.0, "CLT")

    println("************* List **************")
    val funcionarios = mutableListOf(joao, maria)
    funcionarios.forEach { println(it) }
    Separador()

    funcionarios.add(pedro)
    funcionarios.forEach { println(it) }
    Separador()

    funcionarios.remove(joao)
    funcionarios.forEach { println(it) }

    println("************* SET **************")
    val funcionarioSet = mutableSetOf(joao)
    funcionarioSet.forEach { println(it) }
    Separador()


    funcionarioSet.add(pedro)
    funcionarioSet.add(maria)
    funcionarioSet.forEach { println(it) }
    Separador()

    funcionarioSet.remove(maria)
    funcionarioSet.forEach { println(it) }
}