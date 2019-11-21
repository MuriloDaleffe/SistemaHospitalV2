package br.com.hospitalif.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Atendente extends Gerente {

    public int cadastrarPaciente(){
        return 1;
    }
}
