import java.util.ArrayList;

public abstract class EstrategiaPrevisao {
    private String nomeEstrategia;

    public EstrategiaPrevisao(String nomeEstrategia) {
        this.nomeEstrategia = nomeEstrategia;
    }

    public abstract double prever(ArrayList<Double> leituras);

    public String getNomeEstrategia() {
        return nomeEstrategia;
    }

    protected double calcularMedia(ArrayList<Double> leituras) {
        if (leituras.isEmpty()) return 0;
        double soma = 0;
        for (double valor : leituras) {
            soma = soma + valor;
        }
        return soma / leituras.size();
    }
}