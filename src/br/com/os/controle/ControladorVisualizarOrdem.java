/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.controle;

import br.com.os.entidade.OrdemDeServico;
import br.com.os.interfaces.JanelaVisualizarOrdem;

/**
 *
 * @author Gustavo
 */
public class ControladorVisualizarOrdem {

    public ControladorVisualizarOrdem() {
        new JanelaVisualizarOrdem(this);
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
