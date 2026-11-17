public class DadosTerritorio {
    private String regiao;
    private int populacao;
    private double limiarChuva;
    private double limiarNivelRio;
    private double limiarUmidade;

    private final String codigoAcesso = "GLOBAL2026";

    public DadosTerritorio(String regiao, int populacao, double limiarChuva, double limiarNivelRio, double limiarUmidade) {
        this.regiao = regiao;
        this.populacao = populacao;
        this.limiarChuva = limiarChuva;
        this.limiarNivelRio = limiarNivelRio;
        this.limiarUmidade = limiarUmidade;
    }

    public String getRegiao() { return regiao; }
    public int getPopulacao() { return populacao; }
    public double getLimiarChuva() { return limiarChuva; }
    public double getLimiarNivelRio() { return limiarNivelRio; }
    public double getLimiarUmidade() { return limiarUmidade; }

    public boolean verificarSenha(String codigo) {
        if (codigoAcesso.equals(codigo)) {
            return true;
        } else {
            System.out.println("[ACESSO NEGADO] Código de acesso incorreto.");
            return false;
        }
    }

    public boolean alterarLimiares(String codigo, double chuva, double rio, double umidade) {
        if (!codigoAcesso.equals(codigo)) {
            System.out.println("[ACESSO NEGADO] Código de acesso incorreto.");
            return false;
        }
        if (chuva <= 0 || rio <= 0 || umidade < 0 || umidade > 100) {
            System.out.println("[REJEITADO] Chuva e Rio devem ser maiores que zero. Umidade entre 0 e 100.");
            return false;
        }
        this.limiarChuva = chuva;
        this.limiarNivelRio = rio;
        this.limiarUmidade = umidade;
        System.out.println("[OK] Limiares atualizados com sucesso.");
        return true;
    }
}