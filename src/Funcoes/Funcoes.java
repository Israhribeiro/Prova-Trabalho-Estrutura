package Funcoes;

import java.util.Locale;
import java.util.Scanner;
import LSE_TADPilha.NodeStack;
import aluno.Aluno;

public class Funcoes {

    public void register(){
        NodeStack studentsStack = new NodeStack();

        Scanner in = new Scanner(System.in);

        while(true){
            int ra = Integer.parseInt(in.nextLine());
            String nome = in.nextLine();
            String endereco = in.nextLine();
            String celular = in.nextLine().replace("-","").replace("(","").replace(")","").replace(" ", "");
            String nascimento = in.nextLine();
            System.out.println(ra+" "+nome+" "+endereco+" "+celular+" "+nascimento);

            System.out.println("Você confirma as informações abaixo (s/n)?");
            System.out.println("RA: "+ra);
            System.out.println("Nome: "+nome);
            System.out.println("Endereço: "+endereco);
            System.out.println("Celular: "+celular);
            System.out.println("Nascimento: "+nascimento);

            String op = in.nextLine().toLowerCase(Locale.ROOT);

            if(op == "s") {

                Aluno aluno = new Aluno(ra,nome,endereco,celular,nascimento);

                studentsStack.push(aluno);

                System.out.println("Você quer cadastrar outro aluno ?");
                op = in.nextLine().toLowerCase(Locale.ROOT);

                if(op != "s"){
                    break;
                }

            }
        }
    }

    public void read(){

    }

    public void update(){

    }

    public void delete(){

    }
}
