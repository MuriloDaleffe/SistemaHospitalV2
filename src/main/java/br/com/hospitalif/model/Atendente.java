package br.com.hospitalif.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Atendente")
public class Atendente extends Gerente {


    public int cadastrarPaciente(){
        return 1;
    }
}
