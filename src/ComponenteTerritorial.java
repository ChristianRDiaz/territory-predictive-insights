public abstract class ComponenteTerritorial {
    private String id;
    private String nome;
    private String regiao;
    private boolean ativo;

    public ComponenteTerritorial(String id, String nome, String regiao) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
        System.out.println("[+] " + nome + " ativado.");
    }

    public void desativar() {
        this.ativo = false;
        System.out.println("[-] " + nome + " desativado.");
    }

    public abstract String verificarStatus();

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public String getStatus() {
        return this.ativo ? "ATIVO" : "INATIVO";
    }
}
