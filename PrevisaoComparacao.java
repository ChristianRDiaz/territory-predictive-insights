import java.util.ArrayList;

public class PrevisaoComparacao extends EstrategiaPrevisao {
    private int tamanhoPeriodo;

    public PrevisaoComparacao(int tamanhoPeriodo) {
        super("Comparação de Períodos");
        this.tamanhoPeriodo = tamanhoPeriodo;
    }

    @Override
    public double prever(ArrayList<Double> leituras) {
        if (leituras.size() < tamanhoPeriodo * 2) {
            return super.calcularMedia(leituras);
        }

        int n = leituras.size();

        ArrayList<Double> periodoAtual = new ArrayList<>();
        for (int i = n - tamanhoPeriodo; i < n; i++) {
            periodoAtual.add(leituras.get(i));
        }

        ArrayList<Double> periodoAnterior = new ArrayList<>();
        for (int i = n - (tamanhoPeriodo * 2); i < n - tamanhoPeriodo; i++) {
            periodoAnterior.add(leituras.get(i));
        }

        double mediaAtual = super.calcularMedia(periodoAtual);
        double mediaAnterior = super.calcularMedia(periodoAnterior);

        double tendencia = mediaAtual - mediaAnterior;
        double previsao = mediaAtual + tendencia;

        return Math.round(previsao * 100.0) / 100.0;
    }
}