/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.interfaces;

import br.com.os.controle.ControladorOrdemDeServico;
import br.com.os.controle.ControladorProduto;
import br.com.os.entidade.Cliente;
import br.com.os.entidade.OrdemDeServico;
import br.com.os.entidade.Produto;
import br.com.os.entidade.ProdutoPeca;
import br.com.os.entidade.ProdutoServico;
import br.com.os.entidade.Visão;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class JanelaCadastrarOrdemDeServico extends javax.swing.JInternalFrame {

    Vector<Visão<String>> clientes_cadastrados;
    ControladorOrdemDeServico controlador;
    DefaultTableModel tabela;
    ControladorProduto controlador2;

    public JanelaCadastrarOrdemDeServico(ControladorOrdemDeServico controlador) {
        this.controlador2 = controlador2;
        this.controlador = controlador;
        clientes_cadastrados = Cliente.getVisões();
        JanelaPrincipal.getDeskpPanelPrincipal().add(this).setVisible(true);
        initComponents();

        tabela = (DefaultTableModel) tableProdutos.getModel();
        inicializaTabelaProdutos();
        inicializaTextAra(null);

    }

    private void inicializaTabelaProdutos() {

        tabela.addColumn("Código");
        tabela.addColumn("Descrição");
        tabela.addColumn("Quantide");
        tabela.addColumn("Preço");
        tabela.setRowCount(0);
        Vector<Visão<String>> visoes = OrdemDeServico.getVisões2();
        for (Visão<String> elemento : visoes) {
            String[] string = elemento.getInfo().split(";");
            if (string[2].equals("0")) {
                string[2] = "----";
            }
            tabela.addRow(string);
        }

    }

    private void inicializaTextAra(OrdemDeServico ordem) {
        Locale locale = new Locale("pt", "BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("dd'/'MM'/'yyyy'                                  "
                + "                         'HH':'mm''", locale);
        String hora = formatador.format(calendar.getTime());
        String cabecalho = "-------------------Ordem de serviço 1.0 -------------------"
                + "\n"
                + hora
                + "\n"
                + "--------------------------------------------------------------------"
                + "\n"
                + "Descrição                          Qtd                        Valor";

//        textAreaRelacao.setText(cabecalho);
        //    String descricao = "" + ordem.getVisão();
        //      
        //  textAreaRelacao.setText(descricao);
    }

    private Produto adicionarProduto() {
        Produto produto = null;
        String msg_erro = null;
        ProdutoPeca produtoPeca = null;
        ProdutoServico produtoServico = null;
        int selecao = tableProdutos.getSelectedRow();

        String ad = tableProdutos.getValueAt(selecao, 0).toString();

        if (ad != null) {

            produto = Produto.buscarProduto(Integer.parseInt(ad));
            produtoPeca = (ProdutoPeca) Produto.buscarProdutoPeca(Integer.parseInt(ad));
            if (produtoPeca == null) {
                produtoServico = (ProdutoServico) Produto.buscarProdutoServico(Integer.parseInt(ad));
                return produtoServico;
            } else {
                return produtoPeca;
            }
        }
        if (produto == null) {
            msg_erro = "produto inexistente";
        }

        if (msg_erro == null) {
            return produtoPeca;

        }

        return null;
    }
    /*

     }
     if (msg_erro == null) {
     new JanelaCadastrarAlterarProdutos(controlador, produto, produtoPeca, produtoServico);
     }
     */

    private void resultado() {
        Produto produto = null;
        int selecao = tableProdutos.getSelectedRow();
        float preco = 0;
        int quantidade = 0;
        String ad = tableProdutos.getValueAt(selecao, 0).toString();

        if (ad != null) {

            produto = Produto.buscarProduto(Integer.parseInt(ad));
            ProdutoPeca produtoPeca = (ProdutoPeca) Produto.buscarProdutoPeca(Integer.parseInt(ad));
            preco = produto.getPreco();

            if (produtoPeca != null) {

                if (Integer.parseInt(txtQuantidade.getText()) > produtoPeca.getQuantidade()) {
                    String msg_erro = "Quantidade informada é maior do que no estoque";
                    JOptionPane.showMessageDialog(this, msg_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    quantidade = Integer.parseInt(txtQuantidade.getText());
                }
            }
            quantidade = Integer.parseInt(txtQuantidade.getText());

            float desconto = Float.parseFloat(txtDesconto.getText());

            float resultado = (preco * quantidade);
            txtValorFinal.setText(String.valueOf(resultado - desconto));
        }
    }

    private void salvarOrdem(java.awt.event.ActionEvent evt) {
        OrdemDeServico ordem = obtemOrdem();

        String msg_erro = null;
        if (ordem != null) {
            msg_erro = controlador.inserirOrdem(ordem);
        }
        if (msg_erro != null) {
            Produto q = Produto.buscarProdutoPeca(ordem.getProduto());
            if (q instanceof ProdutoPeca) {
                ((ProdutoPeca) q).setQuantidade(((ProdutoPeca) q).getQuantidade() - ordem.getQuantidade());
                controlador.atualizarProduto((ProdutoPeca) q);
            }

            JOptionPane.showInternalMessageDialog(this, "Salvo com sucesso");

        } else {
            JOptionPane.showMessageDialog(this, msg_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private OrdemDeServico obtemOrdem() {
        int valida = 0;
        Integer id = null;
        Produto produto = adicionarProduto();
        if (produto instanceof ProdutoPeca) {
            valida = ((ProdutoPeca) produto).getQuantidade();
            Integer quantidade = Integer.parseInt(txtQuantidade.getText());
            if (quantidade > valida) {
                return null;
            }

        }

        Integer quantidade = Integer.parseInt(txtQuantidade.getText());

        Visão<String> cliente = (Visão<String>) comboClientes.getSelectedItem();
        int cliente2 = Integer.parseInt(cliente.getChave());
        Float desconto = Float.parseFloat(txtDesconto.getText());
        if (desconto < 0) {
            return null;
        }
        java.util.Date dt = new Date();
        java.sql.Date date = new java.sql.Date(dt.getTime());
//public OrdemDeServico(int id, int cliente, float desconto, int quantidade, Date data, int produto) {
        return new OrdemDeServico(cliente2, desconto, quantidade, date, produto.getId());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        comboClientes = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProdutos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValorFinal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jLabel2.setText("Selecione o cliente ");

        comboClientes.setModel(new DefaultComboBoxModel(clientes_cadastrados)
        );

        jLabel3.setText("Selecione os produtos  ou serviços a inserir");

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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/add1-24.png"))); // NOI18N
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/rename24.png"))); // NOI18N
        jButton3.setText("Limpar dados");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/back24.png"))); // NOI18N
        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProdutos);

        jLabel4.setText("Quantidade");

        jLabel5.setText("Desconto?");

        txtDesconto.setText("0");

        jLabel6.setText("Valor final");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/os/images/down24.png"))); // NOI18N
        jButton1.setText("Resultado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(txtDesconto)
                            .addComponent(txtValorFinal, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)))
        );

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
                        .addGap(10, 10, 10)
                        .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(191, 191, 191))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 289, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 288, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 335, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 335, Short.MAX_VALUE)))
        );

        setBounds(0, 0, 437, 699);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        salvarOrdem(evt);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutosMouseClicked
        //
    }//GEN-LAST:event_tableProdutosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resultado();    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox comboClientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tableProdutos;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorFinal;
    // End of variables declaration//GEN-END:variables
}
