/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.interfaces;

import br.com.os.controle.ControladorCadastroCliente;
import br.com.os.entidade.Cliente;
import br.com.os.entidade.Visão;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class JanelaCadastrarAlterarCliente extends javax.swing.JInternalFrame {

    Vector<Visão<String>> clientes_cadastrados;

    ControladorCadastroCliente controlador;

    public JanelaCadastrarAlterarCliente(ControladorCadastroCliente controlador) {
        this.controlador = controlador;
        clientes_cadastrados = Cliente.getVisões();
        JanelaPrincipal.getDeskpPanelPrincipal().add(this).setVisible(true);
        initComponents();
        inicializaDados();

    }

    private void inicializaDados() {
        comboClientes.setSelectedItem(-1);
        txtId.setText(String.valueOf(Cliente.ultimoSequencial() + 1));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        labelCpf = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelId = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelTelefone = new javax.swing.JLabel();
        labelEndereco = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        buttonInserir = new javax.swing.JButton();
        buttonAlterar = new javax.swing.JButton();
        buttonRemover = new javax.swing.JButton();
        buttonLimpar = new javax.swing.JButton();
        buttonConsultar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        comboClientes = new javax.swing.JComboBox();

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new java.awt.GridBagLayout());

        jRadioButton1.setText("jRadioButton1");

        jButton1.setText("jButton1");

        setClosable(true);
        setForeground(java.awt.Color.black);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastrar cliente");
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        labelCpf.setText("Cpf:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        getContentPane().add(labelCpf, gridBagConstraints);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel2, gridBagConstraints);

        labelId.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        getContentPane().add(labelId, gridBagConstraints);

        labelNome.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        getContentPane().add(labelNome, gridBagConstraints);

        labelTelefone.setText("Telefone:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        getContentPane().add(labelTelefone, gridBagConstraints);

        labelEndereco.setText("Endereço:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        getContentPane().add(labelEndereco, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.4;
        getContentPane().add(txtNome, gridBagConstraints);

        txtCpf.setColumns(11);
        txtCpf.setToolTipText("Cpf com 11 dígitos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.4;
        getContentPane().add(txtCpf, gridBagConstraints);

        buttonInserir.setText("Inserir");
        buttonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInserirActionPerformed(evt);
            }
        });

        buttonAlterar.setText("Alterar");
        buttonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarActionPerformed(evt);
            }
        });

        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });

        buttonLimpar.setText("Limpar");
        buttonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparActionPerformed(evt);
            }
        });

        buttonConsultar.setText("Consultar");
        buttonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(buttonInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLimpar)
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInserir)
                    .addComponent(buttonAlterar)
                    .addComponent(buttonRemover)
                    .addComponent(buttonLimpar)
                    .addComponent(buttonConsultar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 9;
        getContentPane().add(jPanel1, gridBagConstraints);

        txtId.setEditable(false);
        txtId.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.4;
        getContentPane().add(txtId, gridBagConstraints);

        jLabel1.setText("Lista dos clientes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        getContentPane().add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.4;
        getContentPane().add(txtTelefone, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.4;
        getContentPane().add(txtEndereco, gridBagConstraints);

        comboClientes.setModel(new DefaultComboBoxModel (clientes_cadastrados));
        comboClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 228;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(comboClientes, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInserirActionPerformed
        Cliente cliente = obtemCliente();
        String msg_erro = null;
        if (cliente != null) {
            msg_erro = controlador.inserirCliente(cliente);
        } else {
            msg_erro = "Algum atributo nao informado";
        }
        if (msg_erro == null) {
            Visão<Integer> visao = cliente.getVisão();
            comboClientes.addItem(visao);
            comboClientes.setSelectedItem(visao);
                                        JOptionPane.showInternalMessageDialog(this, "Cliente inserido com sucesso.");

        } else {
            JOptionPane.showMessageDialog(this, msg_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonInserirActionPerformed

    private void buttonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarActionPerformed
        Cliente cliente = obtemCliente();
        String msg_erro = null;
        if (cliente != null) {
            msg_erro = controlador.alterarCliente(cliente);
        } else {
            msg_erro = " Algum atributo nao informado";
        }
        if (msg_erro == null) {
            Visão<String> visão = getVisõesClientesCadastrados(cliente.getId());
            if (visão != null) {
                visão.setInfo(cliente.getVisão().getInfo());
                comboClientes.updateUI();
                comboClientes.setSelectedItem(visão);
                                            JOptionPane.showInternalMessageDialog(this, "Cliente alterado com sucesso.");

            }
        } else {
            JOptionPane.showMessageDialog(this, msg_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonAlterarActionPerformed

    private void buttonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoverActionPerformed
        Visão<String> visão = (Visão<String>) comboClientes.getSelectedItem();
        String msg_erro = null;
        if (visão != null) {
            msg_erro = controlador.removerCliente(Integer.parseInt(visão.getChave()));
        } else {
            msg_erro = "Cliente nao encontrado";
        }
        if (msg_erro == null) {
            clientes_cadastrados.remove(visão);
            if (clientes_cadastrados.size() >= 1) {
                //comboClientes.setSelectedIndex(0);
            } else {
                //comboClientes.setSelectedIndex(-1);
            }
                                        JOptionPane.showInternalMessageDialog(this, "Cliente removido com sucesso.");


        } else {
            JOptionPane.showMessageDialog(this, msg_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonRemoverActionPerformed

    private void buttonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimparActionPerformed
        txtCpf.setText("");
        txtEndereco.setText("");
        int a = Cliente.ultimoSequencial() + 1;
        txtId.setText(String.valueOf(a));
        txtNome.setText("");
        txtTelefone.setText("");
        comboClientes.setSelectedItem(-1);

    }//GEN-LAST:event_buttonLimparActionPerformed

    private void comboClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesActionPerformed
        buttonConsultarActionPerformed(evt);
    }//GEN-LAST:event_comboClientesActionPerformed

    private void buttonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsultarActionPerformed
        Visão<String> visão = (Visão<String>) comboClientes.getSelectedItem();
        Cliente cliente = null;
        String msg_erro = null;
        if (visão != null) {
            cliente = Cliente.buscarCliente(Integer.parseInt(visão.getChave()));
            if (cliente == null) {
                msg_erro = "Cliente nao encontrado";
            } 
        }
        if (msg_erro == null) {
            txtId.setText(String.valueOf(cliente.getId()));
            txtCpf.setText(cliente.getCpf());
            txtNome.setText(cliente.getNome());
            txtEndereco.setText(cliente.getEndereco());
            txtTelefone.setText(cliente.getTelefone());
        } else {
            JOptionPane.showMessageDialog(this, msg_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonConsultarActionPerformed

    /**
     * @param args the command line arguments
     */
    private Visão<String> getVisõesClientesCadastrados(int chave) {
        for (Visão<String> visão : clientes_cadastrados) {
            if (visão.getChave().equals(chave)) {
                return visão;
            }
        }
        return null;
    }

    private Cliente obtemCliente() {

        Integer id = Integer.parseInt(txtId.getText());

        String cpf = txtCpf.getText();
        if (cpf.isEmpty()) {
            return null;
        }

        String nome = txtNome.getText();
        if (nome.isEmpty()) {
            return null;
        }

        String endereco = txtEndereco.getText();
        if (endereco.isEmpty()) {
            return null;
        }

        String telefone = txtTelefone.getText();
        if (telefone.isEmpty()) {
            return null;
        }

        return new Cliente(id, cpf, nome, endereco, telefone);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAlterar;
    private javax.swing.JButton buttonConsultar;
    private javax.swing.JButton buttonInserir;
    private javax.swing.JButton buttonLimpar;
    private javax.swing.JButton buttonRemover;
    private javax.swing.JComboBox comboClientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
