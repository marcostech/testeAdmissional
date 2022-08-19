package com.marcos.testeadm;

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

public class Elevatortest {
    public static void main(String[] args) {   
        IElevadorService resultados = JsonInputReader.input(".//resources//input.json");        
        System.out.println(resultados.andarMenosUtilizado());
        System.out.println(resultados.elevadorMaisFrequentado());
        System.out.println(resultados.elevadorMenosFrequentado());
        System.out.println(resultados.percentualDeUsoElevadorA());
        System.out.println(resultados.percentualDeUsoElevadorB());
        System.out.println(resultados.percentualDeUsoElevadorC());
        System.out.println(resultados.percentualDeUsoElevadorD());
        System.out.println(resultados.percentualDeUsoElevadorE());
        System.out.println(resultados.periodoMaiorFluxoElevadorMaisFrequentado());
        System.out.println(resultados.periodoMaiorUtilizacaoConjuntoElevadores());
        System.out.println(resultados.periodoMenorFluxoElevadorMenosFrequentado());
               
}
    
}
       /* Metodo funcionando
        System.out.println("Resposta A :\n" + resultado.respostaA() + "\n----------");
        System.out.println("Resposta B :\n" + resultado.respostaB() + "\n----------");
        System.out.println("Resposta C :\n" + resultado.respostaC() + "\n----------");
        System.out.println("Resposta D :\n" + resultado.respostaD() + "\n----------");
        System.out.println("Resposta E :\n" + resultado.respostaE() + "----------");
        */