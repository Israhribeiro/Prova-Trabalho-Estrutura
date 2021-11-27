package tela;

import DicionarioHash.HashTableMultiMap;
import Funcoes.Funcoes;
import aluno.Aluno;

import java.util.Scanner;

public class Tela {
    public static void main (String [] args) {

        HashTableMultiMap<Integer, Aluno> db = new HashTableMultiMap<Integer,Aluno>();

        System.out.println("--------------------------------------------------------------------------------------------");

        intro(db);

        System.out.println("--------------------------------------------------------------------------------------------");

    }

    public static void intro(HashTableMultiMap<Integer,Aluno> db){
        Funcoes programa = new Funcoes();

        System.out.println("1 Para cadastrar");
        System.out.println("2 Para ver seus dados, passe seu Ra");
        System.out.println("3 Para atualizar seus dados ");
        System.out.println("4 Para remover seus dados");
        System.out.println("5 para sair ");
        Scanner in2 = new Scanner(System.in);

        int escolha = in2.nextInt();
        switch (escolha) {
            case 1:
                programa.register(db);
                break;
            case 2:
                programa.read(db);
                break;
            case 3:
                programa.update(db);
                break;
            case 4:
                programa.delete(db);
                break;
            case 5:
                break;
            default:
                System.out.println("Opção invalida");
                intro(db);
        }

        intro(db);
    }
}
