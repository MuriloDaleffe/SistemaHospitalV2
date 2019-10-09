package br.com.hospitalif.model;

public class Enfermeiro extends Funcionario {

    private int idEnfermeiro;
    private int numeroDeRegistro;

    public Enfermeiro() {
    }

    public int getIdEnfermeiro() {
        return idEnfermeiro;
    }

    public void setIdEnfermeiro(int idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }

    public int getNumeroDeRegistro() {
        return numeroDeRegistro;
    }

    public void setNumeroDeRegistro(int numeroDeRegistro) {
        this.numeroDeRegistro = numeroDeRegistro;
    }
}
