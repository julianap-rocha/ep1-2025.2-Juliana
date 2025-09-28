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

    // Getters e Setters
    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

}
