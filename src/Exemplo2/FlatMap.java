package Exemplo2;
import java.util.stream.*;

/**
 * 
 * @author BRENO
 * FlapMap classe transformadoras de cole��es
 * Stream m�todo que diz quantas vezes ir� aparecer a String
 */

public class FlatMap {
  public static void main(String[] args) {
    Stream.of(1, 1, 1) // Cada inteiro vale 1 repeti��o.
      .flatMap(
        i -> Stream.of("Hamurabi", "Vera", "Milton"))
      .forEach(System.out::println);
  }
}