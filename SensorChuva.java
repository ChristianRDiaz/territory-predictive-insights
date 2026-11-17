import java.util.Random;

public class SensorChuva implements Sensor {
    private double valorAtual;
    private double limiteAlerta = (double)50.0F;
    private boolean funcionando = true;
    private Random random = new Random();

    public SensorChuva() {
    }

    public double lerValor() {
        this.valorAtual = (double)Math.round(this.random.nextDouble() * (double)120.0F * (double)10.0F) / (double)10.0F;
        return this.valorAtual;
    }

    public boolean verificarFuncionamento() {
        return this.funcionando;
    }

    public String retornarTipo() {
        return "Chuva";
    }

    public double getLimiteAlerta() {
        return this.limiteAlerta;
    }

    public void setLimiteAlerta(double limiteAlerta) {
        if (limiteAlerta < (double)0.0F) {
            throw new IllegalArgumentException("Limite não pode ser negativo.");
        } else {
            this.limiteAlerta = limiteAlerta;
        }
    }

    public double getValorAtual() {
        return this.valorAtual;
    }
}
