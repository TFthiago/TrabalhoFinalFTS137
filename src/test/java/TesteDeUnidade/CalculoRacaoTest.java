package TesteDeUnidade;

import PetStoreCalc.CalculadoraRacao;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculoRacaoTest {


    //Testes positivos
    @Test
    @Order(1)
    public void testePositivoPortePequeno15kg(){

        assertEquals("A quantidade de ração ideal deverá ser de 150,00 gramas",
                CalculadoraRacao.calcular_racao_cao("P", 15));
    }

    @Test
    @Order(2)
    public void testeLimitePositivoPortePequeno(){

        assertEquals("A quantidade de ração ideal deverá ser de 149,90 gramas",
                CalculadoraRacao.calcular_racao_cao("P", 14.99));
    }

    @Test
    @Order(3)
    public void testePositivoPorteMedio30kg(){

        assertEquals("A quantidade de ração ideal deverá ser de 600,00 gramas",
                CalculadoraRacao.calcular_racao_cao("M", 30));
    }

    @Test
    @Order(4)
    public void testeLimitePositivoPorteMedio(){

        assertEquals("A quantidade de ração ideal deverá ser de 599,80 gramas",
                CalculadoraRacao.calcular_racao_cao("M", 29.99));
    }

    @Test
    @Order(5)
    public void testePositivoPorteGrande100kg(){

        assertEquals("A quantidade de ração ideal deverá ser de 3000,00 gramas",
                CalculadoraRacao.calcular_racao_cao("G", 100));
    }

    @Test
    @Order(6)
    public void testeLimitePositivoPorteGrande(){

        assertEquals("A quantidade de ração ideal deverá ser de 2999,70 gramas",
                CalculadoraRacao.calcular_racao_cao("G", 99.99));
    }


    //Testes negativos
    @Test
    @Order(7)
    public void testeNegativoLimiteMenorQueZero(){

        assertEquals("Valor não suportado! Apenas maiores que 0 e menores que 100",
                CalculadoraRacao.calcular_racao_cao("P", -1));

    }

    @Test
    @Order(8)
    public void testeNegativoLimiteMaiorQue100(){

        assertEquals("Valor não suportado! Apenas maiores que 0 e menores que 100",
                CalculadoraRacao.calcular_racao_cao("G", 101));

    }

    //Testes negativos com lista
    @Order(9)
    @ParameterizedTest
    @CsvSource(value = {
            "P,-0.40",
            "M,-5",
            "G,-10"
    }, delimiter = ',')
    public void testeNegativoLimiteMenorQueZeroLista(String porte, double peso){

        assertEquals("Valor não suportado! Apenas maiores que 0 e menores que 100",
                CalculadoraRacao.calcular_racao_cao(porte, peso));

    }

    @Order(10)
    @ParameterizedTest
    @CsvSource(value = {
            "P,100.01",
            "M,105",
            "G,150"
    }, delimiter = ',')
    public void testeNegativoLimiteMaiorQue100Lista(String porte, double peso){

        assertEquals("Valor não suportado! Apenas maiores que 0 e menores que 100",
                CalculadoraRacao.calcular_racao_cao(porte, peso));

    }

    //Testes Positivos com CSV
    @Order(11)
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/testePositivoPequeno.csv", numLinesToSkip = 1, delimiter = ',')
    public void testePositivoPortePequenoCsv(String porte, double peso){

        double quantidadeEsperada = peso * 10;
        String resultadoEsperado = String.format("A quantidade de ração ideal deverá ser de %.2f gramas", quantidadeEsperada);
        assertEquals(resultadoEsperado, CalculadoraRacao.calcular_racao_cao(porte, peso));

        System.out.println(CalculadoraRacao.calcular_racao_cao(porte, peso));
    }

    @Order(12)
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/testePositivoMedio.csv", numLinesToSkip = 1, delimiter = ',')
    public void testePositivoPorteMedioCsv(String porte, double peso){

        double quantidadeEsperada = peso * 20;
        String resultadoEsperado = String.format("A quantidade de ração ideal deverá ser de %.2f gramas", quantidadeEsperada);
        assertEquals(resultadoEsperado, CalculadoraRacao.calcular_racao_cao(porte, peso));

        System.out.println(CalculadoraRacao.calcular_racao_cao(porte, peso));
    }

    @Order(13)
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/testePositivoGrande.csv", numLinesToSkip = 1, delimiter = ',')
    public void testePositivoPorteGrandeCsv(String porte, double peso){

        double quantidadeEsperada = peso * 30;
        String resultadoEsperado = String.format("A quantidade de ração ideal deverá ser de %.2f gramas", quantidadeEsperada);
        assertEquals(resultadoEsperado, CalculadoraRacao.calcular_racao_cao(porte, peso));

        System.out.println(CalculadoraRacao.calcular_racao_cao(porte, peso));
    }


}
