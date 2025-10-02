package model;

import java.util.ArrayList;
import java.util.List;

//Paciente herda de Pessoa para utilizar o atributo em comum
public class Paciente extends Pessoa {

    // Atributos de Pessoa
    private String cpf;
    private int idade;
    private List<Consulta> historicoConsultas;
    private List<Internacao> historicoInternacoes;

    // Construtor vazio
    public Paciente() {

    }

    // Construtor com parâmetros
    public Paciente(String nome, String cpf, int idade) {
        super(nome);
        this.cpf = cpf;
        this.idade = idade;
        this.historicoConsultas = new ArrayList<>();
        this.historicoInternacoes = new ArrayList<>();
    }

    /*
     * Calcula o custo da consulta, se for um paciente comum, o valor final é o
     * mesmo do valor base.
     */
    public double calcularCustoConsulta(double custoBase) {
        return custoBase;
    }

    /*
     * Verifica se um paciente tem um plano de saúde, se for um paciente comum a
     * resposta é não.
     */
    public boolean possuiPlano(String nomePlano) {
        return false;
    }

    // Getters e Setters
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

    public List<Consulta> getHistoricoConsultas() {
        return historicoConsultas;
    }

    public void setHistoricoConsultas(List<Consulta> historicoConsultas) {
        this.historicoConsultas = historicoConsultas;
    }

    public List<Internacao> getHistoricoInternacoes() {
        return historicoInternacoes;
    }

    public void setHistoricoInternacoes(List<Internacao> historicoInternacoes) {
        this.historicoInternacoes = historicoInternacoes;
    }

}
