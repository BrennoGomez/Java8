package Exemplo3;

import java.util.stream.Stream;

/**
 * 
 * @author BRENO
 * FuncaoMap classe que recebe números e mostra seu mapeamento 
 * Map método que retorna um fluxo atraves dos resultados da aplicação da
 * função dada aos elementos do fluxo.
 * ForEach Operação Não-Determinística. Não garante ordem do fluxo, pois
 * não atenderia aos conceitos do paralelismo.
 */

public class FuncaoMap {
  public static void main(String[] args) {
    Stream.of(1, 3, 5, 7, 9, 11, 13, 15)
      .map(Numeracao::new)
      .forEach(System.out::println);
  }
}