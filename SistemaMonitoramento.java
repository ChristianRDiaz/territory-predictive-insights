import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMonitoramento {
    static Scanner scanner = new Scanner(System.in);
    static DadosTerritorio dados = new DadosTerritorio("Vila Esperança", 12000, 50.0, 3.5, 85.0);
    static SensorChuva chuva = new SensorChuva();
    static SensorNivelRio rio = new SensorNivelRio();
    static SensorUmidade umidade = new SensorUmidade();

    static ArrayList<Double> histChuva = new ArrayList<>();
    static ArrayList<Double> histRio = new ArrayList<>();
    static ArrayList<Double> histUmidade = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = 1;

        while (opcao != 0) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Coletar leituras");
            System.out.println("2. Rodar previsoes");
            System.out.println("3. Alterar limites (com senha)");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");

            opcao = scanner.nextInt();

            if (opcao == 1) {
                coletar();
            } else if (opcao == 2) {
                prever();
            } else if (opcao == 3) {
                alterarLimites();
            }
        }
        System.out.println("Sistema encerrado.");
    }

    static void coletar() {
        double valorChuva = chuva.lerValor();
        double valorRio = rio.lerValor();
        double valorUmidade = umidade.lerValor();

        histChuva.add(valorChuva);
        histRio.add(valorRio);
        histUmidade.add(valorUmidade);

        System.out.println("Leituras salvas: Chuva " + valorChuva + " | Rio " + valorRio + " | Umidade " + valorUmidade);
    }

    static void prever() {
        if (histChuva.size() < 2) {
            System.out.println("Precisa de mais leituras primeiro!");
            return;
        }

        PrevisaoMediaMovel media = new PrevisaoMediaMovel(3);
        PrevisaoComparacao comparacao = new PrevisaoComparacao(3);

        System.out.println("\n--- RESULTADO DAS PREVISOES ---");

        double prevChuva = comparacao.prever(histChuva);
        verificarAlerta("Chuva (mm)", prevChuva, dados.getLimiarChuva());

        double prevRio = comparacao.prever(histRio);
        verificarAlerta("Nível do Rio (metros)", prevRio, dados.getLimiarNivelRio());

        double prevUmidade = comparacao.prever(histUmidade);
        verificarAlerta("Umidade (%)", prevUmidade, dados.getLimiarUmidade());
    }

    static void verificarAlerta(String nomeSensor, double previsao, double limite) {
        if (previsao < 0) previsao = 0;
        double porcentagem = (previsao / limite) * 100;

        System.out.printf("\nSENSOR: %s\n", nomeSensor);
        System.out.printf("Valor previsto: %.2f (%.1f%% do limite de %.1f)\n", previsao, porcentagem, limite);

        if (porcentagem >= 130) {
            System.out.println("[CRÍTICO] Risco iminente! Acione a Defesa Civil.");
        } else if (porcentagem >= 100) {
            System.out.println("[ALERTA] Limite ultrapassado! Prepare equipes de prevenção.");
        } else if (porcentagem >= 85) {
            System.out.println("[ATENÇÃO] Próximo do limite. Monitore a situação.");
        } else {
            System.out.printf("[OK] Dentro dos limites (%.1f%% abaixo do limite).\n", (100 - porcentagem));
        }
    }

    static void alterarLimites() {
        System.out.println("Digite o codigo de acesso:");
        String senha = scanner.next();

        if (!dados.verificarSenha(senha)) {
            return;
        }

        System.out.println("Acesso liberado!");
        System.out.println("\nQual limite deseja alterar?");
        System.out.println("1. Chuva");
        System.out.println("2. Rio");
        System.out.println("3. Umidade");
        System.out.print("Opcao: ");
        int opcaoLimite = scanner.nextInt();

        double chuva = dados.getLimiarChuva();
        double rio = dados.getLimiarNivelRio();
        double umidade = dados.getLimiarUmidade();

        if (opcaoLimite == 1) {
            System.out.println("Novo limite de chuva (mm milímetros):");
            chuva = scanner.nextDouble();
        } else if (opcaoLimite == 2) {
            System.out.println("Novo limite de rio (metros):");
            rio = scanner.nextDouble();
        } else if (opcaoLimite == 3) {
            System.out.println("Novo limite de umidade (% porcentagem):");
            umidade = scanner.nextDouble();
        }

        dados.alterarLimiares(senha, chuva, rio, umidade);
    }
}