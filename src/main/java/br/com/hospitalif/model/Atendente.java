package br.com.hospitalif.model;

public class Atendente extends Gerente {

    private int idAtendente;

    public int getIdAtendente() {
        return idAtendente;
    }

    public void setIdAtendente(int idAtendente) {
        this.idAtendente = idAtendente;
    }

    public int cadastrarPaciente(){
        return 1;
    }
}
