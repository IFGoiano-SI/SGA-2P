package org.ifgoiano;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Cria uma instância da classe Conexao
            Conexao conexao = new Conexao();

            // Tenta obter uma conexão
            Connection connection = conexao.getConnection();

            // Verifica se a conexão foi estabelecida
            if (connection != null) {
                System.out.println("Conexão com o banco de dados bem-sucedida!");
                // Fecha a conexão após o uso
                conexao.fecharConexao(connection);
            } else {
                System.out.println("Falha ao conectar ao banco de dados.");
            }
        } catch (Exception e) {
            // Captura qualquer outro erro inesperado
            System.err.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
