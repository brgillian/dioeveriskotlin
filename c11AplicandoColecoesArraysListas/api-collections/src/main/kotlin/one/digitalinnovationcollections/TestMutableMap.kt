package one.digitalinnovationcollections

fun main(){
    val joao = Funcionario("João", 2000.0, "CLT")
    val pedro = Funcionario("Pedro", 1500.0, "PJ")
    val maria = Funcionario("Maria", 4000.0, "CTL")

    val repositorio = Repositorio<Funcionario>()
    repositorio.create(joao.nome, joao)
    repositorio.create(pedro.nome, pedro)
    repositorio.create(maria.nome, maria)

    println(repositorio.findById(maria.nome))
    Separador()

    repositorio.findAll().forEach { println(it) }
    Separador()

    repositorio.remove(maria.nome)
    repositorio.findAll().forEach{ println(it) }

}