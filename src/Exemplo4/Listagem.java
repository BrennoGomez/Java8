package Exemplo4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author BRENO
 * Listagem classe que lista frutas.
 * Map método que mostra um mapa de valores
 * Collectors método que mostra uma coleção
 */

public class Listagem {

    public static void main(String[] args) {

        //4 bananas, 3 batatas, 1 caju, 2 abacaxis
        List<String> items =
                Arrays.asList("banana", "banana", "banana",
                        "batata", "caju", "banana",
                        		"batata", "batata", "abacaxi", "abacaxi");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        
        System.out.println(result);

    }
}