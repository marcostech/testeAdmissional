package com.marcos.testeadm;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/** Programa criado para solucionar desafio admissional Apisul
 * <p>
 * Foi feito o tratamento de um arquivo JSON, implementação da
 * regra de negocio e uma interface para acesso as respostas. 
 * input.json deve ser passado como parametro de JsonInputReader()
 * @author Marcos Vinicius Pereira da Silva
 */

public class ElevatorResults implements IElevadorService {
    private int elevA, elevB, elevC, elevD, elevE;
    private int turnoM, turnoV, turnoN;
    private List<Integer> elevadores;
    private List<Integer> andares;
    private List<Integer> turnos;
    
    
    public ElevatorResults(){
        this.andares = new ArrayList<>(Collections.nCopies(16,0));
        this.elevadores = new ArrayList<>(Collections.nCopies(5,0));
        this.turnos = new ArrayList<>(Collections.nCopies(3,0));
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
    
    /**
     * @return Retornar um array de floats contendo a porcentagem de uso de cada 
     * elevador, ordem alfabetica de elevadores -> A = 0,B = 1,C = 2,D = 3,E = 4
     * <p>
     * acesse usando metodo this.getElevPercent().get(index do array = elevador) 
     */    
    public List<Float> getElevPercent() { 
        ArrayList<Integer> totalUse = new ArrayList<>();
        List<Float> resultado = new ArrayList<>();
        for(Integer andar: this.andares){
            totalUse.add(andar);
        }
        //
        int maxUse = 0;
        for (int i = 0; totalUse.size() > i;i++){ //soma os usos para chegar ao total
            maxUse += totalUse.get(i);
        }
        //Elevador A
        float elevAMaxUse = 0; //condicional se for zero, evita divisão por zero
        if(this.elevadores.get(0)>0){ 
           elevAMaxUse =  this.elevadores.get(0) * 100; //calculo porcentagem
           elevAMaxUse = elevAMaxUse / maxUse; 
        }
        //Elevador B
        float elevBMaxUse = 0;        
        if(this.elevadores.get(1)>0){
           elevBMaxUse =  this.elevadores.get(1) * 100;
           elevBMaxUse = elevBMaxUse / maxUse; 
        }
        //Elevador C
        float elevCMaxUse = 0;        
        if(this.elevadores.get(2)>0){
           elevCMaxUse =  this.elevadores.get(2) * 100;
           elevCMaxUse = elevCMaxUse / maxUse; 
        }        
        //Elevador D
        float elevDMaxUse = 0;        
        if(this.elevadores.get(3)>0){
           elevDMaxUse =  this.elevadores.get(3) * 100;
           elevDMaxUse = elevDMaxUse / maxUse; 
        }        
        //Elevador E
        float elevEMaxUse = 0;        
        if(this.elevadores.get(4)>0){
           elevEMaxUse =  this.elevadores.get(4) * 100;
           elevEMaxUse = elevEMaxUse / maxUse; 
        }        
        //adiciona ao array de resultados
        resultado.add(elevAMaxUse);
        resultado.add(elevBMaxUse);
        resultado.add(elevCMaxUse);
        resultado.add(elevDMaxUse);
        resultado.add(elevEMaxUse);
    return resultado;
    }
    
    //elevadores setters
    public void addElevA (){
    this.elevadores.set(0, (this.elevadores.get(0) + 1));
    }
    
    public void addElevB (){
    this.elevadores.set(1, (this.elevadores.get(1) + 1));
    }

    public void addElevC (){
    this.elevadores.set(2, (this.elevadores.get(2) + 1));
    }

    public void addElevD (){
    this.elevadores.set(3, (this.elevadores.get(3) + 1));
    }

    public void addElevE (){
    this.elevadores.set(4, (this.elevadores.get(4) + 1));
    }     
    
    //turnos setters    
    public void addTurnoM (){
    this.turnos.set(0, (this.turnos.get(0) + 1));
    } 
    
    public void addTurnoV (){
    this.turnos.set(1, (this.turnos.get(1) + 1));
    }    
    
    public void addTurnoN (){
    this.turnos.set(2, (this.turnos.get(2) + 1));
    }
       
    //andares setters 
    public void addAndar0 () {    
    this.andares.set(0, (this.andares.get(0) + 1));
    }
    
    public void addAndar1 () {    
    this.andares.set(1, (this.andares.get(1) + 1));
    }
    
    public void addAndar2 () {    
    this.andares.set(2, (this.andares.get(2) + 1));
    }
    
    public void addAndar3 () {    
    this.andares.set(3, (this.andares.get(3) + 1));
    }

    public void addAndar4 () {    
    this.andares.set(4, (this.andares.get(4) + 1));
    }

    public void addAndar5 () {    
    this.andares.set(5, (this.andares.get(5) + 1));
    }

    public void addAndar6 () {    
    this.andares.set(6, (this.andares.get(6) + 1));
    }

    public void addAndar7 () {    
    this.andares.set(7, (this.andares.get(7) + 1));
    }

    public void addAndar8 () {    
    this.andares.set(8, (this.andares.get(8) + 1));
    }

    public void addAndar9 () {    
    this.andares.set(9, (this.andares.get(9) + 1));
    }

    public void addAndar10 () {    
    this.andares.set(10, (this.andares.get(10) + 1));
    }

    public void addAndar11 () {    
    this.andares.set(11, (this.andares.get(11) + 1));
    }
    
    public void addAndar12 () {    
    this.andares.set(12, (this.andares.get(12) + 1));
    }

    public void addAndar13 () {    
    this.andares.set(13, (this.andares.get(13) + 1));
    }
    
    public void addAndar14 () {    
    this.andares.set(14, (this.andares.get(14) + 1));
    }

    public void addAndar15 () {    
    this.andares.set(15, (this.andares.get(15) + 1));
    }

    @Override
    public List<Integer> andarMenosUtilizado() {
        List<Integer> resultado = new ArrayList<>();        
        int andarMin = Collections.min(this.andares); //menor valor
        int index = 0;
        
        for (Integer andaresUso : this.andares){ //Verifica duplicados
            if (andaresUso == andarMin){
                resultado.add(index); //adiciona duplicados
            }
            index++;
        }  
        return resultado;  
    }

    @Override
    public List<Character> elevadorMaisFrequentado() {
        List<Character> resultado = new ArrayList<>();        
        int elevadorMax = Collections.max(this.elevadores); //maior valor        
        int index = 65;//começa os caracteres com A, 65 = A
        
        for (Integer elevadoresUso : this.elevadores){ //Verifica duplicados
            if (elevadoresUso == elevadorMax){
                resultado.add((char)(index)); //adiciona duplicados
            }
            index++;
        }
        return resultado;
    }

    @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
        List<Character> resultado = new ArrayList<>();        
        int elevadorMax = Collections.max(this.elevadores); //maior valor        
        int index = 65;//começa os caracteres com A, 65 = A
        
        for (Integer elevadoresUso : this.elevadores){ //Verifica duplicados
            if (elevadoresUso == elevadorMax){
                resultado.add((char)(index)); //adiciona duplicados
            }
            index++;
        }
        return resultado;
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        List<Character> resultado = new ArrayList<>();        
        int elevadorMin = Collections.min(this.elevadores); //maior valor        
        int index = 65;//começa os caracteres com A, 65 = A
        
        for (Integer elevadoresUso : this.elevadores){ //Verifica duplicados
            if (elevadoresUso == elevadorMin){
                resultado.add((char)(index)); //adiciona duplicados
            }
            index++;
        }
        return resultado;
    }

