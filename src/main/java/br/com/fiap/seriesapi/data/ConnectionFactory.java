package br.com.fiap.seriesapi.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    final static String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    final static String USER = "rm98837";
    final static String PASS = "280101";

    private static Connection conexao;

    public static Connection createConnection() throws SQLException {
        if (conexao == null){
            conexao = DriverManager.getConnection(URL, USER, PASS);
        }
        return conexao;
    }
    
}