package Exemplo1;
import java.util.function.*;

/**
 * 
 * @author BRENO
 * Funcao interface que extende de Function e recebe um método apply, que produz
 * um resultado
 */

interface Funcao extends Function<String, String> {}

/**
 * 
 * @author BRENO
 * TransformaCaixaAltaBaixa classe que produz uma função para transformar formatos
 * de caixa alta em caixa baixa.
 */

public class TransformaCaixaAltaBaixa {
  static Funcao produz() {
    return s -> s.toLowerCase(); // [2]
  }
  
  public static void main(String[] args) {
    Funcao f = produz();
    System.out.println(f.apply("PARADIGMAS E LINGUAGENS DE PROGRAMAÇÃO"));
  }
}