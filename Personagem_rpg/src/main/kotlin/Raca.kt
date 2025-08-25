interface Raca{
    val movimento: Int
    val infravisao: Int
    val alinhamento: String
    fun habilidadesEspecifica(): List<String>

}

class Humano: Raca{
    override val movimento = 9
    override val infravisao = 0
    override val alinhamento = "Qualquer um"
    override fun habilidadesEspecifica(): List<String>{
        return listOf(
            "Adaptabilidade: bônus de +1 em uma jogada de proteção à escolha.")
    }
}
class Elfo: Raca{
    override val movimento = 9
    override val infravisao = 18
    override val alinhamento = "Neutralidade"
    override fun habilidadesEspecifica(): List<String>{
        return listOf(
            "Percepção Natural: detectam portas secretas com chance especial em testes de percepção.",
            "Graciosos: bônus de +1 em qualquer teste de JPD (destreza).",
            "Arma Racial: +1 em ataques e danos com arcos.",
            "Imunidades: imunes a magias de sono e resistentes à paralisia de Ghouls.")
    }
}
class Anao: Raca{
    override val movimento = 6
    override val infravisao = 18
    override val alinhamento = "Ordem"
    override fun habilidadesEspecifica(): List<String>{
        return listOf(
            "Mineradores: detectam passagens, muralhas, armadilhas e portas escondidas com testes em 1d6.",
            "Vigoroso: recebem +1 em qualquer teste de JPC (constituição).",
            "Armas Grandes: só utilizam armas médias e pequenas, mas armas grandes forjadas por anões contam como médias.",

        )
    }
}