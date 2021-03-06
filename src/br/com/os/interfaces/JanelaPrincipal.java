/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.interfaces;

import br.com.os.controle.ControladorCadastroCliente;
import br.com.os.controle.ControladorFornecedor;
import br.com.os.controle.ControladorOrdemDeServico;
import br.com.os.controle.ControladorProduto;
import br.com.os.controle.ControladorVisualizarOrdem;
import br.com.os.persistência.BD;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;

/**
 *
 * @author Gustavo
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        BD.criaConexão();
        initComponents();

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        deskpPanelPrincipal.setBounds(0, 0, d.width, d.height);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        deskpPanelPrincipal = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCliente = new javax.swing.JMenu();
        menuItemCliente = new javax.swing.JMenuItem();
        menuProduto = new javax.swing.JMenu();
        menuItemCadastrarProduto = new javax.swing.JMenuItem();
        menuFornecedor = new javax.swing.JMenu();
        menuItemCadastrarFornecedor = new javax.swing.JMenuItem();
        menuOS = new javax.swing.JMenu();
        itemMenuCadastrarOS = new javax.swing.JMenuItem();
        itemMenuCadastrarOS1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ordem de serviço 1.0");
        setAlwaysOnTop(true);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationByPlatform(true);

        jPanel1.setLayout(null);

        deskpPanelPrincipal.setBackground(new java.awt.Color(240, 240, 240));
        deskpPanelPrincipal.setAlignmentX(100.0F);
        deskpPanelPrincipal.setAlignmentY(100.0F);
        deskpPanelPrincipal.setAutoscrolls(true);
        deskpPanelPrincipal.setName("AEE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout deskpPanelPrincipalLayout = new javax.swing.GroupLayout(deskpPanelPrincipal);
        deskpPanelPrincipal.setLayout(deskpPanelPrincipalLayout);
        deskpPanelPrincipalLayout.setHorizontalGroup(
            deskpPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deskpPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1006, 1006, 1006))
        );
        deskpPanelPrincipalLayout.setVerticalGroup(
            deskpPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deskpPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 246, Short.MAX_VALUE))
        );
        deskpPanelPrincipal.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.add(deskpPanelPrincipal);
        deskpPanelPrincipal.setBounds(-10, 0, 1111, 246);

        menuCliente.setText("Cliente");

        menuItemCliente.setText("Cadastrar Cliente");
        menuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClienteActionPerformed(evt);
            }
        });
        menuCliente.add(menuItemCliente);

        jMenuBar1.add(menuCliente);

        menuProduto.setText("Produtos");

        menuItemCadastrarProduto.setText("Tabela Produtos/Serviços");
        menuItemCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCadastrarProdutoActionPerformed(evt);
            }
        });
        menuProduto.add(menuItemCadastrarProduto);

        jMenuBar1.add(menuProduto);

        menuFornecedor.setText("Fornecedores");

        menuItemCadastrarFornecedor.setText("Cadastrar");
        menuItemCadastrarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCadastrarFornecedorActionPerformed(evt);
            }
        });
        menuFornecedor.add(menuItemCadastrarFornecedor);

        jMenuBar1.add(menuFornecedor);

        menuOS.setText("Ordem de Servico");

        itemMenuCadastrarOS.setText("Cadastrar");
        itemMenuCadastrarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuCadastrarOSActionPerformed(evt);
            }
        });
        menuOS.add(itemMenuCadastrarOS);

        itemMenuCadastrarOS1.setText("Visualizar ordens");
        itemMenuCadastrarOS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuCadastrarOS1ActionPerformed(evt);
            }
        });
        menuOS.add(itemMenuCadastrarOS1);

        jMenuBar1.add(menuOS);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1035, 634));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static JDesktopPane getDeskpPanelPrincipal() {
        return deskpPanelPrincipal;
    }

    public static void setDeskpPanelPrincipal(JDesktopPane deskpPanelPrincipal) {
        JanelaPrincipal.deskpPanelPrincipal = deskpPanelPrincipal;
    }

    private void menuItemCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCadastrarProdutoActionPerformed
        new ControladorProduto();

    }//GEN-LAST:event_menuItemCadastrarProdutoActionPerformed

    private void menuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClienteActionPerformed
        new ControladorCadastroCliente();
    }//GEN-LAST:event_menuItemClienteActionPerformed

    private void menuItemCadastrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCadastrarFornecedorActionPerformed
        new ControladorFornecedor();
    }//GEN-LAST:event_menuItemCadastrarFornecedorActionPerformed

    private void itemMenuCadastrarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuCadastrarOSActionPerformed
        new ControladorOrdemDeServico();
    }//GEN-LAST:event_itemMenuCadastrarOSActionPerformed

    private void itemMenuCadastrarOS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuCadastrarOS1ActionPerformed
        new ControladorVisualizarOrdem();
    }//GEN-LAST:event_itemMenuCadastrarOS1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JanelaPrincipal().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JDesktopPane deskpPanelPrincipal;
    private javax.swing.JMenuItem itemMenuCadastrarOS;
    private javax.swing.JMenuItem itemMenuCadastrarOS1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuFornecedor;
    private javax.swing.JMenuItem menuItemCadastrarFornecedor;
    private javax.swing.JMenuItem menuItemCadastrarProduto;
    private javax.swing.JMenuItem menuItemCliente;
    private javax.swing.JMenu menuOS;
    private javax.swing.JMenu menuProduto;
    // End of variables declaration//GEN-END:variables
}
