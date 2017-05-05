package Exemplo6;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * 
 * @author BRENO
 * Principal Resultado da execu��o de m�todos.
 */

public class Principal {
    public static void main(String[] args) throws IOException {
    Principal p = new Principal();
    JogadorImpl jogImpl = new JogadorImpl();
    String enderecoDir = "C:\\Users\\BRENO\\workspace\\Java8\\src\\Exemplo6";
    String nomeArquivo = "jogadores.txt";
   List listaDeJogadores =  jogImpl.getListaDeJogadores(Paths.get(enderecoDir + "\\" + nomeArquivo));    
    if (!jogImpl.verificarArquivoExiste(Paths.get(enderecoDir))){
        System.out.println("Arquivo n�o encontrado");
    }
    else {    
        jogImpl.imprimirJogadorArtilheiro(listaDeJogadores);
        jogImpl.imprimirJogadorMaisVelho(listaDeJogadores);
        jogImpl.imprimirJogadorMaisNovo(listaDeJogadores);
       }
    System.out.println("M�dia de idade: " + jogImpl.calcularMediaIdade(listaDeJogadores));
    System.out.println("Somat�rio de gols: " + jogImpl.imprimirSomatorioGols(listaDeJogadores));
    
    }
}
