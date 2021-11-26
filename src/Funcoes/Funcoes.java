package Funcoes;

import LSE_TADPilha.NodeStack;
import aluno.Aluno;

import java.util.Locale;
import java.util.Scanner;

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
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.print("Insira o RA do aluno que quer consultar: ");
            int ra = Integer.parseInt(in.nextLine());

            //Consultar RA
            //Guardar aluno
            //Imprimir aluno

            System.out.print("Quer consultar outro aluno ? (s/n) ");
            String op = in.nextLine();

            if(op != "s"){
                break;
            }
        }

    }

    public Aluno findAlunoByRA(int ra){
        //Passar pra hash
        //Procurar no dicionario
        return new Aluno();
    }

    public void update(){
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                findAlunoByRA(1234532);
                //Atualiza todas as informações
                System.out.print("Quer atualizar outro aluno ? (s/n) ");
                String op = in.nextLine();
                if(op != "s"){
                    break;
                }
            }catch(Exception e){
                System.out.println("RA não encontrado");
            }
        }

    }

    public void delete(){
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                findAlunoByRA(1234532);
                //Deletar aluno
                System.out.print("Aluno deletado com sucesso");
                //Obs:
                System.out.print("Quer deletar outro aluno ? (s/n) ");
                String op = in.nextLine().toLowerCase(Locale.ROOT);
                if(op != "s"){
                    break;
                }
            }catch(Exception e){
                System.out.println("RA não encontrado");
            }
        }
    }
}
