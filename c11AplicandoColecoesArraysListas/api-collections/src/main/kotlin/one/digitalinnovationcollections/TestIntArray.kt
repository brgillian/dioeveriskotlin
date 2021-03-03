package one.digitalinnovation.collections

fun main(){
    fun separador(){
        println("----------------------------------------------")
    }

    val values = IntArray(5)    //É preciso informar o tamanho do array.
    values[0] = 1
    values[1] = 7
    values[2] = 6
    values[3] = 3
    values[4] = 2

    for(valor in values){
        println(valor)
    }

    separador()

    values.forEach { println(it) }

    separador()

    values.forEach { valor -> println(valor) }

    separador()

    for (index in values.indices){ println(values[index]) }

    separador()

    values.sort()
    for (valor in values){ println(valor) }

}