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
    
    val Usuario1 = Usuario(1, "Natan Santos", 20)
    val Usuario2 = Usuario(2, "Lucas Fernandes", 15) 
	val Usuario3 = Usuario(3, "Luiza Souza", 18)
    val Usuario4 = Usuario(4, "Ester Heloisa", 19)
                           
    val Prof1 = Professor("Jorge Ramiro", AreaTI.BACKEND)
    
    val Aula1 = ConteudoEducacional("Introdução", Prof1, 30)
    val Aula2 = ConteudoEducacional("Orientação a Objetos", Prof1, 60)
    val AulasJavaOO = mutableListOf(Aula1, Aula2)
    
    val JavaOO = Formacao(
        "Java Orientado a Objetos",
        AreaTI.BACKEND,
        Nivel.BASICO,
        vagas = 2,
        AulasJavaOO
    )
    
    JavaOO.matricular(Usuario1)
    JavaOO.matricular(Usuario2)
    JavaOO.matricular(Usuario3)
    JavaOO.matricular(Usuario4)
    
    println()
 	println("""|Formação ${JavaOO.nome}
    		   |------------------------
               |Área de estudo: ${JavaOO.areaTI}
               |Nível: ${JavaOO.nivel} 
               |Duração do curso: ${JavaOO.duracaoHoras()} horas
               """.trimMargin())
}
