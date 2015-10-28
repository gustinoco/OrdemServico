/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.interfaces;

import br.com.os.controle.ControladorProduto;
import br.com.os.entidade.Produto;
import br.com.os.entidade.ProdutoPeca;
import br.com.os.entidade.ProdutoServico;
import br.com.os.entidade.Visão;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JanelaProdutosPeca extends javax.swing.JInternalFrame {

    ControladorProduto controlador;
    Vector<Visão<String>> produtos_cadastrados;
    DefaultListModel lista;
    DefaultTableModel tabela;

    public JanelaProdutosPeca(ControladorProduto controlador) {
        this.controlador = controlador;

        produtos_cadastrados = Produto.getVisões();

        JanelaPrincipal.getDeskpPanelPrincipal().add(this).setVisible(true);

        initComponents();
        try {
            this.setMaximum(true);
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }

        desabilitaRadio();

        tabela = (DefaultTableModel) tableProdutos.getModel();

        inicializaTabela(null);
        ;
    }

    private void desabilitaRadio() {
        radioOriginal.setEnabled(false);
        radioUsada.setEnabled(false);
        radioParalela.setEnabled(false);
    }

    public void inicializaTabela(Vector<Visão<String>> produto) {

        if (produto != null) {
            tabela.setRowCount(0);
            for (Visão<String> elemento : produto) {

                String[] string = elemento.getInfo().split(";");

                if (string[2].equals("0")) {
                    string[2] = "----";
                }
                if (string[3].equals("0.0")) {
                    string[3] = "----";
                }
                if (string[4].equals("null")) {
                    string[4] = "----";
                }
                tabela.addRow(string);

            }
        } else {
            tabela.addColumn("Código");
            tabela.addColumn("Descrição");
            tabela.addColumn("Quantide");
            tabela.addColumn("Tempo");
            tabela.addColumn("Qualidade");
            tabela.addColumn("Fornecedor");
            tabela.addColumn("Preço");
            tableProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(70);
            tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(500);
            tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(70);
            tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(70);
            tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(150);
            tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(300);
            tableProdutos.getColumnModel().getColumn(6).setPreferredWidth(150);

            Vector<Visão<String>> visoes = Produto.getVisões();
            for (Visão<String> elemento : visoes) {

                String[] string = elemento.getInfo().split(";");
                if (string[2].equals("0")) {
                    string[2] = "----";
                }
                if (string[3].equals("0.0")) {
                    string[3] = "----";
                }
                if (string[4].equals("null")) {
                    string[4] = "----";
                }
                tabela.addRow(string);

            }

        }
    }

    public JanelaProdutosPeca() {
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroupQualidade = new javax.swing.ButtonGroup();
        panelPesquisas = new javax.swing.JPanel();
        labelOrdenar = new javax.swing.JLabel();
        labelFiltroGeral = new javax.swing.JLabel();
        comboOrdenar = new javax.swing.JComboBox();
        comboFiltroGeral = new javax.swing.JComboBox();
        labelPesquisarTodos = new javax.swing.JLabel();
        textFieldProdutoServico = new javax.swing.JTextField();
        buttonPesquisar = new javax.swing.JButton();
        labelFiltroRadio = new javax.swing.JLabel();
        radioOriginal = new javax.swing.JRadioButton();
        radioUsada = new javax.swing.JRadioButton();
        radioParalela = new javax.swing.JRadioButton();
        panelBotoes = new javax.swing.JPanel();
        buttonIncluir = new javax.swing.JButton();
        buttonAlterar = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        scrollTabela = new javax.swing.JScrollPane();
        tableProdutos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Visualizar produtos e serviços");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        labelOrdenar.setText("Ordenar a pesquisa");

        labelFiltroGeral.setText("Filtro Geral");

        comboOrdenar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alfabética", "Código", "Preço" }));
        comboOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrdenarActionPerformed(evt);
            }
        });
        comboOrdenar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboOrdenarKeyPressed(evt);
            }
        });

        comboFiltroGeral.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "Peças", "Serviços" }));
        comboFiltroGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroGeralActionPerformed(evt);
            }
        });

        labelPesquisarTodos.setText("Pesquisar Produto/Serviço");

        textFieldProdutoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldProdutoServicoActionPerformed(evt);
            }
        });
        textFieldProdutoServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textFieldProdutoServicoKeyPressed(evt);
            }
        });

        buttonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/search16.png"))); // NOI18N
        buttonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisarActionPerformed(evt);
            }
        });

        labelFiltroRadio.setText("Deseja procurar pela qualidade?");

        buttonGroupQualidade.add(radioOriginal);
        radioOriginal.setText("Original");
        radioOriginal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOriginalActionPerformed(evt);
            }
        });

        buttonGroupQualidade.add(radioUsada);
        radioUsada.setText("Usada");
        radioUsada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioUsadaActionPerformed(evt);
            }
        });

        buttonGroupQualidade.add(radioParalela);
        radioParalela.setText("Paralela");
        radioParalela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioParalelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPesquisasLayout = new javax.swing.GroupLayout(panelPesquisas);
        panelPesquisas.setLayout(panelPesquisasLayout);
        panelPesquisasLayout.setHorizontalGroup(
            panelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPesquisasLayout.createSequentialGroup()
                .addGroup(panelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPesquisasLayout.createSequentialGroup()
                        .addComponent(labelPesquisarTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldProdutoServico))
                    .addGroup(panelPesquisasLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelOrdenar))
                        .addGap(50, 50, 50)
                        .addGroup(panelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboFiltroGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFiltroGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPesquisasLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(labelFiltroRadio))
                            .addGroup(panelPesquisasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioOriginal)
                                .addGap(1, 1, 1)
                                .addComponent(radioParalela)
                                .addGap(18, 18, 18)
                                .addComponent(radioUsada)))
                        .addGap(0, 78, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        panelPesquisasLayout.setVerticalGroup(
            panelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPesquisasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPesquisasLayout.createSequentialGroup()
                        .addGroup(panelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelOrdenar)
                            .addComponent(labelFiltroGeral)
                            .addComponent(labelFiltroRadio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboFiltroGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioOriginal)
                            .addComponent(radioUsada)
                            .addComponent(radioParalela))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(panelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPesquisarTodos)
                            .addComponent(textFieldProdutoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPesquisasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonPesquisar)))
                .addGap(16, 16, 16))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 78;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        getContentPane().add(panelPesquisas, gridBagConstraints);

        buttonIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/add2-24.png"))); // NOI18N
        buttonIncluir.setText("Novo");
        buttonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIncluirActionPerformed(evt);
            }
        });

        buttonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/edit24.png"))); // NOI18N
        buttonAlterar.setText("Alterar");
        buttonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarActionPerformed(evt);
            }
        });

        buttonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/close24.png"))); // NOI18N
        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        buttonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/back24.png"))); // NOI18N
        buttonExit.setText("Sair");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(buttonIncluir)
                .addGap(18, 18, 18)
                .addComponent(buttonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 141, 0, 10);
        getContentPane().add(panelBotoes, gridBagConstraints);

        tableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableProdutos.setEditingColumn(0);
        tableProdutos.setEditingRow(0);
        tableProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableProdutos.getTableHeader().setReorderingAllowed(false);
        scrollTabela.setViewportView(tableProdutos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1010;
        gridBagConstraints.ipady = 375;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 11, 10);
        getContentPane().add(scrollTabela, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboFiltroGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroGeralActionPerformed
        consultaTipo();
        buttonGroupQualidade.clearSelection();
        if (comboFiltroGeral.getSelectedItem().toString().equals("Peças")) {
            mostraFiltroPeça();
        } else {
            desabilitaRadio();

        }
    }//GEN-LAST:event_comboFiltroGeralActionPerformed

    private void textFieldProdutoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldProdutoServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldProdutoServicoActionPerformed

    private void comboOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrdenarActionPerformed
        consultaTipo();
    }//GEN-LAST:event_comboOrdenarActionPerformed


    private void buttonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIncluirActionPerformed
        new JanelaCadastrarAlterarProdutos(controlador);


    }//GEN-LAST:event_buttonIncluirActionPerformed

    private void buttonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarActionPerformed

        alterarProduto(evt);

    }//GEN-LAST:event_buttonAlterarActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        removerProduto(evt);

    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void comboOrdenarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboOrdenarKeyPressed
        consultarTecla();
    }//GEN-LAST:event_comboOrdenarKeyPressed

    private void buttonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarActionPerformed
        consultarTecla();
    }//GEN-LAST:event_buttonPesquisarActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void radioOriginalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOriginalActionPerformed
        consultaTipo();
    }//GEN-LAST:event_radioOriginalActionPerformed

    private void radioParalelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioParalelaActionPerformed
  consultaTipo();    }//GEN-LAST:event_radioParalelaActionPerformed

    private void radioUsadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioUsadaActionPerformed
  consultaTipo();    }//GEN-LAST:event_radioUsadaActionPerformed

    private void textFieldProdutoServicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldProdutoServicoKeyPressed
  if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarTecla();
        }
    }//GEN-LAST:event_textFieldProdutoServicoKeyPressed

    private void consultarTecla() {
        String stringTxtField = textFieldProdutoServico.getText().toUpperCase();

        Vector<Visão<String>> visoes = Produto.buscarPorTecla(stringTxtField);
        inicializaTabela(visoes);

    }

    public void mostraFiltroPeça() {
        radioUsada.setEnabled(true);
        radioOriginal.setEnabled(true);
        radioParalela.setEnabled(true);
        radioUsada.setActionCommand("Usado");
        radioOriginal.setActionCommand("Original");
        radioParalela.setActionCommand("Paralela");

    }

    public void consultaTipo() {
        String tipo = null;
        if (buttonGroupQualidade.isSelected(radioOriginal.getModel()) || buttonGroupQualidade.isSelected(radioParalela.getModel()) || buttonGroupQualidade.isSelected(radioUsada.getModel())) {
            tipo = buttonGroupQualidade.getSelection().getActionCommand();

        }

        String stringComboOrdenar = comboOrdenar.getSelectedItem().toString();
        String stringComboFiltro = comboFiltroGeral.getSelectedItem().toString();
        Vector<Visão<String>> visoes2 = Produto.buscarTipo(stringComboFiltro, stringComboOrdenar, tipo);
        inicializaTabela(visoes2);
    }

    private void alterarProduto(java.awt.event.ActionEvent evt) {
        int selecao = tableProdutos.getSelectedRow();

        String ad = tableProdutos.getValueAt(selecao, 0).toString();

        Produto produto = null;
        ProdutoPeca produtoPeca = null;
        ProdutoServico produtoServico = null;

        String msg_erro = null;
        if (ad != null) {

            produto = Produto.buscarProduto(Integer.parseInt(ad));
            produtoPeca = (ProdutoPeca) Produto.buscarProdutoPeca(Integer.parseInt(ad));
            if (produtoPeca == null) {
                produtoServico = (ProdutoServico) Produto.buscarProdutoServico(Integer.parseInt(ad));
            }
            if (produto == null) {
                msg_erro = "produto inexistente";
            }

        }
        if (msg_erro == null) {
            new JanelaCadastrarAlterarProdutos(controlador, produto, produtoPeca, produtoServico);
        }

    }

    private void removerProduto(java.awt.event.ActionEvent evt) {

        int selecao = tableProdutos.getSelectedRow();

        String ad = tableProdutos.getValueAt(selecao, 0).toString();

        String msg_erro = null;
        if (ad != null) {
            msg_erro = controlador.removerProduto(Integer.parseInt(ad));
        } else {
            msg_erro = "Produto nao encontrado";
        }
        if (msg_erro == null) {
            JOptionPane.showInternalMessageDialog(this, "Item removido com sucesso.");

            ((DefaultTableModel) tableProdutos.getModel()).removeRow(selecao);

        } else {
            JOptionPane.showMessageDialog(this, msg_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAlterar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonExit;
    private javax.swing.ButtonGroup buttonGroupQualidade;
    private javax.swing.JButton buttonIncluir;
    private javax.swing.JButton buttonPesquisar;
    private javax.swing.JComboBox comboFiltroGeral;
    private javax.swing.JComboBox comboOrdenar;
    private javax.swing.JLabel labelFiltroGeral;
    private javax.swing.JLabel labelFiltroRadio;
    private javax.swing.JLabel labelOrdenar;
    private javax.swing.JLabel labelPesquisarTodos;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelPesquisas;
    private javax.swing.JRadioButton radioOriginal;
    private javax.swing.JRadioButton radioParalela;
    private javax.swing.JRadioButton radioUsada;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tableProdutos;
    private javax.swing.JTextField textFieldProdutoServico;
    // End of variables declaration//GEN-END:variables
}

