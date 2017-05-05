package Exemplo3;

/**
 * 
 * @author BRENO
 * Numeracao classe que recebe um número para mapear com um fluxo 'Numeracao'
 */

public class Numeracao {
	
  final int n;
  Numeracao(int n) { this.n = n; }
  @Override
  public String toString() {
    return "Numerecao(" + n + ")";
  }
}
