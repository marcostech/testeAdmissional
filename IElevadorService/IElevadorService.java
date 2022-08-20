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
