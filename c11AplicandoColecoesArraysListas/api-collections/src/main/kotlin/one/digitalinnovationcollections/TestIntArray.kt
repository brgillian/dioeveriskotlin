package one.digitalinnovationcollections

fun main(){
     val values = IntArray(5)
    values[0] = 1
    values[1] = 7
    values[2] = 6
    values[3] = 3
    values[4] = 2

    for(valor in values){
        println(valor)
    }

    Separador()

    values.forEach { println(it) }

    Separador()

    values.forEach { valor -> println(valor) }

    Separador()

    for (index in values.indices){ println(values[index]) }

    Separador()

    values.sort()
    for (valor in values){ println(valor) }

}