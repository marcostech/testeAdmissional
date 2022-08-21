package com.marcos.testeAdmissional;

/** Programa criado para solucionar desafio admissional Apisul
 * <p>
 * Foi feito o tratamento de um arquivo JSON, implementação da
 * regra de negocio e uma interface para acesso as respostas.
 * input.json deve ser passado como parametro de JsonInputReader()
 * @author Marcos Vinicius Pereira da Silva
 */

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ElevatorResults implements IElevadorService {
    private List<Integer> periodosElevadorMaisUsado;
    private List<Integer> periodosElevadorMenosUsado;
    private List<Integer> elevadores;
    private List<Integer> andares;
    private List<Integer> turnos;
        
    public ElevatorResults(){
        //incia listas zeradas para armazenamento dos valores
        this.andares = new ArrayList<>(Collections.nCopies(16,0));
        this.elevadores = new ArrayList<>(Collections.nCopies(5,0));
        this.turnos = new ArrayList<>(Collections.nCopies(3,0));
        this.periodosElevadorMaisUsado = new ArrayList<>(Collections.nCopies(3,0));        
        this.periodosElevadorMenosUsado = new ArrayList<>(Collections.nCopies(3,0));
    }
    
    //metodos uteis
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
     
    //getters e setters    
    public void addAndar (int i) {    
        this.andares.set(i, (this.andares.get(i) + 1));
    }
    
    public void addElevador (int i) {
        int elevador = i - 65; //converte de A = ASCII para A = 0 e assim por diante
        this.elevadores.set(elevador, (this.elevadores.get(elevador) + 1));
    }
    
    public void addTurno (char i) {
        int turno = 0;
        if(i == 'M'){turno = 0;} //converte de M = ASCII para M = 0 e assim por diante
        if(i == 'V'){turno = 1;} //converte de V = ASCII para V = 0 e assim por diante
        if(i == 'N'){turno = 2;} //converte de N = ASCII para N = 0 e assim por diante
        this.turnos.set(turno, (this.turnos.get(turno) + 1));
    }
    
    public void addPeriodosElevadorMaisUsado(char i){
        int turno = 0;
        if(i == 'M'){turno = 0;} //converte de M = ASCII para M = 0 e assim por diante
        if(i == 'V'){turno = 1;} //converte de V = ASCII para V = 0 e assim por diante
        if(i == 'N'){turno = 2;} //converte de N = ASCII para N = 0 e assim por diante
        this.periodosElevadorMaisUsado.set(turno, (this.periodosElevadorMaisUsado.get(turno) + 1));
    }
    
    public void addPeriodosElevadorMenosUsado(char i){
        int turno = 0;
        if(i == 'M'){turno = 0;} //converte de M = ASCII para M = 0 e assim por diante
        if(i == 'V'){turno = 1;} //converte de V = ASCII para V = 0 e assim por diante
        if(i == 'N'){turno = 2;} //converte de N = ASCII para N = 0 e assim por diante
        this.periodosElevadorMenosUsado.set(turno, (this.periodosElevadorMenosUsado.get(turno) + 1));
    }
    
    public int getTurno (int i) {    
        return this.turnos.get(i);
    }
    
    public int getElevador (int i) {    
        return this.elevadores.get(i);
    }
    
    public int getAndar (int i) {    
        return this.andares.get(i);
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
        int periodoMais = Collections.max(this.periodosElevadorMaisUsado);
        
        for (Character elevadores: elevadorMaisFrequentado()){ //Verifica duplicados
            if(this.periodosElevadorMaisUsado.get(0) == periodoMais) {
                resultado.add('M'); //Maneira 1 de passar o char no resultado
            } else if(this.periodosElevadorMaisUsado.get(1) == periodoMais) {
                resultado.add('V');
            } else if(this.periodosElevadorMaisUsado.get(2) == periodoMais) {
                resultado.add('N');
            }            
        }
        return resultado;
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        List<Character> resultado = new ArrayList<>();        
        int elevadorMin = Collections.min(this.elevadores); //menor valor          
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
        int periodoMenos = Collections.max(this.periodosElevadorMenosUsado);
        
        for (Character elevadores: elevadorMenosFrequentado()){ //Verifica duplicados
            if(this.periodosElevadorMenosUsado.get(0) == periodoMenos) {
                resultado.add('M'); //Maneira 1 de passar o char no resultado
            } else if(this.periodosElevadorMenosUsado.get(1) == periodoMenos) {
                resultado.add('V');
            } else if(this.periodosElevadorMenosUsado.get(2) == periodoMenos) {
                resultado.add('N');
            }            
        }
        return resultado;
    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
        List<Character> resultado = new ArrayList<>();
        List<Character> turnosChar = new ArrayList<>();
        turnosChar.add('M'); //Maneira 2 de passar o char no resultado
        turnosChar.add('V');
        turnosChar.add('N');        
        int turnoMax = Collections.max(this.turnos); //maior valor        
        int index = 0;
        
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