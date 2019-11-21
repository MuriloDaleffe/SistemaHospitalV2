package br.com.hospitalif.model;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Entrada {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String statusDeEntrada;

    @OneToMany
    private List<Atendimento> situacaoDePaciente;

    public Entrada() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setSituacaoDePaciente(List<Atendimento> situacaoDePaciente) {
        this.situacaoDePaciente = situacaoDePaciente;
    }
}
