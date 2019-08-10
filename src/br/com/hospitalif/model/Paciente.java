package br.com.hospitalif.model.model;

import java.util.List;

public class Paciente {

    private int idPaciente;
    private List<EnfermidadePessoal> doenca;
    private List<Entrada> historico;
    private Pessoa pessoa;

    public Paciente() {
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public List<EnfermidadePessoal> getDoenca() {
        return doenca;
    }

    public void setDoenca(List<EnfermidadePessoal> doenca) {
        this.doenca = doenca;
    }

    public List<Entrada> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Entrada> historico) {
        this.historico = historico;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
