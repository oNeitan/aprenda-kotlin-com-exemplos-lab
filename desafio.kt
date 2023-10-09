enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

enum class AreaTI { APRENDIZADOMAQUINA, BACKEND, DADOS, FRONTEND, FULLSTACK }

data class Usuario(val id: Int, val nome: String, val idade: Int)

data class Professor(val nome: String, val areaTI: AreaTI)

data class ConteudoEducacional(var nome: String, val professor: Professor, val duracaoMin: Int)

data class Formacao(val nome: String, val areaTI: AreaTI, val nivel: Nivel, val vagas: Int, var conteudos: List<ConteudoEducacional>) {

    fun duracaoHoras(): Double {
        
      	var minutosTotais = 0
        for(ce in conteudos){ minutosTotais += ce.duracaoMin  }
     
        val horasTotais: Double = minutosTotais/60.0
        return horasTotais
   	}
    
   
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        
        if(usuario.idade < 16) 
        	{ println ("Desculpe, ${usuario.nome} 😢, alunos que possuem menos de 16 anos não podem se inscrever") } 
        else if(inscritos.size >= vagas ) 
        	{ println("Desculpe, ${usuario.nome} 😢, Não há vagas disponíveis para a formação $nome") } 
        else 
        	{ inscritos.add(usuario)
        	  println("O Usuario ${usuario.nome} foi matriculado com sucesso!")}
  	 }
}

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}