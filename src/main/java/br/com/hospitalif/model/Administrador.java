package br.com.hospitalif.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Administrador")
public class Administrador extends Gerente {

    public int cadastrarFuncionario(){
        return 1;
    }
}
