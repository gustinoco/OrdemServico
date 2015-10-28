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
public class ProdutoServico extends Produto {

    public enum Status {

        disponivel, indisponivel;

    }

    public static final Status[] status = {
        Status.disponivel, Status.indisponivel};

    private Status status2;
    private float tempoReparo;
    private int a;

    public ProdutoServico(int id, int idFornecedor, String descricao, Status status2, float tempoReparo, float preco) {
        super(id, idFornecedor, descricao, preco);
        this.status2 = status2;
        this.tempoReparo = tempoReparo;
    }

    public ProdutoServico(int id, Status status2, float tempoReparo) {
        super(id);
        this.status2 = status2;
        this.tempoReparo = tempoReparo;
    }

    public ProdutoServico(int id, int a, float tempoReparo) {
        super(id);
        this.a = a;
        this.tempoReparo = tempoReparo;
    }

    public int getStatus() {
        return a;
    }

    public Status getStatus2() {
        return status2;
    }

    public void setStatus2(Status status2) {
        this.status2 = status2;
    }

    public float getTempoReparo() {
        return tempoReparo;
    }

    public void setTempoReparo(float tempoReparo) {
        this.tempoReparo = tempoReparo;
    }

}
