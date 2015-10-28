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
public class Produto {

    protected String descricao;
    protected int idFornecedor;
    protected float preco;
    protected int id;

    public Produto(int id, int idFornecedor, String descricao, float preco) {
        this.descricao = descricao;
        this.id = id;
        this.idFornecedor = idFornecedor;
        this.preco = preco;

    }

    public Produto(int id, String descricao, float preco) {
        this.descricao = descricao;
        this.id = id;

        this.preco = preco;

    }

    public Produto(int id) {
        this.id = id;
    }

    public Visão<Integer> getVisão() {
        return new Visão<Integer>(id, descricao + " -  " + id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//INSERIR OK!

    public static String inserirProduto(Produto produto) {
        String sql = null;
        try {
            sql = "INSERT INTO Produto (Fornecedor_id,descricao,preco)" + " VALUES (?,?,?)";
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, produto.getIdFornecedor());
            comando.setString(2, produto.getDescricao());
            comando.setFloat(3, produto.getPreco());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return "ERRO na inserção do sql";
        }

        if (produto instanceof ProdutoServico) {
            ProdutoServico produtoServico = (ProdutoServico) produto;

            try {
                sql = "INSERT INTO ProdutoServico (idProduto, status, tempoReparo)" + " VALUES (?,?,?)";
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, produtoServico.getId());
                comando.setInt(2, produtoServico.getStatus2().ordinal());
                comando.setFloat(3, produtoServico.getTempoReparo());
                comando.execute();
                comando.close();
                return null;

            } catch (SQLException e) {
                e.printStackTrace();
                return "Erro na inserção do SQL";

            }
        } else if (produto instanceof ProdutoPeca) {

            ProdutoPeca produtoPeca = (ProdutoPeca) produto;
            try {

                sql = "INSERT INTO ProdutoPeca (idProduto,qualidade,quantidade)" + " VALUES (?,?,?)";
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, produto.getId());
                comando.setString(2, produtoPeca.getQualidade());
                comando.setInt(3, produtoPeca.getQuantidade());
                comando.execute();
                comando.close();
                return null;

            } catch (SQLException e) {
                e.printStackTrace();
                return "ERRO na inserção do sql";
            }
        }
        return null;
    }
// FIM INSERIR OK !

    // BUSCAR PRODUTO = VER
    public static Produto buscarProduto(int id) {
        String sql = "SELECT * FROM Produto" + " WHERE id=?";
        ResultSet lista = null;
        Produto produto = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            lista = comando.executeQuery();
            while (lista.next()) {
                produto = new Produto(id,
                        lista.getInt("Fornecedor_id"),
                        lista.getString("descricao"),
                        lista.getFloat("preco"));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
            produto = null;

        }
        return produto;
    }
//FAZER ESSE MÉTODO

    public static Vector<Visão<String>> buscarPorTecla(String string) {
        String sql = "select p.*, pp.*, ps.*, f.* from produto as p "
                + "left outer join produtoservico as ps on p.id = ps.idproduto "
                + "left outer join produtopeca as pp on p.id = pp.idproduto "
                + "left outer join fornecedor as f on p.Fornecedor_id = f.id "
                + "where descricao like ?";

        ResultSet lista = null;
        Vector<Visão<String>> visoes = new Vector<Visão<String>>();

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, "%" + string + "%");//busca pro qualquer parte da strnig recebida.
            lista = comando.executeQuery();
            while (lista.next()) {
                visoes.addElement(new Visão<String>(lista.getString("p.id"),
                        lista.getString("p.id") + ";"
                        + lista.getString("p.descricao") + ";"
                        + lista.getInt("pp.quantidade") + ";"
                        + lista.getFloat("ps.tempoReparo") + ";"
                        + lista.getString("pp.qualidade") + ";"
                        + lista.getString("f.nome") + ";"
                        + lista.getFloat("p.preco")));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return visoes;
    }

    public static Vector<Visão<String>> buscarTipo(String tipo, String ordenacao, String qualidade) {
        
        String sql = "select p.*, pp.*, ps.*, f.* from produto as p "
                + "left outer join produtoservico as ps on p.id = ps.idproduto "
                + "left outer join produtopeca as pp on p.id = pp.idproduto "
                + "left outer join fornecedor as f on p.Fornecedor_id = f.id "
                + "where p.id = ";
        switch (tipo) {
            case "TODOS":
                sql += "p.id";
                break;
            case "Peças":
                sql += "pp.idproduto";
                break;
            case "Serviços":
                sql += "ps.idproduto";
                break;
        }
        if (qualidade != null) {
            sql += " and pp.qualidade = ";
            switch (qualidade) {
                case "Original":
                    sql += "'Original'";
                    break;
                case "Paralela":
                    sql += "'Paralela'";
                    break;
                case "Usado":
                    sql += "'Usado'";
                    break;

            }
        }
        sql += " order by ";
        if (ordenacao.equals("Preço")) {
            sql += "preco";
        } else if (ordenacao.equals("Alfabética")) {
            sql += "descricao";
        } else if (ordenacao.equals("Código")) {
            sql += "p.id";
        }
        sql += " asc";

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
                        + lista.getFloat("ps.tempoReparo") + ";"
                        + lista.getString("pp.qualidade") + ";"
                        + lista.getString("f.nome") + ";"
                        + lista.getFloat("p.preco")));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return visoes;
    }

    public static Produto buscarProdutoPeca(int id) {
        String sqlPeca = "SELECT * FROM ProdutoPeca" + " WHERE idProduto=?";
        ResultSet lista = null;
        ProdutoPeca peca = null;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sqlPeca);
            comando.setInt(1, id);
            lista = comando.executeQuery();
            while (lista.next()) {
                peca = new ProdutoPeca(id,
                        lista.getString("qualidade"),
                        lista.getInt("quantidade"));
                return peca;
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
            peca = null;

        }
        return peca;
    }

    public static Produto buscarProdutoServico(int id) {
        String sqlServico = "SELECT * FROM ProdutoServico" + " WHERE idProduto=?";
        ResultSet lista = null;

        ProdutoServico servico = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sqlServico);
            comando.setInt(1, id);
            lista = comando.executeQuery();

            while (lista.next()) {

                servico = new ProdutoServico(id,
                        lista.getInt("status"),
                        lista.getInt("tempoReparo"));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
            servico = null;

        }

        return servico;
    }
    // FIM BUSCAR PRODUTO

