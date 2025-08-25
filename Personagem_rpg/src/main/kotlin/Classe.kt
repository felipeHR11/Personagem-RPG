// Classe abstrata
abstract class Classe {
    abstract var nivel: Int
    abstract var xpAtual: Int

    abstract fun xpNecessario(): Int
    abstract fun pontosVida(): String
    abstract fun baseAtaque(): Int
    abstract fun jogadaProtecao(): Int
    abstract fun xpEspecial(): Int
    abstract fun exibirNivel(nivel: Int)
}

// ----------------------
// GUERREIRO
// ----------------------
class Guerreiro(
    override var nivel: Int = 1,
    override var xpAtual: Int = 0
) : Classe() {

    private val xpPorNivel = listOf(0, 2000, 4000, 7000, 10000, 20000, 30000, 40000, 50000, 100000)
    private val baseAtaquePorNivel = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    private val jogadaProtecaoPorNivel = listOf(5, 5, 6, 6, 8, 8, 10, 10, 11, 11)
    private val xpEspecialPorNivel = listOf(0, 2500, 5000, 8500, 11500, 23000, 33000, 43000, 53000, 106000)

    override fun xpNecessario(): Int = xpPorNivel.getOrElse(nivel - 1) { xpPorNivel.last() }
    override fun pontosVida(): String = if (nivel == 1) "10" else "+1d10"
    override fun baseAtaque(): Int = baseAtaquePorNivel.getOrElse(nivel - 1) { baseAtaquePorNivel.last() }
    override fun jogadaProtecao(): Int = jogadaProtecaoPorNivel.getOrElse(nivel - 1) { jogadaProtecaoPorNivel.last() }
    override fun xpEspecial(): Int = xpEspecialPorNivel.getOrElse(nivel - 1) { xpEspecialPorNivel.last() }

    override fun exibirNivel(nivel: Int) {
        println("Nível $nivel")
        println("XP Necessário: ${xpNecessario()}")
        println("Vida: ${pontosVida()}")
        println("Ataque Base: ${baseAtaque()}")
        println("Jogada de Proteção: ${jogadaProtecao()}")
        println("XP Especial: ${xpEspecial()}")
    }
}

// ----------------------
// CLÉRIGO
// ----------------------
class Clerigo(
    override var nivel: Int = 1,
    override var xpAtual: Int = 0
) : Classe() {

    private val xpPorNivel = listOf(0, 1500, 3000, 5500, 8500, 17000, 27000, 37000, 47000, 94000)
    private val baseAtaquePorNivel = listOf(1, 1, 1, 3, 3, 5, 5, 5, 5, 7)
    private val jogadaProtecaoPorNivel = listOf(5, 5, 5, 7, 7, 9, 9, 9, 9, 11)
    private val xpEspecialPorNivel = listOf(0, 2000, 4000, 7000, 10000, 20000, 30000, 40000, 50000, 100000)

    private val magiasDivinas = listOf(
        listOf(1, 0, 0, 0, 0, 0, 0), // 1º nível
        listOf(2, 0, 0, 0, 0, 0, 0), // 2º
        listOf(2, 1, 0, 0, 0, 0, 0), // 3º
        listOf(2, 2, 0, 0, 0, 0, 0), // 4º
        listOf(2, 2, 1, 0, 0, 0, 0), // 5º
        listOf(3, 2, 1, 0, 0, 0, 0), // 6º
        listOf(3, 2, 2, 0, 0, 0, 0), // 7º
        listOf(3, 3, 2, 1, 0, 0, 0), // 8º
        listOf(3, 3, 2, 1, 1, 0, 0), // 9º
        listOf(4, 3, 3, 2, 1, 1, 0)  // 10º
    )

    override fun xpNecessario(): Int = xpPorNivel.getOrElse(nivel - 1) { xpPorNivel.last() }
    override fun pontosVida(): String = if (nivel == 1) "8" else "+1d8"
    override fun baseAtaque(): Int = baseAtaquePorNivel.getOrElse(nivel - 1) { baseAtaquePorNivel.last() }
    override fun jogadaProtecao(): Int = jogadaProtecaoPorNivel.getOrElse(nivel - 1) { jogadaProtecaoPorNivel.last() }
    override fun xpEspecial(): Int = xpEspecialPorNivel.getOrElse(nivel - 1) { xpEspecialPorNivel.last() }

    fun magiasDisponiveis(): List<Int> = magiasDivinas.getOrElse(nivel - 1) { magiasDivinas.last() }

    override fun exibirNivel(nivel: Int) {
        println("Nível $nivel")
        println("XP Necessário: ${xpNecessario()}")
        println("Vida: ${pontosVida()}")
        println("Ataque Base: ${baseAtaque()}")
        println("Jogada de Proteção: ${jogadaProtecao()}")
        println("XP Especial: ${xpEspecial()}")
        println("Magias disponíveis: ${magiasDisponiveis()}")
    }
}

// LADRÃO

class Ladrao(
    override var nivel: Int = 1,
    override var xpAtual: Int = 0
) : Classe() {

    private val xpPorNivel = listOf(0, 1000, 2000, 4000, 7000, 14000, 24000, 34000, 44000, 88000)
    private val baseAtaquePorNivel = listOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)
    private val jogadaProtecaoPorNivel = listOf(5, 5, 5, 5, 8, 8, 8, 8, 11, 11)
    private val xpEspecialPorNivel = listOf(0, 1500, 3000, 5500, 8500, 17000, 27000, 37000, 47000, 94000)

    override fun xpNecessario(): Int = xpPorNivel.getOrElse(nivel - 1) { xpPorNivel.last() }
    override fun pontosVida(): String = if (nivel == 1) "6" else "+1d6"
    override fun baseAtaque(): Int = baseAtaquePorNivel.getOrElse(nivel - 1) { baseAtaquePorNivel.last() }
    override fun jogadaProtecao(): Int = jogadaProtecaoPorNivel.getOrElse(nivel - 1) { jogadaProtecaoPorNivel.last() }
    override fun xpEspecial(): Int = xpEspecialPorNivel.getOrElse(nivel - 1) { xpEspecialPorNivel.last() }

    override fun exibirNivel(nivel: Int) {
        println("Ladrão - Nível $nivel")
        println("XP Necessário: ${xpNecessario()}")
        println("Vida: ${pontosVida()}")
        println("Ataque Base: ${baseAtaque()}")
        println("Jogada de Proteção: ${jogadaProtecao()}")
        println("XP Especial: ${xpEspecial()}")
    }
}
