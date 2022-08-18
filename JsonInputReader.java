package com.marcos.elevatortest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import org.apache.commons.io.IOUtils;

/** Programa criado para solucionar desafio admissional Apisul
 * <p>
 * Foi feito o tratamento de um arquivo JSON, implementação da
 * regra de negocio e uma interface para acesso as respostas.
 * O sistema consegue identificar duplicatas e valores de não uso 
 * dos andares, como por exemplo a resposta C que indica dois 
 * elevadores com mesmo valor de uso e exibe os dois ao invés de um. 
 * input.json deve ser passado como parametro de JsonInputReader()
 * @author Marcos Vinicius Pereira da Silva
 */

public class JsonInputReader extends ElevatorResults implements IElevadorService{    
    public static ElevatorResults input (String path){       
    String inputPath = path;    
    Gson gson = new Gson();
    ElevatorResults results = new ElevatorResults();
    try {
        //leitor de arquivo JSON
        FileReader reader = new FileReader(inputPath);
        //converte tipo FileReader para String
        String str = IOUtils.toString(reader);
        //converte String/Json -> JsonElement -> JsonArray
        JsonElement jelement = gson.fromJson(str, JsonElement.class);
        JsonArray jarray = jelement.getAsJsonArray();//acessa o corpo do json
        //System.out.println(str); 
        
        //Iterador do Array       
        for (int i=0; i<jarray.size(); i++) {
            JsonObject json = jarray.get(i).getAsJsonObject();//index do array
            //buffer dos valores
            int andar = json.get("andar").getAsInt();
            String elevador = json.get("elevador").getAsString();
            String turno = json.get("turno").getAsString();            
            //armazenadores dos elevadores
            if(Objects.equals(elevador,"A")){results.addElevA();}
            if(Objects.equals(elevador,"B")){results.addElevB();}
            if(Objects.equals(elevador,"C")){results.addElevC();}
            if(Objects.equals(elevador,"D")){results.addElevD();}
            if(Objects.equals(elevador,"E")){results.addElevE();}
            //armazenadores dos andares
            if(Objects.equals(turno,"M")){results.addTurnoM();}
            if(Objects.equals(turno,"N")){results.addTurnoN();}
            if(Objects.equals(turno,"V")){results.addTurnoV();}           
            //armazendadores dos andares
            if(andar == 0){results.addAndar0();}
            if(andar == 1){results.addAndar1();}
            if(andar == 2){results.addAndar2();}
            if(andar == 3){results.addAndar3();}
            if(andar == 4){results.addAndar4();}
            if(andar == 5){results.addAndar5();}
            if(andar == 6){results.addAndar6();}
            if(andar == 7){results.addAndar7();}
            if(andar == 8){results.addAndar8();}
            if(andar == 9){results.addAndar9();}
            if(andar == 10){results.addAndar10();}
            if(andar == 11){results.addAndar11();}
            if(andar == 12){results.addAndar12();}
            if(andar == 13){results.addAndar13();}
            if(andar == 14){results.addAndar14();}
            if(andar == 15){results.addAndar15();}            
        }
        } catch (IOException e) {
            System.out.println(e);
            }  
    return results;
    }   


}
