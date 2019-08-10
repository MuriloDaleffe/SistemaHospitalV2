package br.com.hospitalif.model;

public class EnfermidadePessoal {

    private int idEnfermidadePessoal;
    private String comentario;
    private String statusDeEnfermidade;
    private Enfermidade enfermidade;

    public EnfermidadePessoal() {
    }

    public int getIdEnfermidadePessoal() {
        return idEnfermidadePessoal;
    }

    public void setIdEnfermidadePessoal(int idEnfermidadePessoal) {
        this.idEnfermidadePessoal = idEnfermidadePessoal;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getStatusDeEnfermidade() {
        return statusDeEnfermidade;
    }

    public void setStatusDeEnfermidade(String statusDeEnfermidade) {
        this.statusDeEnfermidade = statusDeEnfermidade;
    }

    public Enfermidade getEnfermidade() {
        return enfermidade;
    }

    public void setEnfermidade(Enfermidade enfermidade) {
        this.enfermidade = enfermidade;
    }
}
