package PetStoreCalc;

public class CalculadoraRacao {


    public static String calcular_racao_cao(String porte, double peso) {

        // Verificação inicial de peso
        if (peso <= 0 || peso > 100) {
            return "Valor não suportado! Apenas maiores que 0 e menores que 100";
        }
        double quantidadeRacao = 0;

        switch (porte) {
            case "P":
                quantidadeRacao = peso <= 15 ? peso * 10 : 0;
                break;
            case "M":
                quantidadeRacao = (peso > 15 && peso <= 30) ? peso * 20 : 0;
                break;
            case "G":
                quantidadeRacao = peso > 30 ? peso * 30 : 0;
                break;
            default:
                return "Por favor digite um tamanho suportado: P, M ou G";
        }

        // Se o peso não estiver de acordo com o porte esperado, retorna uma mensagem específica
        if (quantidadeRacao == 0) {
            return "Peso não corresponde ao porte informado";
        }

        return String.format("A quantidade de ração ideal deverá ser de %.2f gramas", quantidadeRacao);
    }

}

