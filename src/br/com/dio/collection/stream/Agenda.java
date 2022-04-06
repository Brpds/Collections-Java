package br.com.dio.collection.stream;

import java.util.*;
import java.util.function.Function;

/* id = 1 - Contato = nome: Simba, numero = 2222;
   id = 4 - Contato = nome: Cami, numero = 5555;
   id = 3 - Contato = nome: Jon, numero = 1111;
 */


public class Agenda {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda= new HashMap<>(){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};
        System.out.println(agenda);

        System.out.println("--\tOrdem de número de telefone\t--");
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
                return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
            }
        });
        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: set
             ) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + ": "
            + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem de número de telefone com Função Anônima\t--");
        Set<Map.Entry<Integer, Contato>> set2 = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }));
        set2.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: set2
        ) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + ": "
                    + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem de número de telefone com LAMBDA\t--");
        Set<Map.Entry<Integer, Contato>> set3 = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNumero()));

        set3.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: set3
        ) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + ": "
                    + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem de nome de contato com Função Anônima\t--");



        System.out.println("--\tOrdem de nome de contato com LAMBDA\t--");




    }
    }
