package br.com.dio.collection.map;

/* Dadas as informações a seguir sobre livros favoritos e autores,
crie um dicionário e ordene este dicionário:
exibindo (Nome autor - Nome Livro);

Autor = Hawking, Stephen - Livro = nome: Uma breve história do tempo, páginas 256.
Autor = Duhigg, Charles - Livro = nome: O poder do hábito, páginas 408.
Autor = Harari, Yuval Noah - Livro = nome: 21 lições para o século 21, páginas 432

 */

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("--\tOrdem Aleatória\t--");

        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito",408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21",432));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("--\tOrdem de Inserção\t--");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito",408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21",432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem alfabética Autores\t--");
        Map<String,Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for (Map.Entry<String,Livro> livro : meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem alfabética nomes dos livros\t--");
        //Necessita implementar Comparator por comparar Valores.
        Set<Map.Entry<String, Livro>> meuslivros3 = new TreeSet<>(new ComparatorNome());
        //Adiciona os itens de meus livros a meus livros 3
        meuslivros3.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> livro : meuslivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        //System.out.println("--\tOrdem de número de páginas\t--");


    }
}


class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
        return livro1.getValue().getNome().compareToIgnoreCase(livro2.getValue().getNome());
    }
}