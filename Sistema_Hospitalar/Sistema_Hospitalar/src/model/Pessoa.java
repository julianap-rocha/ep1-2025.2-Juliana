package model;

/*Pessoa é abstract porque é um conceito genérico.
 No sistema temos classes mais específicas*/
public abstract class Pessoa {

    // Atributos da classe pessoa
    private String nome;

    // Construtor vazio
    public Pessoa() {

    }

    // Construtor com parâmetros
    public Pessoa(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