// ALTERAR PRODUTO VER
    public static String alterarProduto(Produto produto) {
        String sql = null;

        try {
            sql = "UPDATE Produto SET Fornecedor_id = ?, descricao = ?, preco = ?" + " where id = ?";
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, produto.getIdFornecedor());
            comando.setString(2, produto.getDescricao());
            comando.setFloat(3, produto.getPreco());
            comando.setInt(4, produto.getId());
            comando.executeUpdate();
            comando.close();

        } catch (SQLException exc) {
            exc.printStackTrace();
            return "Erro na alteração no BD";
        }

        if (produto instanceof ProdutoServico) {
            try {
                ProdutoServico produtoServico = (ProdutoServico) produto;
                sql = "UPDATE ProdutoServico SET status = ?, tempoReparo= ? " + " WHERE idProduto = ?";
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, produtoServico.getStatus());
                comando.setFloat(2, produtoServico.getTempoReparo());
                comando.setInt(3, produtoServico.getId());
                comando.executeUpdate();
                comando.close();
                return null;
            } catch (SQLException exc) {
                exc.printStackTrace();
                return "Erro na alteração no BD";
            }
        } else if (produto instanceof ProdutoPeca) {
            sql = "UPDATE ProdutoPeca SET qualidade = ?, quantidade = ?" + " WHERE idProduto = ?";
            try {
                ProdutoPeca produtoPeca = (ProdutoPeca) produto;
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setString(1, produtoPeca.getQualidade());
                comando.setInt(2, produtoPeca.getQuantidade());
                comando.setInt(3, produtoPeca.getId());
                comando.executeUpdate();
                comando.close();
                return null;
            } catch (SQLException exc) {
                exc.printStackTrace();
                return "Erro na alteração no BD";
            }
        }
        return null;

    }

    public static String atualizarProduto(ProdutoPeca produto) {
        String sql = null;

        try {
            sql = "UPDATE ProdutoPeca SET Quantidade = ? where idProduto = ?";
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, produto.getQuantidade());
            comando.setInt(2, produto.getId());
            comando.executeUpdate();
            comando.close();

        } catch (SQLException exc) {
            exc.printStackTrace();
            return "Erro na alteração no BD";
        }

        return null;

    }

    public static Vector<Visão<String>> getVisões() {
        String sql = "select p.*, pp.*, ps.*, f.* from produto as p "
                + "left outer join produtoservico as ps on p.id = ps.idproduto "
                + "left outer join produtopeca as pp on p.id = pp.idproduto "
                + "left outer join fornecedor as f on p.Fornecedor_id = f.id";

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
                        + lista.getFloat("ps.tempoReparo") + ";"
                        + lista.getString("pp.qualidade") + ";"
                        + lista.getString("f.nome") + ";"
                        + lista.getFloat("p.preco")));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return visoes;
    }

//metodos removidos pois foi inserido o ON DELETE CASCADE. ASSIM NAO PRECISA DISTO.
    /* 
     public static String removerProdutoPeca(int id) {
     String sql = "DELETE FROM ProdutoPeca WHERE idProduto = ?";

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

     public static String removerProdutoServico(int id) {
     String sql = "DELETE FROM ProdutoServico WHERE idProduto = ?";

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
     */
    public static String removerProduto(int id) {
        String sql = "DELETE FROM Produto WHERE id = ?";

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            comando.executeUpdate();
            comando.close();
            resetar_auto_increment();

            return null;
        } catch (SQLException exc) {
            exc.printStackTrace();
            return "Erro na remoção";
        }

    }

    public static void resetar_auto_increment() {
        int a = ultimoSequencial();
        String sql = "alter table produto auto_increment = " + a;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException e) {
            System.out.println("Nao foi possivel resetar o AUTOINCREMENT DA TABELA.");
        }

    }

    public static int ultimoSequencial() {
        int max = -1;
        String sql = "Select max(id) from Produto";

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
