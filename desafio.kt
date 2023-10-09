enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

enum class AreaTI { APRENDIZADOMAQUINA, BACKEND, DADOS, FRONTEND, FULLSTACK }

data class Usuario(val id: Int, val nome: String, val idade: Int)

data class Professor(val nome: String, val areaTI: AreaTI)

data class ConteudoEducacional(var nome: String, val professor: Professor, val duracaoMin: Int)

data class Formacao(val nome: String, val areaTI: AreaTI, val nivel: Nivel, val vagas: Int, var conteudos: List<ConteudoEducacional>) {
    
    //TODO: val duracaoHoras: Int 

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
}

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}