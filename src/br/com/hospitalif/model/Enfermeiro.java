package br.com.hospitalif.model.model;

public class Enfermeiro extends Funcionario {

    private int numeroDeRegistro;

    public Enfermeiro() {
    }

    public int getNumeroDeRegistro() {
        return numeroDeRegistro;
    }

    public void setNumeroDeRegistro(int numeroDeRegistro) {
        this.numeroDeRegistro = numeroDeRegistro;
    }
}
