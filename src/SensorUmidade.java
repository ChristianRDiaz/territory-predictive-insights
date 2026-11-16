import java.util.Random;

public class SensorUmidade implements Sensor {
    private double valorAtual;
    private double limiteAlerta = 85.0; // %
    private boolean funcionando = true;
    private Random random = new Random();

    @Override
    public double lerValor() {
        valorAtual = Math.round((30 + random.nextDouble() * 70) * 10.0) / 10.0;
        return valorAtual;
    }

    @Override
    public boolean verificarFuncionamento() {
        return funcionando;
    }

    @Override
    public String retornarTipo() {
        return "Umidade";
    }

    @Override
    public double getLimiteAlerta() {
        return limiteAlerta;
    }

    @Override
    public void setLimiteAlerta(double limite) {
        if (limite < 0 || limite > 100)
            throw new IllegalArgumentException("Umidade deve estar entre 0 e 100.");
        this.limiteAlerta = limite;
    }

    public double getValorAtual() {
        return valorAtual;
    }
}
