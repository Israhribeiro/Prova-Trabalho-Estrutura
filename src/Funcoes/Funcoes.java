package Funcoes;

import DicionarioHash.HashTableMultiMap;
import LSE_TADPilha.NodeStack;
import aluno.Aluno;
import json.JsonManager;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Funcoes {

    public void register(HashTableMultiMap<Integer,Aluno> db){

        NodeStack<Aluno> studentsStack = new NodeStack<Aluno>();

        Scanner in = new Scanner(System.in);

            try {
                System.out.print("Insira o RA do Aluno: ");
                int ra = Integer.parseInt(in.nextLine());
                if(db.get(ra) != null){
                    System.out.println("Esse RA já existe");
                    register(db);
                }
                System.out.println();
                System.out.print("Insira o Nome do Aluno: ");
                String nome = in.nextLine();
                System.out.println();
                System.out.print("Insira o Endereço do Aluno: ");
                String endereco = in.nextLine();
                System.out.println();
                System.out.print("Insira o Celular do Aluno: ");
                String celular = in.nextLine().replace("-","").replace("(","").replace(")","").replace(" ", "");
                System.out.println();
                System.out.print("Insira a Data de Nascimento do Aluno: ");
                String nascimento = in.nextLine();

                System.out.println("Você confirma as informações abaixo (s/n)?");
                System.out.println("RA: "+ ra);
                System.out.println("Nome: "+nome);
                System.out.println("Endereço: "+endereco);
                System.out.println("Celular: "+celular);
                System.out.println("Nascimento: "+nascimento);

                String op = in.nextLine();
                System.out.println();

                if(op.compareTo("s") == 0) {
                    Aluno aluno = new Aluno(ra,nome,endereco,celular,nascimento);

                    studentsStack.push(aluno);

                    System.out.println("Você quer cadastrar outro aluno ?");
                    op = in.nextLine().toLowerCase(Locale.ROOT);

                    if(op.equals("s") == false){
                        for (int i = 0; i <= studentsStack.size(); i++) {
                            Aluno alunoItem = studentsStack.pop();
                            db.put(alunoItem.getRa(),alunoItem);
                            JsonManager.registerOnJSON(alunoItem);
                        }
                        return;
                    }else{
                        register(db);
                    }
                }
            }catch(NumberFormatException nexc){
                System.out.println("Valor digitado não corresponde a um RA");
                register(db);
            }catch(InputMismatchException nexc){
                System.out.println("Valor digitado não corresponde a um RA");
                register(db);
            }
    }

    public void read(HashTableMultiMap<Integer,Aluno> db){
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.print("Insira o RA do aluno que quer consultar: ");
            int ra = Integer.parseInt(in.nextLine());
            Aluno aluno = findAlunoByRA(ra,db);
            if(aluno == null){
                System.out.println("RA inválido");
                break;
            }

            System.out.println();

            System.out.println("RA: " + aluno.getRa());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Celular: " + aluno.getCelular());
            System.out.println("Endereço: " + aluno.getEndereco());
            System.out.println("Data de Nascimento: " + aluno.getDataDeNascimento());

            System.out.print("Quer consultar outro aluno ? (s/n) ");
            String op = in.nextLine();

            if(op.compareTo("s") != 0){
                break;
            }
        }

    }
    public void readEach(Aluno aluno){
        System.out.println("RA: " + aluno.getRa());
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Celular: " + aluno.getCelular());
        System.out.println("Endereço: " + aluno.getEndereco());
        System.out.println("Data de Nascimento: " + aluno.getDataDeNascimento());
    }

    public void readAll(HashTableMultiMap<Integer,Aluno> db){
        db.entrySet().forEach(i -> readEach(i.getValue()));
    }

    public Aluno findAlunoByRA(int ra,HashTableMultiMap<Integer,Aluno> db){
        if(db.get(ra).getValue() == null){
            System.out.println("RA não cadastrado" + ra);
            return null;
        }else{
        return db.get(ra).getValue();
    }
    }

    public void update(HashTableMultiMap<Integer,Aluno> db){
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Insira o RA do aluno que quer atualizar: ");
                int ra = 0;
                Aluno aluno = new Aluno();

                try{
                    ra = Integer.parseInt(in.nextLine());
                    aluno = findAlunoByRA(ra,db);
                }catch (NumberFormatException e){
                    System.out.println("RA não encontrado");
                    update(db);
                }

                System.out.println("Informações antigas do aluno:");
                System.out.println("RA: " + aluno.getRa());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Celular: " + aluno.getCelular());
                System.out.println("Endereço: " + aluno.getEndereco());
                System.out.println("Data de Nascimento: " + aluno.getDataDeNascimento());

                System.out.print("Insira o Nome: ");
                aluno.setNome(in.nextLine());
                System.out.print("Insira o Celular: ");
                aluno.setCelular(in.nextLine());
                System.out.print("Insira o Endereço: ");
                aluno.setEndereco(in.nextLine());
                System.out.print("Insira a Data de Nascimento: ");
                aluno.setDataDeNascimento(in.nextLine());

                JsonManager.updateOnJSON(aluno);

                System.out.print("Quer atualizar outro aluno ? (s/n) ");
                String op = in.nextLine();
                if(op.compareTo("s") != 0){
                    break;
                }
            }catch(Exception e){
                System.out.println("RA não encontrado");
            }
        }

    }

    public void delete(HashTableMultiMap<Integer,Aluno> db){
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Insira o RA do aluno que quer remover: ");
                int ra = Integer.parseInt(in.nextLine());
                db.remove(db.get(ra));
                JsonManager.removeFromJSON(ra);
                System.out.println("Aluno deletado com sucesso!");
                System.out.print("Quer deletar outro aluno ? (s/n) ");
                String op = in.nextLine().toLowerCase(Locale.ROOT);
                if(op.compareTo("s") != 0){
                    break;
                }
            }catch(Exception e){
                System.out.println("RA não encontrado");
            }
        }
    }
}
