package pacote2;

import org.w3c.dom.ls.LSOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Testes {
    public static void main(String[] args) {
        Optional<String> op = Optional.ofNullable("Alef");
        op.ifPresentOrElse(System.out::println, () -> System.out.println("NULL"));
        int maior = 2 >= 1 ? 2 : 1;
        System.out.println(maior);

        //STREAMS
        List<String> nomes = new ArrayList<>();
        nomes.add("Alef");
        nomes.add("Gabriel");
        nomes.add("Wayne");
        nomes.add("Ana");
        nomes.add("Maria");

        //Retorna a contagem de elementos
        System.out.println("Quantidade: " + nomes.stream().count());

        //Retorna o elemento com maior numero de letras
        System.out.println("Maior palavra: " + nomes.stream().
                max(Comparator.comparingInt(String::length)));

        //Retorna o elemento com Menor numero de letras
        System.out.println("Menor palavra: " + nomes.stream().
                min(Comparator.comparingInt(String::length)));

        //Retorna os elementos que tem uma letra em especifico
        System.out.println("Nome com letra a: " + nomes.stream()
                .filter((nome)->nome.toLowerCase().
                        contains("a")).collect(Collectors.toList()));

        //Retorna nomes concatenados com a qtd de letras
        System.out.println("Nome + TAM: " + nomes.stream()
                .map(nome -> nome.concat(" - ")
                        .concat(String.valueOf(nome.length())))
                .collect(Collectors.toList()));

        //Retorna um numero de elementos
        System.out.println("Retornando 1 elemento + " + nomes.stream()
                .limit(1).collect(Collectors.toList()));

        //printa e retorna a colecao
        System.out.println("retornando: " + nomes.stream()
                .peek(System.out::println).collect(Collectors.toList()));

        //print sem retornar
        nomes.stream().forEach(System.out::println);

        //Retorna true se todos possuem alguma letra
        System.out.println("Tem letra A no nome?: " + nomes.stream()
                .allMatch((nome) -> nome.contains("a")));

        //Retorna true se algum elemento possui a letra W maiuscula
        System.out.println("Nome com w? " + nomes.stream()
                .anyMatch((nome) -> nome.contains("W")));

        //Retorna true se nenhum elemento possui a letra z
        System.out.println("Sem nenhum z? " + nomes.stream()
                .noneMatch((nome) -> nome.contains("W")));

        //Retorna o primeiro elemento se existir
        nomes.stream().findFirst().ifPresent(System.out::println);

        //operacao encadeada
        System.out.println("Encadeada");
        System.out.println(nomes.stream()
                .peek(System.out::println).map(nome -> nome.concat(" - ")
                        .concat(String.valueOf(nome.length())))
                .peek(System.out::println)
                //.filter((nome) -> nome
                //        .toLowerCase().contains("M"))
                //.collect(Collectors.toList()));
                //.collect(Collectors.joining(", ")));
                //.collect(Collectors.toSet()));
                .collect(Collectors.groupingBy(nome -> nome
                        .substring(nome.indexOf("-") + 1))));

    }
}
