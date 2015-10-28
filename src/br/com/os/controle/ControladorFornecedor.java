/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.controle;

import br.com.os.entidade.Fornecedor;
import br.com.os.interfaces.JanelaCadastrarFornecedores;

public class ControladorFornecedor {

    public ControladorFornecedor() {
        new JanelaCadastrarFornecedores(this);
    }

    public String inserirFornecedor(Fornecedor fornecedor) {
        Fornecedor fornecedor1 = Fornecedor.buscarFornecedor(fornecedor.getId());
        if (fornecedor1 == null) {
            return Fornecedor.inserirFornecedor(fornecedor);

        } else {
            return "Fornecedor ja cadastrado";

        }
    }

    public String alterarFornecedor(Fornecedor fornecedor) {
        Fornecedor fornecedor1 = Fornecedor.buscarFornecedor(fornecedor.getId());
        if (fornecedor1 != null) {
            return Fornecedor.alterarFornecedor(fornecedor);

        } else {
            return "Fornecedor ja cadastrado";
        }
    }

    public String removerFornecedor(Integer id) {
        Fornecedor fornecedor1 = Fornecedor.buscarFornecedor(id);
        if (fornecedor1 != null) {
            return Fornecedor.removerFornecedor(id);
        }
        else {
            return "Erro na remoção";
        }

    }
}