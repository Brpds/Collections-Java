package br.com.dio.collection.map;

/* Faça um programa que simule um lançamento de dados
lance o dado 100 vezes e armazene
mostre quantas vezes cada valor foi inserido
 */

public class DesafioProposto {
    public static void main(String[] args) {
        int D=12;

        int G=14;

        while (D < (G+3) )  {

            if  (D % 2 == 1)

                D=D+4;

            else

                D=D+8;

        }
        System.out.println(D);
    }
}
