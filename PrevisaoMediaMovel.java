import java.util.ArrayList;

public class PrevisaoMediaMovel extends EstrategiaPrevisao {
    private int tamanhoJanela;

    public PrevisaoMediaMovel(int tamanhoJanela) {
        super("Média Móvel");
        this.tamanhoJanela = tamanhoJanela;
    }

    @Override
    public double prever(ArrayList<Double> leituras) {
        if (leituras.isEmpty()) {
            return 0;
        }

        int inicio = Math.max(0, leituras.size() - tamanhoJanela);
        ArrayList<Double> ultimasLeituras = new ArrayList<>();

        for (int i = inicio; i < leituras.size(); i++) {
            ultimasLeituras.add(leituras.get(i));
        }

        double media = super.calcularMedia(ultimasLeituras);
        return Math.round(media * 100.0) / 100.0;
    }
}