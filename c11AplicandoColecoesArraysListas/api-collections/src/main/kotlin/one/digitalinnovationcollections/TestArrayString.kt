package one.digitalinnovationcollections

fun main() {
    fun separador() {
        println("----------------------------------------------")
    }

    val nomes = Array(3) { "" } //Poderia ser: Array <String>(3){""}

    nomes[0] = "Maria"
    nomes[1] = "Zaza"
    nomes[2] = "José"

    for (nome in nomes) {
        println(nome)
    }
    separador()

    nomes.sort()
    nomes.forEach { println(it) }
    separador()

    val nomes2 = arrayOf("Maria", "Zazá", "Pedro")
    nomes2.sort()
    nomes2.forEach { println(it) }
}
