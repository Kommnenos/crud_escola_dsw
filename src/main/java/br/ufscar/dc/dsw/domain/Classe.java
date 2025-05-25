package br.ufscar.dc.dsw.domain;

import br.ufscar.dc.dsw.types.Periodo;

public class Classe {
    private int id;
    private String nome;
    private short sala_num;
    private char predio;
    private Periodo periodo;
    private boolean em_curso;
    private byte serie;
    private short ano;

    public Classe(int id, String nome, short sala_num, char predio, Periodo periodo, boolean em_curso, byte serie, short ano) {
        this.id = id;
        this.sala_num = sala_num;
        this.predio = predio;
        this.periodo = periodo;
        this.em_curso = em_curso;
        this.serie = serie;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public short getSala_num() {
        return sala_num;
    }

    public void setSala_num(short sala_num) {
        this.sala_num = sala_num;
    }

    public char getPredio() {
        return predio;
    }

    public void setPredio(char predio) {
        this.predio = predio;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public boolean isEm_curso() {
        return em_curso;
    }

    public void setEm_curso(boolean em_curso) {
        this.em_curso = em_curso;
    }

    public byte getSerie() {
        return serie;
    }

    public void setSerie(byte serie) {
        this.serie = serie;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }
}
