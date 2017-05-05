package Exemplo6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author BRENO
 * JogadorImpl classe representando uma implementação de jogador
 * nela contém Nome, Posição, Idade, Clube atual e Gols marcados no
 * ano de 2016, esta lista é fornecida em um txt.
 */

public class JogadorImpl {
	
	//verificar se o arquivo jogadores.txt existe, utilizando recursos
	//da Streams API
	
    public boolean verificarArquivoExiste(Path path) {
     boolean ret = false;
     
     //Files.list() retorna todos os arquivos de uma pasta através de um Stream<Path>
     
     //*
     //Predicado
     //filtro para verificar se o nome de algum dos arquivos da pasta equivale ao
     //valor passado como parâmetro.
     
     //findAny() checa se alguma ocorrência da característica representada pelo
     //predicado está presente na nova stream.
     
     try {
      Stream < Path > stream = Files.list(path);
      Optional < Path > arq = stream.filter(p -> //*
       p.toString().endsWith("jogadores.txt")).findAny();
      ret = arq.isPresent();
     } catch (IOException ex) {
      ex.printStackTrace();
     }
     return ret;
    }

    /**
     * getListaDeJogadores() lê os dados do arquivo e constrói uma lista com todos
     * os jogadores
     * @param path arquivo jogadores
     * @return jogador
     * @throws IOException
     */
    
    //Files.lines() cria uma stream com todas as linhas do arquivo informado.
    //Como esse método considera o encoding UTF-8 como padrão e o arquivo que
    //utilizamos está com o tipo ISO-8859-1, existe a necessidade de informar
    //ao método o encoding correto.
    
    //Collect obtem uma lista com todas as linhas do arquivo, onde cada elemento
    //da lista representa uma linha.
    
    public List < Jogador > getListaDeJogadores(Path path) throws IOException {
     Stream < String > linhas = Files.lines(path, StandardCharsets.ISO_8859_1);
     List < String > listaDeLinhas = linhas.collect(Collectors.toList());
     List < Jogador > listaDeJogadores = new ArrayList < > ();
     Jogador jogador;

     Iterator it = listaDeLinhas.listIterator();
     String str = null;

     while (it.hasNext()) {
      str = (String) it.next();
      String info[] = str.split(",");
      jogador = new Jogador();
      jogador.setNome(info[0]);
      jogador.setPosicao(info[1]);
      jogador.setIdade(Integer.parseInt(info[2]));
      jogador.setTimeAtual(info[3]);
      jogador.setGolsMarcados(Integer.parseInt(info[4]));
      listaDeJogadores.add(jogador);
     }
     return listaDeJogadores;
    }

    /**
     * ImprimirJogadores cria uma stream e imprime todos os elementos utilizando
     * a operação forEach(), que recebe como parâmetro o método println().
     * @param jogadores
     */
    
    public void imprimirJogadores(List < Jogador > jogadores) {
     jogadores.stream().forEach(System.out::println);
    }

    /**
     * ImprimirJogadoresTime recebe como parâmetro, além da lista de jogadores, o
     * nome de um time, e imprime apenas os jogadores associados a ele. 
     * @param jogadores
     * @param time
     */
    
    public void imprimirJogadoresTime(List < Jogador > jogadores, String time) {
     jogadores.stream().filter(jogador -> jogador.getTimeAtual().equals(time)).forEach(System.out::println);
    }

    /**
     * ImprimirJogadoresTime recebe como parâmetro, além da lista de jogadores, o
     * nome de um time, e imprime apenas os jogadores associados a ele, com mais de 15 gols.
     * @param jogadores
     * @param time
     */
    
    public void imprimirJogadoresTimeGols(List < Jogador > jogadores, String time) {
     jogadores.stream().filter(jogador -> jogador.getTimeAtual().equals(time) && jogador.getGolsMarcados() > 15)
     .forEach(System.out::println);
    }

    public void agruparJogadoresPorTime(List < Jogador > jogadores) {
     jogadores.stream().sorted(Comparator.comparing(Jogador::getTimeAtual)).forEach(System.out::println);
    }

    /**
     * calcularMediaIdade() calcula a média de idade de todos os jogadores cadastrados.
     * @param jogadores
     * @return
     */
    
    //Criamos uma stream a partir da lista de jogadores. Em seguida, é chamado o método mapToInt(),
    //que produz uma stream de inteiros cujos elementos correspondem à idade dos atletas. Por fim, é
    //invocado o método average(). Como essa operação não retorna um valor numérico, e sim um objeto da
    //classe Optional, é preciso chamar o método getAsDouble() para recuperar o resultado.
    
    public double calcularMediaIdade(List < Jogador > jogadores) {
     return jogadores.stream().mapToInt(Jogador::getIdade).average().getAsDouble();
    }

    /**
     * imprimirJogadorMaisVelho() Para alcançar esse requisito é utilizado a operação max()
     * @param jogadores
     */
    
    public void imprimirJogadorMaisVelho(List < Jogador > jogadores) {
     Jogador jogador = jogadores.stream().max(Comparator.comparingInt(Jogador::getIdade)).get();
     System.out.println("Jogador mais velho: " + jogador.getNome());
    }

    /**
     * imprimirJogadorMaisNovo() Para alcançar esse requisito é utilizado a operação min()
     * @param jogadores
     */
    
    public void imprimirJogadorMaisNovo(List < Jogador > jogadores) {
     Jogador jogador = jogadores.stream().min(Comparator.comparingInt(Jogador::getIdade)).get();
     //                                .min((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
     System.out.println("Jogador mais novo: " + jogador.getNome());
    }

    public void imprimirJogadorArtilheiro(List < Jogador > jogadores) {
     Jogador jogador = jogadores.stream().max(Comparator.comparingInt(Jogador::getGolsMarcados)).get();
     System.out.println("Jogador Artilheiro: " + jogador.getNome());
    }

    /**
     * imprimirSomatorioGols() Para calcular a quantidade de gols marcados.
     * @param jogadores
     * @return
     */
    
    //mapInt() produz uma nova stream contendo apenas os valores inteiros que representam os gols.
    //sum() contabiliza os valores e retorna o resultado.
    
    public int imprimirSomatorioGols(List < Jogador > jogadores) {
     int soma = jogadores.stream().mapToInt(jogador -> jogador.getGolsMarcados()).sum();
     return soma;
    }

    /**
     * ordenarJogadoresGols() Organiza a stream adotando como critério o número de gols marcados,
     * em ordem decrescente, ação feita pelo método reverse().
     * @param jogadores
     */
    public void ordenarJogadoresGols(List < Jogador > jogadores) {
     jogadores.stream().sorted(Comparator.comparingInt(Jogador::getGolsMarcados).reversed())
     .forEach(System.out::println);
    }
   }