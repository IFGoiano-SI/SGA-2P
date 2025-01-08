package org.ifgoiano.DAO;

import org.ifgoiano.Conexao;
import org.ifgoiano.classes.Avaliacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar operações de CRUD na tabela Avaliacao do banco de dados.
 */
public class AvaliacaoDAO {

    // Atributo de conexão com o banco de dados.
    private Connection connection;

    /**
     * Construtor da classe AvaliacaoDAO.
     */
    public AvaliacaoDAO() {
        this.connection = new Conexao().getConnection();
    }

    /**
     * Salva um novo registro na tabela Avaliacao.
     *
     * @param avaliacao Objeto Avaliacao a ser salvo.
     */
    public void inserir(Avaliacao avaliacao) {
        String sql = "INSERT INTO avaliacao (nome, descri, nota_max, nota_min) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, avaliacao.getNome());
            stmt.setString(2, avaliacao.getDescricao());
            stmt.setDouble(3, avaliacao.getNotaMaxima());
            stmt.setDouble(4, avaliacao.getNotaMinima());
            stmt.executeUpdate();

            System.out.println("Avaliação cadastrada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca um registro na tabela Avaliacao pelo ID.
     *
     * @param id ID do registro a ser buscado.
     * @return Objeto Avaliacao encontrado ou null caso não exista.
     */
    public Avaliacao pesquisar(int id) {
        String sql = "SELECT * FROM avaliacao WHERE id = ? AND ativo = 1";
        Avaliacao avaliacao = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                avaliacao = new Avaliacao(rs.getString("nome"), rs.getString("descri"), rs.getDouble("nota_max"), rs.getDouble("nota_min"));
                avaliacao.setId(rs.getInt("id"));
                avaliacao.setCriadoEm(rs.getString("criado_em"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avaliacao;
    }

    /**
     * Atualiza um registro na tabela Avaliacao.
     *
     * @param avaliacao Objeto Avaliacao a ser atualizado.
     */
    public void atualizar(Avaliacao avaliacao) {
        String sql = "UPDATE avaliacao SET nome = ?, descri = ?, nota_max = ?, nota_min = ? WHERE id = ? AND ativo = 1";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, avaliacao.getNome());
            stmt.setString(2, avaliacao.getDescricao());
            stmt.setDouble(3, avaliacao.getNotaMaxima());
            stmt.setDouble(4, avaliacao.getNotaMinima());
            stmt.setInt(5, avaliacao.getId());
            stmt.executeUpdate();

            System.out.println("Avaliação atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um registro na tabela Avaliacao.
     *
     * @param id ID do registro a ser deletado.
     */
    public void apagar(int id) {
        String sql = "UPDATE avaliacao SET ativo = 0 WHERE id = ? AND ativo = 1";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Avaliação deletada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma lista com todos os registros da tabela Avaliacao.
     *
     * @return Lista de objetos Avaliacao.
     */
    public List<Avaliacao> listarTudo() {
        String sql = "SELECT * FROM avaliacao WHERE ativo = 1";
        List<Avaliacao> avaliacaoList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao(rs.getString("nome"), rs.getString("descri"), rs.getDouble("nota_max"), rs.getDouble("nota_min"));
                avaliacao.setId(rs.getInt("id"));
                avaliacao.setCriadoEm(rs.getString("criado_em"));
                avaliacaoList.add(avaliacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avaliacaoList;
    }
}