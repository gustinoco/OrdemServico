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
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Gustavo
 */
public class OrdemDeServico {

    int id;
    int cliente;
    int produto;
    int quantidade;
    Date data;
    float desconto;

    public Visão<Integer> getVisão() {

        return new Visão<Integer>(id, cliente + ":  " + " Quantidade: " + quantidade + " Data: " + data);
    }

    public OrdemDeServico(int id, int cliente, float desconto, int quantidade, Date data, int produto) {
        this.desconto = desconto;
        this.id = id;
        this.cliente = cliente;
        this.quantidade = quantidade;
        this.data = data;
        this.produto = produto;

    }

    
    public OrdemDeServico(int id, int cliente, int quantidade, Date data, int produto) {
        this.desconto = desconto;
        this.id = id;
        this.cliente = cliente;
        this.quantidade = quantidade;
        this.data = data;
        this.produto = produto;

    }
    
    public OrdemDeServico(int cliente, float desconto, int quantidade, Date data, int produto) {
        this.desconto = desconto;

        this.cliente = cliente;
        this.quantidade = quantidade;
        this.data = data;
        this.produto = produto;

    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public OrdemDeServico(int id, float desconto, int quantidade, Date data) {

        this.id = id;
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.data = data;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public static String inserirOrdem(OrdemDeServico ordem) {
        String sql = "INSERT INTO OrdemDeServico (Cliente_id,Quantidade,Data,Produto_id)" + " VALUES (?,?,?,?)";

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            comando.setInt(1, ordem.getCliente());
            comando.setInt(2, ordem.getQuantidade());
            comando.setDate(3, (java.sql.Date) ordem.getData());
            comando.setInt(4, ordem.getProduto());
            comando.executeUpdate();
            ResultSet rs = comando.getGeneratedKeys();
            int ultimoId = 0;
            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }

            comando.close();
            return String.valueOf(ultimoId);

        } catch (SQLException exc) {
            exc.printStackTrace();
            return "Erro na Inserção do Cliente no BD";
        }

    }

    public static OrdemDeServico buscarOrdem(Integer id) {
        String sql = "SELECT * FROM Ordemdeservico" + " WHERE id=?";
        ResultSet lista = null;
        OrdemDeServico ordem = null;
        try {//    public OrdemDeServico(int id, int cliente, float desconto, int quantidade, Date data) {

            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            lista = comando.executeQuery();
            while (lista.next()) {//    public OrdemDeServico(int id, int cliente, int quantidade, Date data, int produto) {

                ordem = new OrdemDeServico(id,
                        lista.getInt("Cliente_id"),
                        lista.getInt("Quantidade"),
                        lista.getTimestamp("Data"),
                        lista.getInt("Produto_id"));
            }//
            lista.close();
            comando.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
            ordem = null;
        }
        return ordem;
    }

    public static String alterarOrdem(OrdemDeServico ordem) {
        String sql = "UPDATE Ordemdeservico SET Cliente_id = ?, Quantidade = ? " + " WHERE id = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, ordem.getCliente());
            comando.setInt(2, ordem.getQuantidade());
            comando.setInt(3, ordem.getId());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exc) {
            exc.printStackTrace();
            return "Erro na alteração no BD";
        }
    }

    public static Vector<Visão<String>> getVisões() {
        String sql = "select p.*, c.*, os.* from produto as p left outer join ordemdeservico as os on p.id = os.Produto_id left outer join clientes as c on os.Cliente_id = c.id where os.produto_id is not null order by os.id asc;";

        ResultSet lista = null;
        Vector<Visão<String>> visoes = new Vector<Visão<String>>();

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista = comando.executeQuery();
            while (lista.next()) {

                float valor = lista.getFloat("os.quantidade") * lista.getFloat("p.preco");

                visoes.addElement(new Visão<String>(lista.getString("os.id"),
                        lista.getString("os.id") + "; Produto:  "
                        + lista.getString("p.descricao") + "; Quantidade: "
                        + lista.getString("os.quantidade") + "; Cliente: "
                        + lista.getString("c.nome") + "; Valor total: "
                        + valor));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return visoes;
    }

    public static Vector<Visão<String>> getVisões2() {
        String sql = "select p.*, pp.*, ps.* from produto as p left outer join produtoservico as ps on p.id = ps.idproduto left outer join produtopeca as pp on p.id = pp.idproduto";

        ResultSet lista = null;
        Vector<Visão<String>> visoes = new Vector<Visão<String>>();

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista = comando.executeQuery();
            while (lista.next()) {
                visoes.addElement(new Visão<String>(lista.getString("p.id"),
                        lista.getString("p.id") + ";"
                        + lista.getString("p.descricao") + ";"
                        + lista.getInt("pp.quantidade") + ";"
                        + lista.getFloat("p.preco")));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return visoes;
    }

    public static String removerOrdem(int id) {
        String sql = "DELETE FROM OrdemDeServico WHERE id = ?";

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
        String sql = "Select max(id) from Ordemdeservico";
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
