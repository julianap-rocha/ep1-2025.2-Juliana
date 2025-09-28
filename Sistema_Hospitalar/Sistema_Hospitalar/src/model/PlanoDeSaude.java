package model;

public class PlanoDeSaude {

    // Atributos da classe PlanoDeSaude
    private String nomePlano;
    private double descontoBase;
    private String descricaoPlano;
    private boolean permiteInternacaoEspecial;

    // Construtor vazio
    public PlanoDeSaude() {

    }

    // Construtor com parâmetros
    public PlanoDeSaude(String nomePlano, double descontoBase, String descricaoPlano,
            boolean permiteInternacaoEspecial) {
        this.nomePlano = nomePlano;
        this.descontoBase = descontoBase;
        this.descricaoPlano = descricaoPlano;
        this.permiteInternacaoEspecial = permiteInternacaoEspecial;
    }

    // Getters e Setters
    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public double getDescontoBase() {
        return descontoBase;
    }

    public void setDescontoBase(double descontoBase) {
        this.descontoBase = descontoBase;
    }

    public String getDescricaoPlano() {
        return descricaoPlano;
    }

    public void setDescricaoPlano(String descricaoPlano) {
        this.descricaoPlano = descricaoPlano;
    }

    public boolean isPermiteInternacaoEspecial() {
        return permiteInternacaoEspecial;
    }

    public void setPermiteInternacaoEspecial(boolean permiteInternacaoEspecial) {
        this.permiteInternacaoEspecial = permiteInternacaoEspecial;
    }

}
