/*  Introdução a programação em Kotlin
    Desafio 2/3 - Números ìmpares

    Leia um valor inteiro X (1 <= X <= 1000). Em seguida mostre os ímpares de 1 
    até X, um valor por linha, inclusive o X, se for o caso.

    Entrada:
    O arquivo de entrada contém 1 valor inteiro qualquer.

    Saída:
    Imprima todos os valores ímpares de 1 até X, inclusive X, se for o caso.

    Exemplo de Entrada              Exemplo de Saída
    8                               1
                                    3  
                                    5
                                    7

*/

fun main(){
    val num = readLine()!!.toInt()

    if(num >=1 && num <= 1000){
        for (i in 1..num step 2) println(i)
    }

}