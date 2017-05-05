package Exemplo5;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author BRENO
 * MapReduce classe onde temos um array com inteiros onde são somados,
 * multiplicados por dois e dando o resultado
 */

public class MapReduce {

	public static void main(String[] args) {
		List<Integer> valores = Arrays.asList(1,2,3,4,5,6);

		int resultado=0;
		
		for (int i : valores){
			resultado = resultado + i*2;
		}
		
		System.out.println(resultado);
	}
}