import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.lang.reflect.Type;
import java.text.ParseException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javafx.scene.control.Alert;

class UserList{

    private static ArrayList<Clientes> carro = new ArrayList<>();
   

    public static void addCarro(Clientes client){
        carro.add(client);
        jasonUpdate();
    }

    public static void excluirCarro(Clientes client){
        carro.remove(client);
        jasonUpdate();
    }

    public static boolean isUserExist(Clientes clientes){

        for (Clientes car : carro) {
           if(clientes.getPlaca().equals(car.getPlaca())){
               System.out.println("Existe");
               return true;
           }
        }
        
        System.out.println("Nao Existe");
        return false;
    }

    public static boolean isUserExist(String placa){

        for (Clientes car : carro) {
           if(placa.equals(car.getPlaca())){
               System.out.println("Existe");
               return true;
           }
        }
        
        System.out.println("Nao Existe");
        return false;
    }

    public static ArrayList<Clientes> getCarro() {
        return carro;
    }


    static Gson jasonWriter = new Gson();
    
    public static void jasonUpdate() {
        
        try (FileWriter wF = new FileWriter("database.json")){

            jasonWriter.toJson(UserList.getCarro(), wF);

            


        } catch (IOException e){
            System.err.println(e);
        }
    }

    public static void arrayUpdate() {
        
        
    }
     
    public static void loadJSON() throws org.json.simple.parser.ParseException{

        

            JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader("database.json")) {
                // Read JSON file

                Object obj = jsonParser.parse(reader);

                JSONArray userList = (JSONArray) obj;

                // Iterate over employee array
                userList.forEach(user -> parseUserObject((JSONObject) user));

            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.toString());
            }
        
    }


    private static void parseUserObject(JSONObject jsonObject) {

        
        
        String placa = (String) jsonObject.get("placa");
        String usuario = (String) jsonObject.get("usuario");
        String senha = (String) jsonObject.get("senha");
        long tempoDeChegada = (long) jsonObject.get("tempoDeChegada");
        long tempoDeSaida = (long) jsonObject.get("tempoDeSaida");

        if(jsonObject.containsKey("senha")){
            carro.add(new Mensalista(usuario,placa,senha,tempoDeChegada,tempoDeSaida));
        } else {
            carro.add(new Horista(usuario,placa,tempoDeChegada,tempoDeSaida));
        }
       
        JSONArray jsonArray = new JSONArray();


    } 
}