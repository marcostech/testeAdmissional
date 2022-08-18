package com.marcos.elevatortest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Objects.isNull;

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

public class ElevatorResults implements IElevadorService {
    private int elevA, elevB, elevC, elevD, elevE ;
    private int turnoM, turnoV, turnoN;
    private int andar0, andar1, andar2, andar3, andar4, andar5,
                andar6, andar7, andar8, andar9, andar10,
                andar11, andar12, andar13, andar14, andar15;
    
    //respostas        
    @Override    
    public String respostaA() { //resposta será andar 8
        /*
        *Metodo feito para aproveitar o codigo do metodo getxxxxUsage()
        *seleciona apenas a resposta da segunda linha do metodo
        *GetxxxxUsage retorna o mais usado e menos usado em duas linhas respectivamente
        */
        String result = getAndarUsage();
        int segundaLinha = 1 + result.indexOf("\n");
    return result.substring(segundaLinha);
    }
    
    @Override
    public String respostaB(){ //resposta será andar 8
        /*
        *Metodo feito para aproveitar o codigo do metodo getxxxxUsage()
        *seleciona apenas a resposta da segunda linha do metodo
        *GetxxxxUsage retorna o mais usado e menos usado em duas linhas respectivamente
        */
        String result1 = getElevUsage(); //pega resultado de uso dos elevadores
        int segundaLinha1 = result1.indexOf("\n");
        String result2 = getTurnoUsage(); //pega resultatdo de uso dos turnos
        int segundaLinha2 = result2.indexOf("\n");
    return result1.substring(0,segundaLinha1) + "\n" + result2.substring(0,segundaLinha2) ;
    }

    @Override
    public String respostaC(){ //resposta será andar 8
        /*
        *Metodo feito para aproveitar o codigo dos metodos getxxxxUsage()
        *seleciona apenas a resposta da segunda linha do metodo
        *GetxxxxrUsage retorna o mais usado e menos usado em duas linhas respectivamente
        */
        String result1 = getElevUsage();
        int segundaLinha1 = 1 + result1.indexOf("\n");
        String result2 = getTurnoUsage();
        int segundaLinha2 = 1 + result2.indexOf("\n");
    return result1.substring(segundaLinha1) + "\n" + result2.substring(segundaLinha2) ;
    }
    
    @Override
    public String respostaD(){ //resposta será andar 8
        /*
        *Metodo feito para aproveitar o codigo dos metodos getxxxxUsage()
        *seleciona apenas a resposta da segunda linha do metodo
        *GetxxxxrUsage retorna o mais usado e menos usado em duas linhas respectivamente
        */
        String result1 = getTurnoUsage();
        int segundaLinha1 = result1.indexOf("\n");
    return result1.substring(0,segundaLinha1);
    }
    
    @Override
    public String respostaE(){ //resposta será andar 8
        /*
        *Metodo feito para aproveitar o codigo dos metodos getxxxxUsage()
        *seleciona apenas a resposta da segunda linha do metodo
        *GetxxxxrUsage retorna o mais usado e menos usado em duas linhas respectivamente
        */        
    return getElevPercent();
    }
    //metodos uteis 
    public String getElevUsage(){
        ArrayList<Integer> elevadores = new ArrayList<>();
        ArrayList<String> elevadoresIndex = new ArrayList<>();        
        ArrayList<String> elevMostUsed = new ArrayList<>();        
        ArrayList<String> elevLessUsed = new ArrayList<>();
        //init
        elevadoresIndex.add("A");
        elevadoresIndex.add("B");
        elevadoresIndex.add("C");
        elevadoresIndex.add("D");
        elevadoresIndex.add("E");
        elevadores.add(this.elevA);
        elevadores.add(this.elevB);
        elevadores.add(this.elevC);
        elevadores.add(this.elevD);
        elevadores.add(this.elevE);  
        
        //Logica
        //andar mais utilizado
        int elevMax = Collections.max(elevadores); //maior valor
        int index = 0;
        for (Integer elevador : elevadores){ //Verifica duplicados
            if (elevador == elevMax){
                elevMostUsed.add(elevadoresIndex.get(index)); //adiciona duplicados
            }
            index++;
        }
        String mostUsed = "Elevador mais utilizado: ";
        for (String elevResultados : elevMostUsed) {
            mostUsed += elevResultados + " ";
        }
        
        //andar menos utilizados
        int elevMin = Collections.min(elevadores); //menor valor
        index = 0;
        for (Integer elevador : elevadores){ //Verifica duplicados
            if (elevador == elevMin){
                elevLessUsed.add(elevadoresIndex.get(index)); //adiciona duplicados
            }
            index++;
        }
        String lessUsed = "Elevador menos utilizado: ";
        for (String elevResultados : elevLessUsed) {
            lessUsed += elevResultados + " ";
        }       
        
        //retorno
        //String elevMostUsed = "Elevador mais utilizado: " + elevadoresIndex.get(elevadores.indexOf(Collections.max(elevadores)));
        //String elevLessUsed = "Elevador menos utilizado: " + elevadoresIndex.get(elevadores.indexOf(Collections.min(elevadores)));
        return mostUsed + "\n" + lessUsed;
    }
    
