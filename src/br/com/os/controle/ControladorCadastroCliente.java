/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.controle;

import br.com.os.entidade.Cliente;
import br.com.os.interfaces.JanelaCadastrarAlterarCliente;

/**
 *
 * @author Gustavo
 */
public class ControladorCadastroCliente {

    public ControladorCadastroCliente() {

        new JanelaCadastrarAlterarCliente(this);
    }

    public String inserirCliente(Cliente cliente) {
        Cliente cliente1 = Cliente.buscarCliente(cliente.getId());
        if (cliente1 == null) {
            return Cliente.inserirCliente(cliente);

        } else {
            return "Cliente ja cadastrado";
        }
    }

    public String alterarCliente(Cliente cliente) {
        Cliente cliente1 = Cliente.buscarCliente(cliente.getId());
        if (cliente1 != null) {
            return Cliente.alterarCliente(cliente);
        } else {
            return "Cliente ja cadastrado";
        }
    }
    
    public String removerCliente(Integer id){
         Cliente cliente1 = Cliente.buscarCliente(id);
        if (cliente1 != null) {
            return Cliente.removerCliente(id);

        } else {
            return "Cliente ja cadastrado";

        }
    }
}