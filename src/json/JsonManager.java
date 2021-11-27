package json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;

public class JsonManager {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();

        FileWriter writeFile = null;
        JSONObject jsonReader = new JSONObject();

        jsonObject.put("nome", "Clebinho");
        jsonObject.put("sobrenome", "Russomano");
        jsonObject.put("pais", "Clebinho");
        jsonObject.put("estado", "Jardins");
        jsonObject.put("Clebinho","{ 'valor' : 'valor2' }");

        String nome;
        String sobrenome;
        String estado;
        String pais;

        try{
            nome = (String) jsonObject.get("nome");
            sobrenome = (String) jsonObject.get("sobrenome");
            estado = (String) jsonObject.get("estado");
            pais = (String) jsonObject.get("pais");

            String jsonValor = "{\"valor\":{\"valor2\":\"valor3\"}}";
            System.out.printf("Nome: %s\nSobrenome: %s\nEstado: %s\nPais: %s\n",
                    nome, sobrenome, estado, pais);
            System.out.println(jsonObject.keySet());
            writeFile = new FileWriter("saida.json");
            writeFile.write(jsonValor);

            writeFile.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(jsonObject);
    }
}
