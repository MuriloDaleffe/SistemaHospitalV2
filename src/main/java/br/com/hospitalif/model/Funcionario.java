package br.com.hospitalif.model;

import javax.persistence.*;

@Entity
public abstract class Funcionario extends Pessoa{

    private String login;

    private String senha;

    private String statusDeUsuario;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatusDeUsuario() {
        return statusDeUsuario;
    }

    public void setStatusDeUsuario(String statusDeUsuario) {
        this.statusDeUsuario = statusDeUsuario;
    }

}
