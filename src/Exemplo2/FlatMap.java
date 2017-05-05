package Exemplo2;
import java.util.stream.*;

/**
 * 
 * @author BRENO
 * FlapMap classe transformadoras de coleções
 * Stream método que diz quantas vezes irá aparecer a String
 */

public class FlatMap {
  public static void main(String[] args) {
    Stream.of(1, 1, 1) // Cada inteiro vale 1 repetição.
      .flatMap(
        i -> Stream.of("Hamurabi", "Vera", "Milton"))
      .forEach(System.out::println);
  }
}