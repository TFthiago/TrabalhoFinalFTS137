package PetStoreCalc;

import java.util.Scanner;

public class InterfaceUsuarioSistema {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o porte do seu cachorro aqui (P, M, G):");
        String porte = teclado.next().toUpperCase();
        while (!porte.equals("P") && !porte.equals("M") && !porte.equals("G")) {
            System.out.println("Por favor digite um tamanho suportado: P, M ou G");
            porte = teclado.next().toUpperCase();
        }
        switch (porte) {
            case "P" ->
                    System.out.println("Um cão de pequeno porte deveria estar entre 1kg e 15kg, atenção para valores muito diferentes");
            case "M" ->
                    System.out.println("Um cão de médio porte deveria estar entre 15kg e 30kg, atenção para valores muito diferentes");
            case "G" ->
                    System.out.println("Um cão de grande porte deveria estar entre 30kg e 100kg, atenção para valores muito diferentes");
        }


        System.out.println("Digite o peso do seu cachorro aqui:");
        double peso = teclado.nextDouble();
        while (peso <= 0 || peso > 100) {
            if (peso <= 0) {
                System.out.println("Por favor digite um valor positivo");
            } else {
                System.out.println("O valor não deve exceder os 100kg");
            }
            peso = teclado.nextDouble();
        }

        String resultado = CalculadoraRacao.calcular_racao_cao(porte, peso);
        System.out.println(resultado);

        teclado.close();
    }
}


