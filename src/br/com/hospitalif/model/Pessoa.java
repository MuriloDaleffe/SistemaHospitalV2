package br.com.hospitalif.model.model;

public class Pessoa {

    private int idPessoa;
    private String nome;
    private String cpf;
    private int idade;
    private String tipoSanguineo;
    private char sexo;
    private String statusDePessoa;

    public Pessoa() {
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getStatusDePessoa() {
        return statusDePessoa;
    }

    public void setStatusDePessoa(String statusDePessoa) {
        this.statusDePessoa = statusDePessoa;
    }
}
