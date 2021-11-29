package json;

import DicionarioHash.HashTableMultiMap;
import aluno.Aluno;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.Set;

public class JsonManager {

    public static HashTableMultiMap<Integer, Aluno> turnIntoDictionary(){
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();

        HashTableMultiMap<Integer,Aluno> students = new HashTableMultiMap<Integer,Aluno>();

        String nome = null;
        String endereco = null;
        String celular = null;
        String dataDeNascimento = null;

        try{
            jsonObject = (JSONObject) parser.parse(new FileReader("saida.json"));
            Set keys = jsonObject.keySet();
            for (Object key:keys) {
                int actualKey = Integer.parseInt((String) key);
                Map student = (Map) jsonObject.get(key);

                nome = (String) student.get("nome");
                endereco = (String) student.get("endereco");
                celular = (String) student.get("celular");
                dataDeNascimento = (String) student.get("dataDeNascimento");

                students.put(actualKey,new Aluno(actualKey,nome,endereco,celular,dataDeNascimento));
            }
            return students;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static void registerOnJSON(Aluno aluno){
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();

        try{
            jsonObject = (JSONObject) parser.parse(new FileReader("saida.json"));

            JSONObject alunoJson = new JSONObject();
            alunoJson.put("nome",aluno.getNome());
            alunoJson.put("endereco",aluno.getEndereco());
            alunoJson.put("celular",aluno.getCelular());
            alunoJson.put("dataDeNascimento",aluno.getDataDeNascimento());
            jsonObject.put(aluno.getRa(),alunoJson);

            FileWriter writer = new FileWriter("saida.json");
            System.out.println(jsonObject.toJSONString());
            writer.write(jsonObject.toJSONString());
            writer.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void updateOnJSON(Aluno aluno){
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();

        try{
            jsonObject = (JSONObject) parser.parse(new FileReader("saida.json"));

            JSONObject alunoJson = new JSONObject();
            alunoJson.put("nome",aluno.getNome());
            alunoJson.put("endereco",aluno.getEndereco());
            alunoJson.put("celular",aluno.getCelular());
            alunoJson.put("dataDeNascimento",aluno.getDataDeNascimento());
            jsonObject.replace("" + aluno.getRa(),alunoJson);

            FileWriter writer =  new FileWriter("saida.json");
            writer.write(jsonObject.toJSONString());
            writer.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void removeFromJSON(int ra){
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();

        try{
            jsonObject = (JSONObject) parser.parse(new FileReader("saida.json"));
            jsonObject.remove("" + ra);
            FileWriter writer =  new FileWriter("saida.json");
            writer.write(jsonObject.toJSONString());
            writer.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