    public String getTurnoUsage(){
        ArrayList<Integer> turnos = new ArrayList<>();
        ArrayList<String> turnosIndex = new ArrayList<>();
        //init
        turnosIndex.add("Matutino");
        turnosIndex.add("Vespertino");
        turnosIndex.add("Noturno");
        turnos.add(this.turnoM);
        turnos.add(this.turnoV);
        turnos.add(this.turnoN);
        //retorno
        String turnoMostUsed = "Turno mais utilizado: " + turnosIndex.get(turnos.indexOf(Collections.max(turnos)));
        String turnoLessUsed = "Turno menos utilizado: " + turnosIndex.get(turnos.indexOf(Collections.min(turnos)));
        return turnoMostUsed + "\n" + turnoLessUsed;
    }
    
    public String getAndarUsage(){
        ArrayList<Integer> andar = new ArrayList<>();
        ArrayList<String> andarIndex = new ArrayList<>();
        ArrayList<String> andarMostUsed = new ArrayList<>();        
        ArrayList<String> andarLessUsed = new ArrayList<>();
        //init
        andarIndex.add("Andar 0");   
        andarIndex.add("Andar 1");
        andarIndex.add("Andar 2");
        andarIndex.add("Andar 3");
        andarIndex.add("Andar 4");
        andarIndex.add("Andar 5");
        andarIndex.add("Andar 6");
        andarIndex.add("Andar 7");
        andarIndex.add("Andar 8");
        andarIndex.add("Andar 9");
        andarIndex.add("Andar 10");
        andarIndex.add("Andar 11");
        andarIndex.add("Andar 12");
        andarIndex.add("Andar 13");
        andarIndex.add("Andar 14");
        andarIndex.add("Andar 15");
        andar.add(this.andar0);
        andar.add(this.andar1);
        andar.add(this.andar2);
        andar.add(this.andar3);
        andar.add(this.andar4);
        andar.add(this.andar5);
        andar.add(this.andar6);
        andar.add(this.andar7);
        andar.add(this.andar8);
        andar.add(this.andar9);
        andar.add(this.andar10);
        andar.add(this.andar11);
        andar.add(this.andar12);
        andar.add(this.andar13);
        andar.add(this.andar14);
        andar.add(this.andar15);
        
        //Logica
        //andar mais utilizado
        int andarMax = Collections.max(andar); //maior valor
        int index = 0;
        for (Integer andares : andar){ //Verifica duplicados
            if (andares == andarMax){
                andarMostUsed.add(andarIndex.get(index)); //adiciona duplicados
            }
            index++;
        }
        String mostUsed = "Andar mais utilizado: ";
        for (String andarResultados : andarMostUsed) {
            mostUsed += andarResultados + " ";
        }
        
        //andar menos utilizados
        int andarMin = Collections.min(andar); //menor valor
        index = 0;
        for (Integer andares : andar){ //Verifica duplicados
            if (andares == andarMin){
                andarLessUsed.add(andarIndex.get(index)); //adiciona duplicados
            }
            index++;
        }
        String lessUsed = "Andar menos utilizado: ";
        for (String andarResultados : andarLessUsed) {
            lessUsed += andarResultados + " ";
        }       
        
        //Retorno         
        return mostUsed + "\n" + lessUsed ;
    }
    
