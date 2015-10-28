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

public class Fornecedor {

    private String nome;
    private String cnpj;
    private Integer id;

    public Fornecedor(Integer id, String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.id = id;

    }

    public Fornecedor() {
    }

    public Visão<Integer> getVisão() {
        return new Visão<Integer>(id, nome + " - Cnpj:" + cnpj);
    }//" - Cnpj: " + lista.getString("Cnpj")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static String inserirFornecedor(Fornecedor fornecedor) {
        String sql = "INSERT INTO Fornecedor (nome,cnpj)" + " VALUES (?,?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);

            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getCnpj());

            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exc) {
            exc.printStackTrace();
            return "Erro na Inserção do Fornecedor no BD";
        }
    }

    public static Fornecedor buscarFornecedor(int id) {
        String sql = "SELECT * FROM Fornecedor" + " WHERE id=?";
        ResultSet lista = null;
        Fornecedor fornecedor = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            lista = comando.executeQuery();
            while (lista.next()) {
                fornecedor = new Fornecedor(id,
                        lista.getString("Nome"),
                        lista.getString("Cnpj"));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
            fornecedor = null;

        }
        return fornecedor;
    }

    public static String alterarFornecedor(Fornecedor fornecedor) {
        String sql = "UPDATE Fornecedor SET Nome = ?, Cnpj = ?" + " WHERE id = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getCnpj());
            comando.setInt(3, fornecedor.getId());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exc) {
            exc.printStackTrace();
            return "Erro na alteração no BD";
        }
    }

    public static String removerFornecedor(int id) {
        String sql = "DELETE FROM Fornecedor WHERE id = ?";

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exc) {
            exc.printStackTrace();
            return "Erro na remoção, pois já existem produtos com este fornecedor.";
        }

    }

    public static Fornecedor mostraFornecedoresComProdutos(int id) {
          String sql = "SELECT * FROM Produto" + " WHERE idFornecedor=?";
        ResultSet lista = null;
        Fornecedor fornecedor = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            lista = comando.executeQuery();
            while (lista.next()) {
                fornecedor = new Fornecedor(id,
                        lista.getString("Nome"),
                        null);
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
            fornecedor = null;

        }
        return fornecedor;
    }

    public static int ultimoSequencial() {
        int max = -1;
        String sql = "Select max(id) from Fornecedor";

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

    public static Vector<Visão<String>> getVisões() {
        String sql = "SELECT Id, Nome, cnpj FROM Fornecedor";
        ResultSet lista = null;
        Vector<Visão<String>> visoes = new Vector<Visão<String>>();
        String id;
        try {
            PreparedStatement comando = br.com.os.persistência.BD.conexão.prepareStatement(sql);
            lista = comando.executeQuery();
            while (lista.next()) {
                id = lista.getString("id");
                visoes.addElement(new Visão<String>(id, lista.getString("Nome") + " - Cnpj: " + lista.getString("Cnpj")));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return visoes;
    }

}
