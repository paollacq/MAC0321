package EXTRA;

/*  
Explicação do Código

Configuração das Iterações:
Definimos um número de iterações (ITERACOES = 100000) para garantir que o teste seja significativo.

-> Teste com >String<:

Iniciamos uma string vazia str. Após a inicialização, medimos o tempo antes e depois do loop 
que concatena "a" à string str repetidamente. Finalmente, calculamos a duração do teste para 
a comparação final.

-> Teste com >StringBuffer<:

Iniciamos um StringBuffer vazio strBuffer. Após a inicialização medimos o tempo antes e depois
do loop que adiciona "a" ao StringBuffer strBuffer repetidamente. Finalmente, calculamos a 
duração do teste.

-> Resultados:

Imprimimos o tempo gasto em nanosegundos para cada teste no terminal.
Explicamos a razão pela qual StringBuffer é mais eficiente para operações repetidas de concatenação:

String: É imutável, o que significa que cada operação de concatenação cria um novo objeto, resultando
em um overhead de tempo e memória.

StringBuffer: É mutável e projetado para operações de concatenação, não criando novos objetos para 
cada operação, tornando-a mais eficiente.
*/

public class ComparacaoStrings {
    public static void main(String[] args) {
        final int ITERACOES = 100000;
        long tempoInicial, tempoFinal;

        // Teste com String
        String str = "";
        tempoInicial = System.nanoTime();
        for (int i = 0; i < ITERACOES; i++) {
            str += "a";
        }
        tempoFinal = System.nanoTime();
        long duracaoString = tempoFinal - tempoInicial;

        // Teste com StringBuffer
        StringBuffer strBuffer = new StringBuffer();
        tempoInicial = System.nanoTime();
        for (int i = 0; i < ITERACOES; i++) {
            strBuffer.append("a");
        }
        tempoFinal = System.nanoTime();
        long duracaoStringBuffer = tempoFinal - tempoInicial;

        // Resultados
        System.out.println("Tempo com String: " + duracaoString + " nanosegundos");
        System.out.println("Tempo com StringBuffer: " + duracaoStringBuffer + " nanosegundos");

        // Explicação
        System.out.println("\nExplicação:");
        System.out.println("A classe String é imutável, o que significa que cada operação de concatenação cria um novo objeto String.\n Isso resulta em overhead de tempo e memória.");
        System.out.println("Por outro lado, a classe StringBuffer é mutável e foi projetada para operações de concatenação de Strings.\n Ela não cria novos objetos para cada concatenação, tornando-a mais eficiente em termos de tempo e memória \n para operações repetidas.");
    }
}
