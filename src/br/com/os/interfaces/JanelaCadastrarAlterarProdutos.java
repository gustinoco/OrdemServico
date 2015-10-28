/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.interfaces;

import br.com.os.controle.ControladorFornecedor;
import br.com.os.controle.ControladorProduto;
import br.com.os.entidade.Fornecedor;
import br.com.os.entidade.Produto;
import br.com.os.entidade.ProdutoPeca;
import br.com.os.entidade.ProdutoServico;
import br.com.os.entidade.ProdutoServico.Status;
import br.com.os.entidade.Visão;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */
public class JanelaCadastrarAlterarProdutos extends javax.swing.JInternalFrame {

    ControladorProduto controlador;
    Vector<Visão<String>> fornecedores_cadastrados;
    ControladorFornecedor controladorFornecedor;

    public JanelaCadastrarAlterarProdutos(ControladorProduto controlador) {
        this.controlador = controlador;

        fornecedores_cadastrados = Fornecedor.getVisões();

        JanelaPrincipal.getDeskpPanelPrincipal().add(this).setVisible(true);

        initComponents();
        inicializaDados();

    }

    public JanelaCadastrarAlterarProdutos(ControladorProduto controlador, Produto produto, ProdutoPeca produtoPeca, ProdutoServico produtoServico) {
        this.controlador = controlador;
        fornecedores_cadastrados = Fornecedor.getVisões();

        JanelaPrincipal.getDeskpPanelPrincipal().add(this).setVisible(true);
        initComponents();
        inicializaDados();
        buttonInserir.setEnabled(false);
        buttonSalvar.setEnabled(true);
        textFieldCodigoBarras.setText(String.valueOf(produto.getId()));
        textFieldCodigoID.setText(String.valueOf(produto.getId()));
        comboFornecedor.setSelectedIndex(produto.getIdFornecedor() - 1);
        textFieldDescricao.setText(produto.getDescricao());
        textFieldPreco.setText(String.valueOf(produto.getPreco()));

        if (produtoPeca != null) {
            mostraCamposProdutos();
            radioProdutos.setSelected(true);
            textFieldQuantidade.setText(String.valueOf(produtoPeca.getQuantidade()));
            if (produtoPeca.getQualidade().equals("Original")) {
                radioOriginal.setSelected(true);
            } else if (produtoPeca.getQualidade().equals("Paralela")) {
                radioParalela.setSelected(true);
            } else {
                radioUsada.setSelected(true);
            }
        } else {
            mostraCamposServicos();
            //    public ProdutoServico(int id, Status status2, float tempoReparo){
            radioServicos.setSelected(true);
            textFieldTempoReparo.setText(String.valueOf(produtoServico.getTempoReparo()));
            comboStatus.setSelectedIndex(produtoServico.getStatus());
        }

    }

    public static JTextField getTextFieldCodigoBarras() {
        return textFieldCodigoBarras;
    }

