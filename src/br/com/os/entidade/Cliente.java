/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.entidade;

import br.com.os.persistência.BD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Gustavo
 */
public class Cliente {

    private String nome, endereco, telefone, cpf;
    private Integer id;

    public Cliente(Integer id, String cpf, String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.id = id;
    }



    public Visão<Integer> getVisão() {
        return new Visão<Integer>(id, id + " -  " + nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static String inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO Clientes (cpf,nome,endereco,telefone)" + " VALUES (?,?,?,?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);

            comando.setString(1, cliente.getCpf());
            comando.setString(2, cliente.getNome());
            comando.setString(3, cliente.getEndereco());
            comando.setString(4, cliente.getTelefone());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exc) {
            exc.printStackTrace();
            return "Erro na Inserção do Cliente no BD";
        }
    }

    public static Cliente buscarCliente(Integer id) {
        String sql = "SELECT * FROM Clientes" + " WHERE id=?";
        ResultSet lista = null;
        Cliente cliente = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            lista = comando.executeQuery();
            while (lista.next()) {
                cliente = new Cliente(id,
                        lista.getString("Cpf"),
                        lista.getString("Nome"),
                        lista.getString("Endereco"),
                        lista.getString("Telefone"));
            }
            lista.close();
            comando.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
            cliente = null;
        }
        return cliente;
    }

    public static String alterarCliente(Cliente cliente) {
        String sql = "UPDATE Clientes SET Nome = ?, Endereco = ?, Telefone = ? " + " WHERE id = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEndereco());
            comando.setString(3, cliente.getTelefone());
            comando.setInt(4, cliente.getId());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exc) {
            exc.printStackTrace();
            return "Erro na alteração no BD";
        }
    }

    public static Vector<Visão<String>> getVisões() {
        String sql = "SELECT ID, NOME FROM Clientes";
        ResultSet lista = null;
        Vector<Visão<String>> visoes = new Vector<Visão<String>>();
        String id;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista = comando.executeQuery();
            while (lista.next()) {
                id = lista.getString("id");
                visoes.addElement(new Visão<String>(id, id + " - "
+                        lista.getString("Nome")));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return visoes;
    }

    public static String removerCliente(int id) {
        String sql = "DELETE FROM Clientes WHERE id = ?";

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exc) {
            exc.printStackTrace();
            return "Erro na remoção";
        }

    }

    public static int ultimoSequencial() {
        int max = -1;
        String sql = "Select max(id) from Clientes";
        ResultSet resultado = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            resultado = comando.executeQuery(sql);
            resultado.next();
            max = resultado.getInt(1);
            comando.close();
        } catch (SQLException e) {
            System.out.println("Nao foi possivel ver o ultimo sequencial.");
        }
        return max;
    }

}
