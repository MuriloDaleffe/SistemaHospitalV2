package br.com.hospitalif.model;

import java.util.Date;
import java.util.List;

public class Entrada extends Paciente {

    private int idEntrada;
    private Date dataEntrada;
    private Date dataSaida;
    private String statusDeEntrada;
    private List<Atendimento> situacaoDePaciente;

    public Entrada() {
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getStatusDeEntrada() {
        return statusDeEntrada;
    }

    public void setStatusDeEntrada(String statusDeEntrada) {
        this.statusDeEntrada = statusDeEntrada;
    }

    public List<Atendimento> getSituacaoDePaciente() {
        return situacaoDePaciente;
    }

    public void setSituacaoDePaciente(List<Atendimento> situacaoDePaciente) {
        this.situacaoDePaciente = situacaoDePaciente;
    }

}
