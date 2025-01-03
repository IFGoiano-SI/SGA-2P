package org.ifgoiano;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String url;
    private String username;
    private String password;

    public Conexao() {
        Environments env = new Environments();
        this.url = env.URL;
        this.username = env.USERNAME;
        this.password = env.PASSWORD;
    }

    /**
     * Método para obter uma nova conexão com o banco de dados.
     * @return a conexão com o banco.
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            // Exibindo a mensagem de erro sem o uso de Logger
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Método para fechar a conexão com o banco de dados.
     * @param connection a conexão a ser fechada.
     */
    public void fecharConexao(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Exibindo a mensagem de erro sem o uso de Logger
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

