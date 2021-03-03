package one.digitalinnovationcollections

fun main(){
    fun separador() {
        println("----------------------------------------------")
    }

    val salarios = doubleArrayOf(1000.0, 2501.0, 400.0)

    for (salario in salarios){
        println(salario)
    }
    separador()

    println("Maior salário: ${salarios.max()}")
    println("Menor salário: ${salarios.min()}")
    println("Media salário: ${salarios.average()}")
    separador()

    val salariosMaioresQue2500 = salarios.filter{ it > 2500.0 }
    salariosMaioresQue2500.forEach { println(it) }
    separador()
}