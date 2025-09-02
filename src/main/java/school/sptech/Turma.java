package school.sptech;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;

    public Turma(String nome, Double mensalidade){
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.qtdAluno = 0;
        this.ativa = true;
    }

    public void matricular(Integer qtd){
        if (qtd != null && qtd > 0 && this.ativa){
            this.qtdAluno += qtd;
        }
    }

    public Integer cancelar(Integer qtd){
        if (qtd != null && qtd > 0 && this.qtdAluno >= qtd && this.ativa){
            this.qtdAluno -= qtd;
            return qtd;
        }
        return null;
    }

    public Integer desativar(){
        if (this.ativa){
            Integer qtdAntes = this.qtdAluno;
            this.qtdAluno = 0;
            this.ativa = false;
            return qtdAntes;
        }
        return null;
    }

    public void transferir(Turma destino, Integer qtdATransferir){
        if (qtdATransferir != null && destino != null && qtdATransferir > 0 && this.qtdAluno >= qtdATransferir && this.ativa && destino.ativa){
            destino.qtdAluno += qtdATransferir;
            this.qtdAluno -= qtdATransferir;
        }
    }

    public Boolean reajustarMensalidade(Double reajuste){
        if (reajuste != null && reajuste > 0){
            this.mensalidade += this.mensalidade * reajuste;
            return true;
        }
        return false;
    }

    public String getNome(){
        return this.nome;
    }

    public Double getMensalidade(){
        return this.mensalidade;
    }

    public Integer getQtdAluno(){
        return this.qtdAluno;
    }

    public Boolean getAtiva(){
        return this.ativa;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
