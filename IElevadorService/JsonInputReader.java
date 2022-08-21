package com.marcos.testeAdmissional;

/** Programa criado para solucionar desafio admissional Apisul
 * <p>
 * Foi feito o tratamento de um arquivo JSON, implementação da
 * regra de negocio e uma interface para acesso as respostas.
 * input.json deve ser passado como parametro de JsonInputReader()
 * @author Marcos Vinicius Pereira da Silva
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Objects;
import org.apache.commons.io.IOUtils;

public class JsonInputReader {   
    
    public static ElevatorResults input (String path){       
        String inputPath = path;    
        Gson gson = new Gson();        
        ElevatorResults results = new ElevatorResults();
        
        try {
            //leitor de arquivo JSON
            FileReader reader = new FileReader(inputPath);
            //converte tipo FileReader para String
            String str = IOUtils.toString(reader);
            //converte dados para coleção de dados
            Type collectionType = new TypeToken<Collection<ObjetoJson>>(){}.getType();
            Collection<ObjetoJson> dadosLidos = gson.fromJson(str, collectionType); 
            
            //iterador dos dados e alimentador dos atributos do objeto ElevatorResults
            for(ObjetoJson dadosSeparados: dadosLidos) {
                //pega o valor lido e o atribui em results
                results.addAndar(dadosSeparados.getAndar());
                results.addElevador(dadosSeparados.getElevador());
                results.addTurno(dadosSeparados.getTurno());
            }
            
            //Iterador dos dados já lidos - relação com elevador mais usado        
            for(ObjetoJson dadosSeparados: dadosLidos){
                for(Character elevadores: results.elevadorMaisFrequentado()){
                    if(Objects.equals(dadosSeparados.getElevador(), elevadores)){                        
                        if(dadosSeparados.getTurno() == 'M'){results.addPeriodosElevadorMaisUsado('M');}
                        if(dadosSeparados.getTurno() == 'V'){results.addPeriodosElevadorMaisUsado('V');}
                        if(dadosSeparados.getTurno() == 'N'){results.addPeriodosElevadorMaisUsado('N');}
                    }
                }
            }
            
            //Iterador dos dados já lidos - relação com elevador menos usado
            for(ObjetoJson dadosSeparados: dadosLidos){
                for(Character elevadores: results.elevadorMenosFrequentado()){
                    if(Objects.equals(dadosSeparados.getElevador(), elevadores)){                        
                        if(dadosSeparados.getTurno() == 'M'){results.addPeriodosElevadorMenosUsado('M');}
                        if(dadosSeparados.getTurno() == 'V'){results.addPeriodosElevadorMenosUsado('V');}
                        if(dadosSeparados.getTurno() == 'N'){results.addPeriodosElevadorMenosUsado('N');}
                    }
                }
            }
           
        } catch (IOException e) {
            System.out.println(e);
        }  

        return results;
    }
}
