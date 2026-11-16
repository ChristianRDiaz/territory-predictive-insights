public interface Sensor { //diz que metodos vc deve implementar, mas nn como eles devem funcionar por dentro
    double lerValor();

    boolean verificarFuncionamento();

    String retornarTipo();

    double getLimiteAlerta();

    void setLimiteAlerta(double limite);
}