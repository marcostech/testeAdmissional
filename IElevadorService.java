package com.marcos.testeadm;

import java.util.List;

/** Programa criado para solucionar desafio admissional Apisul
 * <p>
 * Foi feito o tratamento de um arquivo JSON, implementação da
 * regra de negocio e uma interface para acesso as respostas.
 * @author Marcos Vinicius Pereira da Silva
 */

public interface IElevadorService {
/** @return  retornar uma List contendo o(s) andar(es) menos utilizado(s)*/
    List<Integer> andarMenosUtilizado();

    /** @return retorna uma List contendo o(s) elevador(es) mais frequentado(s)*/
    List<Character> elevadorMaisFrequentado();

    /** @return retorna uma List contendo o período de maior fluxo de cada um dos elevadores mais frequentados (se houver mais de um)*/
    List<Character> periodoMaiorFluxoElevadorMaisFrequentado();

    /** @return retorna uma List contendo o(s) elevador(es) menos frequentado(s)*/
    List<Character> elevadorMenosFrequentado();

    /** @return retorna uma List contendo o período de menor fluxo de cada um dos elevadores menos frequentados (se houver mais de um) */
    List<Character> periodoMenorFluxoElevadorMenosFrequentado();

    /** @return retorna uma List contendo o(s) periodo(s) de maior utilização do conjunto de elevadores */
    List<Character> periodoMaiorUtilizacaoConjuntoElevadores();

    /** @return retorna um float (duas casas decimais) contendo o percentual de uso do elevador A em relação a todos os serviços prestados. */
    float percentualDeUsoElevadorA();

    /** @return retorna um float (duas casas decimais) contendo o percentual de uso do elevador B em relação a todos os serviços prestados */
    float percentualDeUsoElevadorB();

    /** @return retorna um float (duas casas decimais) contendo o percentual de uso do elevador C em relação a todos os serviços prestados  */
    float percentualDeUsoElevadorC();

    /** @return retorna um float (duas casas decimais) contendo o percentual de uso do elevador D em relação a todos os serviços prestados */
    float percentualDeUsoElevadorD();

    /** @return retorna um float (duas casas decimais) contendo o percentual de uso do elevador E em relação a todos os serviços prestados */
    float percentualDeUsoElevadorE();
    
    
}


/* Primeiro codigo funcional
    /**
    *Este Metodo irá retornar a resposta da pergunta A
    * <p>
    *Pergunta A:"Qual é o andar menos utilizado pelos usuários"
    * <p>
    *Foram desenvolvidos varios outros metodos para
    *chegar até a resposta desejada, para verificar acesse ElevatorResults
    *e verifique os metodos getAndarUsage, getElevUsage, getTurnoUsage, getElevPercent;
    *@return uma String contendo a resposta formatada    
    */
    //public String respostaA ();
    
    /**
    *Este Metodo irá retornar a resposta da pergunta B
    * <p>
    *Pergunta B:"Qual é o elevador mais frequentado e o período que se encontra maior fluxo"
    * <p>
    *Foram desenvolvidos varios outros metodos para
    *chegar até a resposta desejada, para verificar acesse ElevatorResults
    *e verifique os metodos getAndarUsage, getElevUsage, getTurnoUsage, getElevPercent;
    *@return uma String contendo a resposta formatada    
    */    
    //public String respostaB ();
    
    /**
    *Este Metodo irá retornar a resposta da pergunta C
    * <p>
    *Pergunta C:"Qual é o elevador menos frequentado e o período que se encontra menor fluxo"
    * <p>
    *Foram desenvolvidos varios outros metodos para
    *chegar até a resposta desejada, para verificar acesse ElevatorResults
    *e verifique os metodos getAndarUsage, getElevUsage, getTurnoUsage, getElevPercent;
    *@return uma String contendo a resposta formatada    
    */    
    //public String respostaC ();
    
    /**
    *Este Metodo irá retornar a resposta da pergunta D
    * <p>
    *Pergunta D:"Qual o período de maior utilização do conjunto de elevadores"
    * <p>
    *Foram desenvolvidos varios outros metodos para
    *chegar até a resposta desejada, para verificar acesse ElevatorResults
    *e verifique os metodos getAndarUsage, getElevUsage, getTurnoUsage, getElevPercent;
    *@return uma String contendo a resposta formatada    
    */    
    //public String respostaD ();
    
    /**
    *Este Metodo irá retornar a resposta da pergunta E
    * <p>
    *Pergunta E:"Qual o percentual de uso de cada elevador com relação a todos os serviços prestados"
    * <p>
    *Foram desenvolvidos varios outros metodos para
    *chegar até a resposta desejada, para verificar acesse ElevatorResults
    *e verifique os metodos getAndarUsage, getElevUsage, getTurnoUsage, getElevPercent;
    *@return uma String contendo a resposta formatada    
    */    
    //public String respostaE ();
       
    //public ElevatorResults input (String path); //Entrada do arquivo Json via