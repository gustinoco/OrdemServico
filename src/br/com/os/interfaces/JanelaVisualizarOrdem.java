/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.interfaces;

import br.com.os.controle.ControladorVisualizarOrdem;
import br.com.os.entidade.Cliente;
import br.com.os.entidade.OrdemDeServico;
import br.com.os.entidade.Produto;
import br.com.os.entidade.Visão;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class JanelaVisualizarOrdem extends javax.swing.JInternalFrame {

    Vector<Visão<String>> ordens_cadastradas;
    ControladorVisualizarOrdem controlador;

    public JanelaVisualizarOrdem(ControladorVisualizarOrdem controlador) {

        this.controlador = controlador;
        ordens_cadastradas = OrdemDeServico.getVisões();
        JanelaPrincipal.getDeskpPanelPrincipal().add(this).setVisible(true);
        initComponents();

    }

    private void inicializaTextAra() {

        String cabecalho = "-------------------Ordem de serviço 1.0 -------------------"
                + "\n"
                + "\n"
                + "--------------------------------------------------------------------"
                + "\n";

        Visão<String> visão = (Visão<String>) comboOrdens.getSelectedItem();
        OrdemDeServico ordem = null;
        Produto produto = null;
        Cliente cliente = null;
        String msg_erro = null;
        if (visão != null) {
            ordem = OrdemDeServico.buscarOrdem(Integer.parseInt(visão.getChave()));
            produto = Produto.buscarProduto(ordem.getProduto());
            cliente = Cliente.buscarCliente(ordem.getCliente());

            if (ordem == null) {
                msg_erro = "Cliente nao encontrado";
            }
        }
        if (msg_erro == null) {
            float preco = ordem.getQuantidade() * produto.getPreco();
            textComprovante.setText(cabecalho);
            textComprovante.append("Descrição: ");
            textComprovante.append(produto.getDescricao());
            textComprovante.append("\n");
            textComprovante.append("Quantidade: ");
            textComprovante.append(String.valueOf(ordem.getQuantidade()));
            textComprovante.append("\n");
            textComprovante.append("Valor unitário: ");
            textComprovante.append(String.valueOf(produto.getPreco()));
            textComprovante.append("\n");
            textComprovante.append("Valor total: ");
            textComprovante.append(String.valueOf(preco));
            textComprovante.append("\n");
            textComprovante.append("--------------------------------------------------------------------".concat("\n"));
            textComprovante.append("Cliente: ");
            textComprovante.append(cliente.getNome().concat("\t").concat("Cpf: ").concat(cliente.getCpf()));

        } else {
            JOptionPane.showMessageDialog(this, msg_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void limpar(java.awt.event.ActionEvent evt) {

        textComprovante.setText("");
    }

    private void excluirOrdem(java.awt.event.ActionEvent evt) {
        Visão<String> visão = (Visão<String>) comboOrdens.getSelectedItem();
        String msg_erro = null;
        if (visão != null) {
            msg_erro = controlador.removerOrdemDeServico(Integer.parseInt(visão.getChave()));
        } else {
            msg_erro = "Ordem de servico nao encontrado";
        }
        if (msg_erro == null) {
            ordens_cadastradas.remove(visão);
            if (ordens_cadastradas.size() >= 1) {
                comboOrdens.setSelectedIndex(0);
            } else {
                comboOrdens.setSelectedIndex(-1);
            }
            JOptionPane.showInternalMessageDialog(this, "Ordem de Serviço removida com sucesso.");

        } else {
            JOptionPane.showMessageDialog(this, msg_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        comboOrdens = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        buttonExcluir = new javax.swing.JButton();
        buttonLimpar = new javax.swing.JButton();
        buttonVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textComprovante = new javax.swing.JTextArea();
        buttonImpressao = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Selecione a ordem  de serviço");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 133, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        comboOrdens.setModel(new DefaultComboBoxModel(ordens_cadastradas)
        );
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 686;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 0, 32);
        getContentPane().add(comboOrdens, gridBagConstraints);

        jLabel3.setText("Visualização do comprovante");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 62, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -79;
        gridBagConstraints.ipady = -33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jInternalFrame1, gridBagConstraints);

        buttonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/close24.png"))); // NOI18N
        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        buttonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/rename24.png"))); // NOI18N
        buttonLimpar.setText("Limpar dados");
        buttonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparActionPerformed(evt);
            }
        });

        buttonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/back24.png"))); // NOI18N
        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(buttonVoltar)
                .addGap(18, 18, 18)
                .addComponent(buttonLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExcluir)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVoltar)
                    .addComponent(buttonExcluir)
                    .addComponent(buttonLimpar))
                .addGap(0, 35, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 119;
        gridBagConstraints.ipady = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 258, 0, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        textComprovante.setColumns(20);
        textComprovante.setRows(5);
        jScrollPane1.setViewportView(textComprovante);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 275;
        gridBagConstraints.ipady = 400;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        buttonImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/copy24.png"))); // NOI18N
        buttonImpressao.setText("Visualizar impressão");
        buttonImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImpressaoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 59, 0, 0);
        getContentPane().add(buttonImpressao, gridBagConstraints);

        setBounds(0, 0, 772, 618);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void buttonImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImpressaoActionPerformed
        inicializaTextAra();    }//GEN-LAST:event_buttonImpressaoActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        excluirOrdem(evt);
    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void buttonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimparActionPerformed
        limpar(evt);
    }//GEN-LAST:event_buttonLimparActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonImpressao;
    private javax.swing.JButton buttonLimpar;
    private javax.swing.JButton buttonVoltar;
    private static javax.swing.JComboBox comboOrdens;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textComprovante;
    // End of variables declaration//GEN-END:variables
}
