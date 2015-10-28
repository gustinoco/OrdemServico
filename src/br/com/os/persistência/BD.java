/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.persistência;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

    static final String URL_BD = "jdbc:mysql://localhost:3307/ordemdeservico";
    static final String USUÁRIO = "root";
    static final String SENHA = "gu";
    public static Connection conexão = null;

    public static void criaConexão() {
        try {
            conexão = DriverManager.getConnection(URL_BD, USUÁRIO, SENHA);
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
    }

    public static void fechaConexão() {
        try {
            conexão.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
    }
}
