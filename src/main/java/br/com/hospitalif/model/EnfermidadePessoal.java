package br.com.hospitalif.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
public class EnfermidadePessoal extends Enfermidade {

    private String comentario;
    private String statusDeEnfermidade;

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

    @Override
    public String toString() {
        return getDescricao() +
                "\t" + getNome() + "\n";
    }
}
