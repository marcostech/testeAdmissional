package com.marcos.testeadm;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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

public class JsonInputReader extends ElevatorResults {    
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
            //armazenadores dos turnos
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
        //logica de uso elevador mais usado -> periodo
        List<Character> elevadorMaisUsado = results.elevadorMaisFrequentado();
        List<Integer> turnoElevadorMaisUsado = new ArrayList<>();
        turnoElevadorMaisUsado.add(0);
        turnoElevadorMaisUsado.add(0);
        turnoElevadorMaisUsado.add(0);
        int index = 0;
        for (Character umElevadorMaisUsado: elevadorMaisUsado) {
            for (int j = 0; j < jarray.size(); j++) {
                JsonObject json = jarray.get(j).getAsJsonObject();
                if(Objects.equals(
                                Character.toString(umElevadorMaisUsado),
                                json.get("elevador").getAsString()) 
                                ) {
                    if(Objects.equals(json.get("turno").getAsString(), "M")) {
                        turnoElevadorMaisUsado.set(0, (turnoElevadorMaisUsado.get(0) + 1));
                    }
                    if(Objects.equals(json.get("turno").getAsString(), "N")) {
                        turnoElevadorMaisUsado.set(1, (turnoElevadorMaisUsado.get(1) + 1));
                    }
                    if(Objects.equals(json.get("turno").getAsString(), "V")) {
                        turnoElevadorMaisUsado.set(2, (turnoElevadorMaisUsado.get(2) + 1));
                    }
                    
                }            
            }
            index++;
            
            System.out.println(turnoElevadorMaisUsado.indexOf(Collections.max(turnoElevadorMaisUsado)));
        }
        
        
        //logica de uso elevador menos usado ->        
        List<Character> elevadorMenosUsado = results.elevadorMenosFrequentado();                
        List<Integer> turnoElevadorMenosUsado = new ArrayList<>();
        turnoElevadorMenosUsado.add(0);
        turnoElevadorMenosUsado.add(0);
        turnoElevadorMenosUsado.add(0);
        index = 0;
        for (Character umElevadorMenosUsado: elevadorMenosUsado) {
            for (int j = 0; j < jarray.size(); j++) {
                JsonObject json = jarray.get(j).getAsJsonObject();
                if(Objects.equals(
                                Character.toString(umElevadorMenosUsado),
                                json.get("elevador").getAsString()) 
                                ) {
                    
                    if(Objects.equals(json.get("turno").getAsString(), "M")) {
                        turnoElevadorMenosUsado.set(0, (turnoElevadorMenosUsado.get(0) + 1));
                    }
                    if(Objects.equals(json.get("turno").getAsString(), "N")) {
                        turnoElevadorMenosUsado.set(1, (turnoElevadorMenosUsado.get(1) + 1));
                    }
                    if(Objects.equals(json.get("turno").getAsString(), "V")) {
                        turnoElevadorMenosUsado.set(2, (turnoElevadorMenosUsado.get(2) + 1));
                    }                    
                }
                               
            }
            index++;
            System.out.println(turnoElevadorMenosUsado.indexOf(Collections.max(turnoElevadorMenosUsado)));

        }
        //
        } catch (IOException e) {
            System.out.println(e);
            }  
        
    return results;
    }   


}
