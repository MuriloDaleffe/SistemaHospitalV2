package br.com.hospitalif.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String comentarioEnfermeiro;
    private String comentarioMedico;
    private LocalDate data;

    @OneToOne
    private Paciente paciente;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<EnfermidadePessoal> situacaoDoenca;


    public Atendimento() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<EnfermidadePessoal> getSituacaoDoenca() {
        return situacaoDoenca;
    }

    public void setSituacaoDoenca(List<EnfermidadePessoal> situacaoDoenca) {
        this.situacaoDoenca = situacaoDoenca;
    }

    @Override
    public String toString() {
        return getPaciente().getNome() +
                "\t" + getData();
    }
}
