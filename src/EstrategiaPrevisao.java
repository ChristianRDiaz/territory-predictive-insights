import java.util.ArrayList;

public abstract class EstrategiaPrevisao {
    private String nomeEstrategia;

    public EstrategiaPrevisao(String nomeEstrategia) {
        this.nomeEstrategia = nomeEstrategia;
    }

    // Metodo abstrato que as filhas vão implementar
    public abstract double prever(ArrayList<Double> leituras);

    public String getNomeEstrategia() {
        return nomeEstrategia;
    }

    // Metodo auxiliar para calcular a média
    protected double calcularMedia(ArrayList<Double> leituras) {
        if (leituras.isEmpty()) return 0;
        double soma = 0;
        for (double valor : leituras) {
            soma = soma + valor;
        }
        return soma / leituras.size();
    }
}