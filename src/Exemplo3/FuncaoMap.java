package Exemplo3;

import java.util.stream.Stream;

/**
 * 
 * @author BRENO
 * FuncaoMap classe que recebe n�meros e mostra seu mapeamento 
 * Map m�todo que retorna um fluxo atraves dos resultados da aplica��o da
 * fun��o dada aos elementos do fluxo.
 * ForEach Opera��o N�o-Determin�stica. N�o garante ordem do fluxo, pois
 * n�o atenderia aos conceitos do paralelismo.
 */

public class FuncaoMap {
  public static void main(String[] args) {
    Stream.of(1, 3, 5, 7, 9, 11, 13, 15)
      .map(Numeracao::new)
      .forEach(System.out::println);
  }
}