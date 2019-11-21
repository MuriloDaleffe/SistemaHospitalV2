package br.com.hospitalif.model;

import javax.persistence.*;

@Entity
public class Medico extends Funcionario {

    private String numRegistro;

    private String especialidade;

    public Medico(long id, String nome, String numRegistro, String especialidade, String login, String senha, String cpf,
                  String stsusu, int idade, String tiposang, String sexo, String stspes) {
        this.numRegistro = numRegistro;
        this.especialidade = especialidade;
        this.setNome(nome);
        this.setStatusDePessoa(stspes);
        this.setSexo(sexo);
        this.setCpf(cpf);
        this.setIdade(idade);
        this.setSenha(senha);
        this.setLogin(login);
        this.setTipoSanguineo(tiposang);
        this.setStatusDeUsuario(stsusu);
        this.setId(id);
    }

    public Medico() {

    }


    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numeroRegistro) {
        this.numRegistro = numeroRegistro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "numRegistro='" + numRegistro + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", nome='" + getNome() + '\'' +
                ", CPF='" + getCpf() + '\'' +
                '}';
    }
}
