public class EstacaoDeColeta extends ComponenteTerritorial {
    private Sensor[] sensores;

    public EstacaoDeColeta(String id, String nome, String regiao, Sensor[] sensores) {
        super(id, nome, regiao);
        this.sensores = sensores;
        ativar();
    }

    @Override
    public String verificarStatus() {
        String texto = "Estação: " + getNome() + " [" + getStatus() + "]\n";

        for (Sensor s : sensores) {
            texto = texto + "  - Sensor de " + s.retornarTipo() + ": ";
            if (s.verificarFuncionamento()) {
                texto = texto + "OK\n";
            } else {
                texto = texto + "COM DEFEITO\n";
            }
        }

        return texto;
    }

    public Sensor[] getSensores() {
        return sensores;
    }
}