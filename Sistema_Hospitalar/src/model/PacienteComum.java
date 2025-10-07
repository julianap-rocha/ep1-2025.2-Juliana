package model;

//PacienteComum herda de Paciente para utilizar os atributos em comum
public class PacienteComum extends Paciente {

    // Atributos PessoaComum
    private String metodoPagamento;

    // Construtor vazio
    public PacienteComum() {

    }

    // Construtor com parâmetros
    public PacienteComum(String nome, String cpf, int idade, String metodoPagamento) {
        super(nome, cpf, idade);
        this.metodoPagamento = metodoPagamento;
    }

    // Método para calcular o custo da consulta de um paciente comum
    @Override
    public double calcularCustoConsulta(double custoBase) {
        // Como não tem o desconto do plano de saúde, só vai retornar o valor base.
        return custoBase;
    }

      @Override
    public String toCsvString() {
        //Formata os dados do paciente comum para salvar
        return getNome() + "," + getCpf() + "," + getIdade() + ",COMUM," + getMetodoPagamento();
    }

    // Getters e Setters
    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

}
