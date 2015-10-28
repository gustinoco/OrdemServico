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

        jLabel2 = new javax.swing.JLabel();
        comboOrdens = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        buttonLimpar = new javax.swing.JButton();
        buttonVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textComprovante = new javax.swing.JTextArea();
        buttonImpressao = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jLabel2.setText("Selecione a ordem  de serviço");

        comboOrdens.setModel(new DefaultComboBoxModel(ordens_cadastradas)
        );

        jLabel3.setText("Visualização do comprovante");

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

        buttonLimpar.setText("Limpar dados");
        buttonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparActionPerformed(evt);
            }
        });

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
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(buttonLimpar)
                .addGap(18, 18, 18)
                .addComponent(buttonVoltar)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLimpar)
                    .addComponent(buttonVoltar))
                .addGap(0, 35, Short.MAX_VALUE))
        );

        textComprovante.setColumns(20);
        textComprovante.setRows(5);
        jScrollPane1.setViewportView(textComprovante);

        buttonImpressao.setText("Visualizar impressão");
        buttonImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImpressaoActionPerformed(evt);
            }
        });

        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(buttonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(buttonImpressao))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboOrdens, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 378, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 378, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(comboOrdens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonImpressao)
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonExcluir))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 295, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 294, Short.MAX_VALUE)))
        );

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
