package br.com.hospitalif.model;

import java.util.Date;
import java.util.List;

public class Atendimento {

    private int idAtendimento;
    private String comentarioEnfermeiro;
    private String comentarioMedico;
    private float peso;
    private float altura;
    private Date data;
    private List<EnfermidadePessoal> doenca;
    private Enfermeiro enfermeiro;
    private Medico medico;

    public Atendimento() {
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public String getComentarioEnfermeiro() {
        return comentarioEnfermeiro;
    }

    public void setComentarioEnfermeiro(String comentarioEnfermeiro) {
        this.comentarioEnfermeiro = comentarioEnfermeiro;
    }

    public String getComentarioMedico() {
        return comentarioMedico;
    }

    public void setComentarioMedico(String comentarioMedico) {
        this.comentarioMedico = comentarioMedico;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<EnfermidadePessoal> getDoenca() {
        return doenca;
    }

    public void setDoenca(List<EnfermidadePessoal> doenca) {
        this.doenca = doenca;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
