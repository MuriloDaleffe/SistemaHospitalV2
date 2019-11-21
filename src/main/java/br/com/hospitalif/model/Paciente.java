package br.com.hospitalif.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Paciente extends Pessoa{

    @ManyToMany
    private List<EnfermidadePessoal> historicoDoenca;

    @OneToMany
    private List<Atendimento> historicoAtendimento;


    public List<EnfermidadePessoal> getHistoricoDoenca() {
        return historicoDoenca;
    }

    public void setHistoricoDoenca(List<EnfermidadePessoal> historicoDoenca) {
        this.historicoDoenca = historicoDoenca;
    }

    public List<Atendimento> getHistoricoAtendimento() {
        return historicoAtendimento;
    }

    public void setHistoricoAtendimento(List<Atendimento> historicoAtendimento) {
        this.historicoAtendimento = historicoAtendimento;
    }

    @Override
    public String toString() {
        return getNome() +
                "\t CPF=" + getCpf();
    }
}
