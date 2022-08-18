package com.marcos.elevatortest;

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

public interface IElevadorService {
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
    public String respostaA ();
    
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
    public String respostaB ();
    
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
    public String respostaC ();
    
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
    public String respostaD ();
    
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
    public String respostaE ();
        
    //public ElevatorResults input (String path); //Entrada do arquivo Json via
    
    
}