    public void setTextFieldCodigoBarras(JTextField textFieldCodigoBarras) {
        this.textFieldCodigoBarras = textFieldCodigoBarras;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipoCadastro = new javax.swing.ButtonGroup();
        buttonGroupQualidade = new javax.swing.ButtonGroup();
        radioProdutos = new javax.swing.JRadioButton();
        radioServicos = new javax.swing.JRadioButton();
        labelCodigoID = new javax.swing.JLabel();
        labelCodigoBarras = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        textFieldCodigoID = new javax.swing.JTextField();
        textFieldCodigoBarras = new javax.swing.JTextField();
        textFieldDescricao = new javax.swing.JTextField();
        panelButtonsFim = new javax.swing.JPanel();
        buttonInserir = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        buttonLimpar = new javax.swing.JButton();
        labelPreco = new javax.swing.JLabel();
        labelQuantidade = new javax.swing.JLabel();
        labelQualidade = new javax.swing.JLabel();
        textFieldPreco = new javax.swing.JTextField();
        textFieldQuantidade = new javax.swing.JTextField();
        labelDescricao1 = new javax.swing.JLabel();
        comboFornecedor = new javax.swing.JComboBox();
        radioOriginal = new javax.swing.JRadioButton();
        radioParalela = new javax.swing.JRadioButton();
        radioUsada = new javax.swing.JRadioButton();
        labelTempoReparo = new javax.swing.JLabel();
        textFieldTempoReparo = new javax.swing.JTextField();
        labelStatus = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastrar / Alterar Produtos ou Serviços");

        buttonGroupTipoCadastro.add(radioProdutos);
        radioProdutos.setSelected(true);
        radioProdutos.setText("Cadastro de Produtos");
        radioProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioProdutosActionPerformed(evt);
            }
        });

        buttonGroupTipoCadastro.add(radioServicos);
        radioServicos.setText("Cadastro de Serviços");
        radioServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioServicosActionPerformed(evt);
            }
        });

        labelCodigoID.setText("Código");

        labelCodigoBarras.setText("Código de barras");

        labelDescricao.setText("Fornecedor");

        textFieldCodigoID.setEditable(false);
        textFieldCodigoID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textFieldCodigoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCodigoIDActionPerformed(evt);
            }
        });

        textFieldCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCodigoBarrasActionPerformed(evt);
            }
        });

        textFieldDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldDescricaoActionPerformed(evt);
            }
        });

        buttonInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/add1-24.png"))); // NOI18N
        buttonInserir.setText("Inserir");
        buttonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInserirActionPerformed(evt);
            }
        });

        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/success24.png"))); // NOI18N
        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/back24.png"))); // NOI18N
        buttonCancelar.setText("Sair");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/rename24.png"))); // NOI18N
        buttonLimpar.setText("Limpar campos");
        buttonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonsFimLayout = new javax.swing.GroupLayout(panelButtonsFim);
        panelButtonsFim.setLayout(panelButtonsFimLayout);
        panelButtonsFimLayout.setHorizontalGroup(
            panelButtonsFimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsFimLayout.createSequentialGroup()
                .addComponent(buttonInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelButtonsFimLayout.setVerticalGroup(
            panelButtonsFimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsFimLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonsFimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInserir)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonLimpar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        labelPreco.setText("Preço");

        labelQuantidade.setText("Quantidade");

        labelQualidade.setText("Qualidade");

        textFieldPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPrecoActionPerformed(evt);
            }
        });

        textFieldQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldQuantidadeActionPerformed(evt);
            }
        });

        labelDescricao1.setText("Descrição do Produto/Serviço");

        comboFornecedor.setModel(new DefaultComboBoxModel(fornecedores_cadastrados)
        );
        comboFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFornecedorActionPerformed(evt);
            }
        });

        buttonGroupQualidade.add(radioOriginal);
        radioOriginal.setText("Original");
        radioOriginal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOriginalActionPerformed(evt);
            }
        });

        buttonGroupQualidade.add(radioParalela);
        radioParalela.setText("Paralela");

        buttonGroupQualidade.add(radioUsada);
        radioUsada.setText("Usada");

        labelTempoReparo.setText("Tempo de reparo");

        textFieldTempoReparo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTempoReparoActionPerformed(evt);
            }
        });

        labelStatus.setText("Status");

        comboStatus.setModel(new DefaultComboBoxModel(ProdutoServico.status));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/add2-24.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelButtonsFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTempoReparo)
                                    .addComponent(textFieldTempoReparo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(332, 332, 332))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(comboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(radioProdutos)
                                                .addComponent(radioServicos))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(labelCodigoID)
                                                    .addGap(37, 37, 37)
                                                    .addComponent(labelCodigoBarras))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(textFieldCodigoID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(textFieldCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(labelDescricao)
                                        .addComponent(labelDescricao1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(labelPreco)
                                                .addComponent(textFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(78, 78, 78)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(textFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelQuantidade)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(radioOriginal)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(radioParalela)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(radioUsada))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(labelQualidade)
                                            .addGap(247, 247, 247)
                                            .addComponent(labelStatus)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(37, 37, 37)))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioProdutos)
                    .addComponent(labelCodigoID)
                    .addComponent(labelCodigoBarras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldCodigoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(radioServicos))
                .addGap(45, 45, 45)
                .addComponent(labelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(17, 17, 17)
                .addComponent(labelDescricao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPreco)
                            .addComponent(labelQuantidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(labelQualidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelStatus)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioOriginal)
                    .addComponent(radioParalela)
                    .addComponent(radioUsada))
                .addGap(18, 18, 18)
                .addComponent(labelTempoReparo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldTempoReparo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelButtonsFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        textFieldCodigoID.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCodigoBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCodigoBarrasActionPerformed

    private void textFieldDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldDescricaoActionPerformed

    private void textFieldCodigoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCodigoIDActionPerformed

    }//GEN-LAST:event_textFieldCodigoIDActionPerformed

    private void textFieldPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPrecoActionPerformed

    private void textFieldQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldQuantidadeActionPerformed

    private void comboFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFornecedorActionPerformed
    }//GEN-LAST:event_comboFornecedorActionPerformed

    private void textFieldTempoReparoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTempoReparoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTempoReparoActionPerformed

    private void radioOriginalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOriginalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioOriginalActionPerformed

    private void radioProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioProdutosActionPerformed
        mostraCamposProdutos();
    }//GEN-LAST:event_radioProdutosActionPerformed

    private void radioServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioServicosActionPerformed
        mostraCamposServicos();
    }//GEN-LAST:event_radioServicosActionPerformed

    private void buttonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInserirActionPerformed
        inserirProduto(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonInserirActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        salvarProduto(evt);
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimparActionPerformed
        inicializaDados();   // TODO add your handling code here:
    }//GEN-LAST:event_buttonLimparActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ControladorFornecedor();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void inicializaDados() {
        buttonSalvar.setEnabled(false);
        buttonGroupTipoCadastro.clearSelection();
        textFieldCodigoID.setText(String.valueOf(Produto.ultimoSequencial() + 1));
        textFieldCodigoID.setEnabled(false);
        textFieldCodigoBarras.setText("");
        textFieldCodigoBarras.setEnabled(true);
        comboFornecedor.setSelectedIndex(-1);
        comboFornecedor.setEnabled(true);
        textFieldDescricao.setText("");
        textFieldPreco.setText("");
        textFieldQuantidade.setText("");
        textFieldQuantidade.setEnabled(true);
        radioOriginal.setEnabled(true);
        radioParalela.setEnabled(true);
        radioUsada.setEnabled(true);
        textFieldTempoReparo.setText("");
        textFieldTempoReparo.setEditable(true);
        buttonGroupQualidade.clearSelection();
        radioOriginal.setActionCommand("Original");
        radioParalela.setActionCommand("Paralela");
        radioUsada.setActionCommand("Usado");

    }

    private void mostraCamposProdutos() {
        textFieldTempoReparo.setEnabled(false);
        textFieldQuantidade.setEnabled(true);
        textFieldCodigoID.setEnabled(false);
        comboStatus.setEnabled(false);
        radioOriginal.setEnabled(true);
        radioParalela.setEnabled(true);
        radioUsada.setEnabled(true);
        radioOriginal.setActionCommand("Original");
        radioParalela.setActionCommand("Paralela");
        radioUsada.setActionCommand("Usado");
    }

    private void mostraCamposServicos() {
        textFieldQuantidade.setEnabled(false);
        textFieldCodigoID.setEnabled(false);
        textFieldTempoReparo.setEnabled(true);
        comboStatus.setEnabled(true);
        radioOriginal.setEnabled(false);
        radioParalela.setEnabled(false);
        radioUsada.setEnabled(false);

    }

    ///----------------COMECO DO INSERIR -------------
    private ProdutoPeca obterPecaInformada() {

        Integer id = Integer.parseInt(textFieldCodigoID.getText());

        Visão<String> fornecedor2 = (Visão<String>) comboFornecedor.getSelectedItem();
        int fornecedor3 = Integer.parseInt(fornecedor2.getChave());

        String descricao = textFieldDescricao.getText();
        if (descricao.isEmpty()) {
            return null;
        }

        float preco = Float.parseFloat(textFieldPreco.getText().replace(".", "").replace(",", "."));
        if (preco < 0) {
            return null;
        }

        String qualidade = buttonGroupQualidade.getSelection().getActionCommand();
        if (qualidade.isEmpty()) {
            return null;
        }

        int quantidade = Integer.parseInt(textFieldQuantidade.getText());
        if (quantidade == -1) {
            return null;
        }
        return new ProdutoPeca(id, fornecedor3, descricao, qualidade, quantidade, preco);
    }

    private ProdutoServico obterServicoInformado() {
        Integer id = Integer.parseInt(textFieldCodigoID.getText());

        Visão<String> fornecedor2 = (Visão<String>) comboFornecedor.getSelectedItem();
        int fornecedor3 = Integer.parseInt(fornecedor2.getChave());

        String descricao = textFieldDescricao.getText();
        if (descricao.isEmpty()) {
            return null;
        }

        float preco = Float.parseFloat(textFieldPreco.getText().replace(".", "").replace(",", "."));
        if (preco < 0) {
            return null;
        }

        Status status = Status.valueOf(comboStatus.getSelectedItem().toString());
        //fazer tratamento de erro

        float tempoReparo = Float.parseFloat(textFieldTempoReparo.getText());
        if (tempoReparo < 0) {
            return null;
        }

        return new ProdutoServico(id, fornecedor3, descricao, status, tempoReparo, preco);
    }

    private void inserirProduto(java.awt.event.ActionEvent evt) {
        Produto produto = null;
        if (radioServicos.isSelected()) {
            produto = obterServicoInformado();
        } else if (radioProdutos.isSelected()) {
            produto = obterPecaInformada();
        } else {
            //fazer msg erro 
            System.out.println("NENHUM TIPO FOI SELECIONADO");
        }

        String mensagem_erro = null;
        if (produto != null) {
            mensagem_erro = controlador.inserirProduto(produto);
        } else {
            mensagem_erro = "Algum atributo do produto não foi informado";
        }
        if (mensagem_erro == null && produto instanceof ProdutoPeca) {
            JOptionPane.showInternalMessageDialog(this, "Peça cadastrada com sucesso.");
            inicializaDados();

        } else if (mensagem_erro == null && produto instanceof ProdutoServico) {
            JOptionPane.showInternalMessageDialog(this, "Serviço cadastrado com sucesso.");
            inicializaDados();
        } else {
            JOptionPane.showMessageDialog(this, mensagem_erro, "Algum campo está com informacão incorreta",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
    ///----------------FIM DO INSERIR -------------

    ///----------------COMEÇO DO SALVAR -------------
    private void salvarProduto(java.awt.event.ActionEvent evt) {
        buttonSalvar.setEnabled(true);
        Produto produto = null;
        if (radioServicos.isSelected()) {
            produto = obterServicoInformado();
        } else if (radioProdutos.isSelected()) {
            produto = obterPecaInformada();
        } else {
            System.out.println("NENHUM TIPO FOI SELECIONADO");
        }
        String msg_erro = null;
        if (produto != null) {
            msg_erro = controlador.alterarProduto(produto);
        }
        if (msg_erro == null) {
            JOptionPane.showInternalMessageDialog(this, "Produto alterado com sucesso.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, msg_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    ///----------------FIM DO SALVAR -------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.ButtonGroup buttonGroupQualidade;
    private javax.swing.ButtonGroup buttonGroupTipoCadastro;
    private javax.swing.JButton buttonInserir;
    private javax.swing.JButton buttonLimpar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JComboBox comboFornecedor;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelCodigoBarras;
    private javax.swing.JLabel labelCodigoID;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelDescricao1;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelQualidade;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTempoReparo;
    private javax.swing.JPanel panelButtonsFim;
    private javax.swing.JRadioButton radioOriginal;
    private javax.swing.JRadioButton radioParalela;
    private javax.swing.JRadioButton radioProdutos;
    private javax.swing.JRadioButton radioServicos;
    private javax.swing.JRadioButton radioUsada;
    private static javax.swing.JTextField textFieldCodigoBarras;
    private javax.swing.JTextField textFieldCodigoID;
    private javax.swing.JTextField textFieldDescricao;
    private javax.swing.JTextField textFieldPreco;
    private javax.swing.JTextField textFieldQuantidade;
    private javax.swing.JTextField textFieldTempoReparo;
    // End of variables declaration//GEN-END:variables
}
