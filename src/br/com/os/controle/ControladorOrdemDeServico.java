/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.controle;

import br.com.os.entidade.OrdemDeServico;
import br.com.os.entidade.Produto;
import br.com.os.entidade.ProdutoPeca;
import br.com.os.interfaces.JanelaCadastrarOrdemDeServico;

/**
 *
 * @author Gustavo
 */
public class ControladorOrdemDeServico {

    public ControladorOrdemDeServico() {
        new JanelaCadastrarOrdemDeServico(this);
    }

    public String inserirOrdem(OrdemDeServico ordem) {
        OrdemDeServico os1 = OrdemDeServico.buscarOrdem(ordem.getId());
        if (os1 == null) {
            return OrdemDeServico.inserirOrdem(ordem);

        } else {
            return "Ordem de serviço ja cadastrado";

        }
    }

    public String alterarOrdemDeServico(OrdemDeServico ordem) {
        OrdemDeServico ordem1 = OrdemDeServico.buscarOrdem(ordem.getId());
        if (ordem1 != null) {
            return OrdemDeServico.alterarOrdem(ordem);

        } else {
            return "Ordem De Servico ja cadastrado";

        }
    }
    
        public String atualizarProduto(ProdutoPeca produto) {
        Produto produto1 = Produto.buscarProduto(produto.getId());
        if (produto1 != null) {
            return Produto.atualizarProduto(produto);
        } else {
            return "Produto ja cadastrado";
        }
    }

    public String removerOrdemDeServico(Integer id) {
        OrdemDeServico ordem1 = OrdemDeServico.buscarOrdem(id);
        if (ordem1 != null) {
            return OrdemDeServico.removerOrdem(id);

        } else {
            return "Erro na remoção";
        }

    }
}
