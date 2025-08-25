fun main() {
    //escoha do estilo
    println("Escolha o estilo:")
    println("1 - Clássico")
    println("2 - Aventureiro")
    println("3 - Heróico")
    print("Digite o número da sua escolha: ")

    val escolhaEstilo = readLine()?.toIntOrNull()

    val estilo: Estilo? = when (escolhaEstilo) {
        1 -> Classico()
        2 -> Aventureiro()
        3 -> Heroico()
        else -> null
    }

    if (estilo != null) {
        val rol = estilo.gerarRolagens()
        val atributos = estilo.distribuir(rol)

        println("\nRolagens: $rol")
        println("Atributos finais:")
        atributos.forEach { (nome, valor) ->
            println("$nome: $valor")
        }
        //escolha da raça
        println("\nEscolha sua Raça:")
        println("1 - Humano")
        println("2 - Elfo")
        println("3 - Anão")
        print("Digite o número da sua escolha: ")

        val escolhaRaca = readLine()?.toIntOrNull()
        val raca: Raca = when (escolhaRaca) {
            1 -> Humano()
            2 -> Elfo()
            3 -> Anao()
            else -> {
                println("Opção inválida! Será criado um Humano por padrão.")
                Humano()
            }
        }

      //escolha da classe
        println("\nEscolha sua Classe")
        println("1 - Guerreiro")
        println("2 - Clérigo")
        println("3 - Ladrão")
        print("Digite o número da sua escolha: ")

        val escolhaClasse = readLine()?.toIntOrNull()
        val classe: Classe = when (escolhaClasse) {
            1 -> Guerreiro()
            2 -> Clerigo()
            3 -> Ladrao()
            else -> {
                println("Opção inválida! Será criado um Guerreiro por padrão.")
                Guerreiro()
            }
        }

     //demostração dos valores finais
        println("\nFicha do Personagem")
        println("Raça: ${raca.javaClass.simpleName}")
        println("Classe: ${classe.javaClass.simpleName}")
        println("Movimento: ${raca.movimento} metros")
        println("Infravisão: ${raca.infravisao} metros")
        println("Alinhamento: ${raca.alinhamento}")
        println("Habilidades Raciais:")
        raca.habilidadesEspecifica().forEach { println(" - $it") }

        println("\nProgresso da Classe:")
        classe.exibirNivel(1) // Exemplo: mostra os dados do nível 1
    } else {
        println("Opção de estilo inválida!")
    }
}
