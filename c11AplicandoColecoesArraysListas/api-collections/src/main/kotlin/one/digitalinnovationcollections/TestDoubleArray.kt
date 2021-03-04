package one.digitalinnovationcollections

fun main(){

    val salarios = DoubleArray(3)
    salarios[0] = 1000.0
    salarios[1] = 3000.0
    salarios[2] = 500.0

    salarios.forEach { println(it) }
    Separador()

    salarios.forEachIndexed { index, salario ->
        salarios[index] = salario * 1.1
    }
    salarios.forEach { println(it) }
    Separador()

    val salarios2 = doubleArrayOf(1500.0, 1250.0, 5000.0)
    salarios2.sort()
    salarios.forEach { println(it) }
}