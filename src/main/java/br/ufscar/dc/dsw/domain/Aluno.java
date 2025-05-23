package br.ufscar.dc.dsw.domain;

public class Aluno {
    private long id;
    private String nome;
    private String sobrenome;
    private boolean pcd;
    private short ano_nasc;
    private Classe classe;
    private boolean cursando;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public boolean isPcd() {
        return pcd;
    }

    public void setPcd(boolean pcd) {
        this.pcd = pcd;
    }

    public short getAno_nasc() {
        return ano_nasc;
    }

    public void setAno_nasc(short ano_nasc) {
        this.ano_nasc = ano_nasc;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public boolean isCursando() {
        return cursando;
    }

    public void setCursando(boolean cursando) {
        this.cursando = cursando;
    }
}
