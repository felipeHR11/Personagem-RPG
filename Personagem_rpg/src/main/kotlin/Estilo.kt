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
        // aqui simulamos que o jogador escolhe — colocamos os maiores nos primeiros atributos
        val ordenado = rolagens.sortedDescending()
        return Estilo.nomesAtributos.zip(ordenado).toMap()
    }
}

class Heroico : Estilo {
    private fun rolar4d6DescartarMenor(): Int {
        val dados = (1..4).map { Random.nextInt(1, 7) }.sortedDescending()
        return dados.take(3).sum()
    }

    override fun gerarRolagens() = List(6) { rolar4d6DescartarMenor() }

    override fun distribuir(rolagens: List<Int>): Map<String, Int> {
        val ordenado = rolagens.sortedDescending()
        return Estilo.nomesAtributos.zip(ordenado).toMap()
    }
}