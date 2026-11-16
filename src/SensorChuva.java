import java.util.Random;

public class SensorChuva implements Sensor {
    private double valorAtual;
    private double limiteAlerta = 50.0; // mm
    private boolean funcionando = true;
    private Random random = new Random();

    @Override
    public double lerValor() {
        valorAtual = Math.round(random.nextDouble() * 120 * 10.0) / 10.0;
        return valorAtual;
    }

    @Override
    public boolean verificarFuncionamento() {
        return funcionando;
    }

    @Override
    public String retornarTipo() {
        return "Chuva";
    }

    @Override
    public double getLimiteAlerta() {
        return limiteAlerta;
    }

    @Override
    public void setLimiteAlerta(double limite) {
        if (limite < 0) throw new IllegalArgumentException("Limite não pode ser negativo.");
        this.limiteAlerta = limite;
    }

    public double getValorAtual() {
        return valorAtual;
    }
}
