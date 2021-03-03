package one.digitalinnovation.collections

fun main(){
    fun separador(){
        println("----------------------------------------------")
    }

    val values = intArrayOf(2, 3, 4, 1, 10, 7)

    values.forEach { println(it) }

    separador()

    values.sort()
    values.forEach{ println(it) }

}