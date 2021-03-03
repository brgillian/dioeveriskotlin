package one.digitalinnovationcollections
// Vídeo 07: Operações com Array max, min, average e filter
fun main(){
    fun separador() {
        println("----------------------------------------------")
    }

    val salarios = doubleArrayOf(1000.0, 2501.0, 400.0, 2250.0)

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

    // Vídeo 8: Operações com Arrays count, find e any

    println(salarios.count { it in 2000.0 ..5000.0 })
    separador()

    println(salarios.find { it == 2250.0 })
    separador()

    println(salarios.find{ it == 500.0 })
    separador()

    println(salarios.any { it == 1000.0 })
    separador()

    println(salarios.any { it == 500.0 })
    separador()
}