/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.controle;

import br.com.os.entidade.Produto;
import br.com.os.entidade.ProdutoPeca;
import br.com.os.interfaces.JanelaProdutosPeca;

/**
 *
 * @author Gustavo
 */
public class ControladorProduto {

    public ControladorProduto() {
        new JanelaProdutosPeca(this);
    }

    public String inserirProduto(Produto produto) {
        Produto produto1 = Produto.buscarProdutoPeca(produto.getId());
        if (produto1 != null) {
            produto1 = Produto.buscarProdutoServico(produto.getId());
        }
        if (produto1 == null) {
            return Produto.inserirProduto(produto);
        } else {
            return "Produto ja cadastrado";
        }
    }

    public String alterarProduto(Produto produto) {
        Produto produto1 = Produto.buscarProduto(produto.getId());
        if (produto1 != null) {
            return Produto.alterarProduto(produto);
        } else {
            return "Produto ja cadastrado";
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

    public String removerProduto(Integer id) {
        Produto produto1 = Produto.buscarProduto(id);
        if (produto1 != null) {
            return Produto.removerProduto(id);

        } else {
            return "Produto ja cadastrado";

        }
    }

}