    public String getElevPercent() {
        ArrayList<Integer> totalUse = new ArrayList<>();
        totalUse.add(this.andar0);
        totalUse.add(this.andar1);
        totalUse.add(this.andar2);
        totalUse.add(this.andar3);
        totalUse.add(this.andar4);
        totalUse.add(this.andar5);
        totalUse.add(this.andar6);
        totalUse.add(this.andar7);
        totalUse.add(this.andar8);
        totalUse.add(this.andar9);
        totalUse.add(this.andar10);
        totalUse.add(this.andar11);
        totalUse.add(this.andar12);
        totalUse.add(this.andar13);
        totalUse.add(this.andar14);
        totalUse.add(this.andar15); 
        //formatação
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2); 
        //
        String percentElevUse = new String();
        int maxUse = 0;
        for (int i = 0; totalUse.size() > i;i++){
            maxUse += totalUse.get(i);
        }
        //Elevador A
        float elevAMaxUse = 0;
        if(this.elevA>0){
           elevAMaxUse =  this.elevA * 100;
           elevAMaxUse = elevAMaxUse / maxUse; 
        }
        //Elevador B
        float elevBMaxUse = 0;        
        if(this.elevB>0){
           elevBMaxUse =  this.elevB * 100;
           elevBMaxUse = elevBMaxUse / maxUse; 
        }
        //Elevador C
        float elevCMaxUse = 0;        
        if(this.elevC>0){
           elevCMaxUse =  this.elevC * 100;
           elevCMaxUse = elevCMaxUse / maxUse; 
        }        
        //Elevador D
        float elevDMaxUse = 0;        
        if(this.elevD>0){
           elevDMaxUse =  this.elevD * 100;
           elevDMaxUse = elevDMaxUse / maxUse; 
        }        
        //Elevador E
        float elevEMaxUse = 0;        
        if(this.elevE>0){
           elevEMaxUse =  this.elevE * 100;
           elevEMaxUse = elevEMaxUse / maxUse; 
        }
        
        //retorno
        percentElevUse = "Uso do Elevador A: " + df.format(elevAMaxUse) + "%" + "\n";
        percentElevUse += "Uso do Elevador B: " + df.format(elevBMaxUse) + "%" + "\n";
        percentElevUse += "Uso do Elevador C: " + df.format(elevCMaxUse) + "%" + "\n";
        percentElevUse += "Uso do Elevador D: " + df.format(elevDMaxUse) + "%" + "\n";
        percentElevUse += "Uso do Elevador E: " + df.format(elevEMaxUse) + "%" + "\n";        
        
    return percentElevUse;
    }
    
    //elevadores getters setters
    public int getElevA (){
    return this.elevA;
    }

    public int getElevB (){
    return this.elevB;
    }

    public int getElevC (){
    return this.elevC;
    }

    public int getElevD (){
    return this.elevD;
    }

    public int getElevE (){
    return this.elevE;
    }
    
    public void addElevA (){
    this.elevA++;
    }

    public void addElevB (){
    this.elevB++;
    }

    public void addElevC (){
    this.elevC++;
    }

    public void addElevD (){
    this.elevD++;
    }

    public void addElevE (){
    this.elevE++;
    }     
    
    //turnos getters setters
    public int getTurnoM (){
    return this.turnoM;
    }
    
    public int getTurnoN (){
    return this.turnoN;
    }
    
    public int getTurnoV (){
    return this.turnoV;
    }
    
    public void addTurnoM (){
    this.turnoM++;
    }
    
    public void addTurnoN (){
    this.turnoN++;
    }
    
    public void addTurnoV (){
    this.turnoV++;
    }
    
    //andares getters e setters
    public int getAndar0 () {    
    return this.andar0;
    }
    
    public int getAndar1 () {    
    return this.andar1;
    }
    
    public int getAndar2 () {    
    return this.andar2;
    }
    
    public int getAndar3 () {    
    return this.andar3;
    }

    public int getAndar4 () {    
    return this.andar4;
    }

    public int getAndar5 () {    
    return this.andar5;
    }

    public int getAndar6 () {    
    return this.andar6;
    }

    public int getAndar7 () {    
    return this.andar7;
    }

    public int getAndar8 () {    
    return this.andar8;
    }

    public int getAndar9 () {    
    return this.andar9;
    }

    public int getAndar10 () {    
    return this.andar10;
    }

    public int getAndar11 () {    
    return this.andar11;
    }
    
    public int getAndar12 () {    
    return this.andar12;
    }

    public int getAndar13 () {    
    return this.andar13;
    }
    
    public int getAndar14 () {    
    return this.andar14;
    }

    public int getAndar15 () {    
    return this.andar15;
    }

    public void addAndar0 () {    
    this.andar0++;
    }
    
    public void addAndar1 () {    
    this.andar1++;
    }
    
    public void addAndar2 () {    
    this.andar2++;
    }
    
    public void addAndar3 () {    
    this.andar3++;
    }

    public void addAndar4 () {    
    this.andar4++;
    }

    public void addAndar5 () {    
    this.andar5++;
    }

    public void addAndar6 () {    
    this.andar6++;
    }

    public void addAndar7 () {    
    this.andar7++;
    }

    public void addAndar8 () {    
    this.andar8++;
    }

    public void addAndar9 () {    
    this.andar9++;
    }

    public void addAndar10 () {    
    this.andar10++;
    }

    public void addAndar11 () {    
    this.andar11++;
    }
    
    public void addAndar12 () {    
    this.andar12++;
    }

    public void addAndar13 () {    
    this.andar13++;
    }
    
    public void addAndar14 () {    
    this.andar14++;
    }

    public void addAndar15 () {    
    this.andar15++;
    }
    
}
