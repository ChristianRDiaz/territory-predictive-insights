import java.util.Random;

public class SensorNivelRio implements Sensor {
    private double valorAtual;
    private double limiteAlerta = (double)3.5F;
    private boolean funcionando = true;
    private Random random = new Random();

    public SensorNivelRio() {
    }

    public double lerValor() {
        this.valorAtual = (double)Math.round(((double)0.5F + this.random.nextDouble() * (double)4.5F) * (double)100.0F) / (double)100.0F;
        return this.valorAtual;
    }

    public boolean verificarFuncionamento() {
        return this.funcionando;
    }

    public String retornarTipo() {
        return "Nível do Rio";
    }

    public double getLimiteAlerta() {
        return this.limiteAlerta;
    }

    public void setLimiteAlerta(double limiteAlerta) {
        if (limiteAlerta <= (double)0.0F) {
            throw new IllegalArgumentException("Limite deve ser positivo.");
        } else {
            this.limiteAlerta = limiteAlerta;
        }
    }

    public double getValorAtual() {
        return this.valorAtual;
    }
}
