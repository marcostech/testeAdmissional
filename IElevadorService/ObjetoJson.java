package com.marcos.testeAdmissional;

/** Programa criado para solucionar desafio admissional Apisul
 * <p>
 * Foi feito o tratamento de um arquivo JSON, implementação da
 * regra de negocio e uma interface para acesso as respostas.
 * input.json deve ser passado como parametro de JsonInputReader()
 * @author Marcos Vinicius Pereira da Silva
 */

public class ObjetoJson {
    private int andar;
    private Character turno;
    private Character elevador;
    
    public int getAndar(){
        return this.andar;
    }
    
    public Character getTurno(){
        return this.turno;
    }
    
    public Character getElevador(){
        return this.elevador;
    }
}

