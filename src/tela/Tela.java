package tela;

import java.util.Scanner;

public class Tela {
    public static void main (String [] args) {

        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1 Para cadastrar");
        System.out.println("2 Para ver seus dados, passe seu Ra");
        System.out.println("3 Para atualizar seus dados ");
        System.out.println("4 Para remover seus dados");
        System.out.println("5 para sair ");
        Scanner in2 = new Scanner(System.in);

        int escolha = in2.nextInt();
        switch (escolha) {
            case 1:
                System.out.println("Dez");
            case 2:
                System.out.println("Numero muito grande");

            case 3:
                System.out.println("Numero muito grande");

            case 4:
                System.out.println("Numero muito grande");

            case 5:
                System.out.println("fechando Sistema ");
            default:
                System.out.println("Opção invalida");
        }

        System.out.println("--------------------------------------------------------------------------------------------");

    }
}
