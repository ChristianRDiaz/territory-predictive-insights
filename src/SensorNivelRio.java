import java.util.Random;

public class SensorNivelRio implements Sensor {
    private double valorAtual;
    private double limiteAlerta = 3.5; // metros
    private boolean funcionando = true;
    private Random random = new Random();

    @Override
    public double lerValor() {
        valorAtual = Math.round((0.5 + random.nextDouble() * 4.5) * 100.0) / 100.0;
        return valorAtual;
    }

    @Override
    public boolean verificarFuncionamento() {
        return funcionando;
    }

    @Override
    public String retornarTipo() {
        return "Nível do Rio";
    }

    @Override
    public double getLimiteAlerta() { // Acessor
        return limiteAlerta;
    }

    @Override
    public void setLimiteAlerta(double limite) { //modificador
        if (limite <= 0) throw new IllegalArgumentException("Limite deve ser positivo.");
        this.limiteAlerta = limite;
    }

    public double getValorAtual() {
        return valorAtual;
    }
}
