/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.entidade;

/**
 *
 * @author Gustavo
 */
public class ProdutoPeca extends Produto {

    private int quantidade;
    private String qualidade;

    public ProdutoPeca(Integer id, int idFornecedor, String descricao,String qualidade, int quantidade, float preco) {
        super(id, idFornecedor, descricao, preco);

        this.quantidade = quantidade;
        this.qualidade = qualidade;
    
}
    public ProdutoPeca(Integer id, String qualidade, int quantidade){
        super(id);
        this.quantidade=quantidade;
        this.qualidade=qualidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }
 
    
}