    @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
        List<Character> resultado = new ArrayList<>();        
        List<Character> resultadoMaisFreq = elevadorMaisFrequentado();        
        List<Integer> usoElevador = new ArrayList<>();
        
        for (Character usoMaisFreq : resultadoMaisFreq){
           
                   
        }
        
        return resultado;
    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
        List<Character> resultado = new ArrayList<>();
        List<Character> turnosChar = new ArrayList<>();
        turnosChar.add('M');
        turnosChar.add('V');
        turnosChar.add('N');        
        int turnoMax = Collections.max(this.turnos); //maior valor        
        int index = 0;//
        
        for (Integer turnosUso : this.turnos){ //Verifica duplicados
            if (turnosUso == turnoMax){
                resultado.add(turnosChar.get(index)); //adiciona duplicados
            }
            index++;
        }
        return resultado;
    }

    @Override
    public float percentualDeUsoElevadorA() {
        float resultado = this.getElevPercent().get(0);
        DecimalFormat df = new DecimalFormat("0.##", DecimalFormatSymbols.getInstance(Locale.US));
        return Float.valueOf(df.format(resultado));
    }

    @Override
    public float percentualDeUsoElevadorB() {
        float resultado = this.getElevPercent().get(1);
        DecimalFormat df = new DecimalFormat("0.##", DecimalFormatSymbols.getInstance(Locale.US));
        return Float.valueOf(df.format(resultado));
    }

    @Override
    public float percentualDeUsoElevadorC() {
        float resultado = this.getElevPercent().get(2);
        DecimalFormat df = new DecimalFormat("0.##", DecimalFormatSymbols.getInstance(Locale.US));
        return Float.valueOf(df.format(resultado));
    }

    @Override
    public float percentualDeUsoElevadorD() {
        float resultado = this.getElevPercent().get(3);
        DecimalFormat df = new DecimalFormat("0.##", DecimalFormatSymbols.getInstance(Locale.US));
        return Float.valueOf(df.format(resultado));
    }

    @Override
    public float percentualDeUsoElevadorE() {
        float resultado = this.getElevPercent().get(4);
        DecimalFormat df = new DecimalFormat("0.##", DecimalFormatSymbols.getInstance(Locale.US));
        return Float.valueOf(df.format(resultado));
    }
    
}
