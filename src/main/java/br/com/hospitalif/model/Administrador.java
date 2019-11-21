package br.com.hospitalif.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Administrador extends Gerente {


    public int cadastrarFuncionario(){
        return 1;
    }
}
