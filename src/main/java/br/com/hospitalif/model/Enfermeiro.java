package br.com.hospitalif.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Enfermeiro")
public class Enfermeiro extends Funcionario {

    private int numeroDeRegistro;

    public int getNumeroDeRegistro() {
        return numeroDeRegistro;
    }

    public void setNumeroDeRegistro(int numeroDeRegistro) {
        this.numeroDeRegistro = numeroDeRegistro;
    }
}
