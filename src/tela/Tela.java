package tela;

import java.util.Scanner;
import Funcoes.Funcoes;

public class Tela {
    public static void main (String [] args) {

        System.out.println("--------------------------------------------------------------------------------------------");

        intro();

        System.out.println("--------------------------------------------------------------------------------------------");

    }

    public static void intro(){
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
                programa.register();
                break;
            case 2:
                programa.read();
                break;
            case 3:
                programa.update();
                break;
            case 4:
                programa.delete();
                break;
            case 5:
                break;
            default:
                System.out.println("Opção invalida");
                intro();
        }
    }
}
