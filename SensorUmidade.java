import java.util.Random;

public class SensorUmidade implements Sensor {
    private double valorAtual;
    private double limiteAlerta = (double)85.0F;
    private boolean funcionando = true;
    private Random random = new Random();

    public SensorUmidade() {
    }

    public double lerValor() {
        this.valorAtual = (double)Math.round(((double)30.0F + this.random.nextDouble() * (double)70.0F) * (double)10.0F) / (double)10.0F;
        return this.valorAtual;
    }

    public boolean verificarFuncionamento() {
        return this.funcionando;
    }

    public String retornarTipo() {
        return "Umidade";
    }

    public double getLimiteAlerta() {
        return this.limiteAlerta;
    }

    public void setLimiteAlerta(double limiteAlerta) {
        if (!(limiteAlerta < (double)0.0F) && !(limiteAlerta > (double)100.0F)) {
            this.limiteAlerta = limiteAlerta;
        } else {
            throw new IllegalArgumentException("Umidade deve estar entre 0 e 100.");
        }
    }

    public double getValorAtual() {
        return this.valorAtual;
    }
}
