package br.com.hospitalif.model;

public class Gerente extends Funcionario {

    private String cargo;
    private int idGerente;

    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public Gerente() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
