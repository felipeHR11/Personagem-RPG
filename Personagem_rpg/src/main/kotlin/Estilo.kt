import kotlin.random.Random

//interface comum a todos os estilos
interface Estilo {
    fun gerarRolagens(): List<Int>
    fun distribuir(rolagens: List<Int>): Map<String, Int>

    companion object {
        val nomesAtributos = listOf("Força", "Destreza", "Constituição", "Inteligência", "Sabedoria", "Carisma")
    }
}

// estilos

class Classico : Estilo {
    private fun rolar3d6() = (1..3).sumOf { Random.nextInt(1, 7) }

    override fun gerarRolagens() = List(6) { rolar3d6() }

    override fun distribuir(rolagens: List<Int>): Map<String, Int> =
        Estilo.nomesAtributos.zip(rolagens).toMap() // clássico é em ordem
}

class Aventureiro : Estilo {
    private fun rolar3d6() = (1..3).sumOf { Random.nextInt(1, 7) }

    override fun gerarRolagens() = List(6) { rolar3d6() }

    override fun distribuir(rolagens: List<Int>): Map<String, Int> {
        val atributosEscolhidos = mutableMapOf<String, Int>()
        val disponiveis = rolagens.toMutableList()

        println("Rolagens disponíveis: $disponiveis")

        for (atributo in Estilo.nomesAtributos) {
            println("Escolha um valor para $atributo entre $disponiveis:")
            var escolha: Int
            while (true) {
                val entrada = readLine()
                escolha = entrada?.toIntOrNull() ?: -1
                if (disponiveis.contains(escolha)) {
                    break
                } else {
                    println("Valor inválido. Tente novamente.")
                }
            }
            atributosEscolhidos[atributo] = escolha
            disponiveis.remove(escolha)
        }
        return atributosEscolhidos
    }
}

class Heroico : Estilo {
    private fun rolar4d6DescartarMenor(): Int {
        val dados = (1..4).map { Random.nextInt(1, 7) }.sortedDescending()
        return dados.take(3).sum()
    }

    override fun gerarRolagens() = List(6) { rolar4d6DescartarMenor() }

    override fun distribuir(rolagens: List<Int>): Map<String, Int> {
        val atributosEscolhidos = mutableMapOf<String, Int>()
        val disponiveis = rolagens.toMutableList()

        println("Rolagens disponíveis: $disponiveis")

        for (atributo in Estilo.nomesAtributos) {
            println("Escolha um valor para $atributo entre $disponiveis:")
            var escolha: Int
            while (true) {
                val entrada = readLine()
                escolha = entrada?.toIntOrNull() ?: -1
                if (disponiveis.contains(escolha)) {
                    break
                } else {
                    println("Valor inválido. Tente novamente.")
                }
            }
            atributosEscolhidos[atributo] = escolha
            disponiveis.remove(escolha)
        }
        return atributosEscolhidos
    }
}