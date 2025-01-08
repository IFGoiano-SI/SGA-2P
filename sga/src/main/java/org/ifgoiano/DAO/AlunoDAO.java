package org.ifgoiano.DAO;

import org.ifgoiano.Conexao;
import org.ifgoiano.classes.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar operações de CRUD na tabela Aluno do banco de dados.
 */
public class AlunoDAO {

    // Atributo de conexão com o banco de dados.
    private Connection connection;

    /**
     * Construtor da classe AlunoDAO.
     */
    public AlunoDAO() {
        this.connection = new Conexao().getConnection();
    }

    /**
     * Salva um novo registro na tabela Aluno.
     *
     * @param aluno Objeto Aluno a ser salvo.
     */
    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, email, cpf, ativo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getCpf());
            stmt.setInt(4, aluno.isAtivo() ? 1 : 0);
            stmt.executeUpdate();

            System.out.println("Aluno cadastrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca um registro na tabela Aluno pelo ID.
     *
     * @param id ID do registro a ser buscado.
     * @return Objeto Aluno encontrado ou null caso não exista.
     */
    public Aluno pesquisar(int id) {
        String sql = "SELECT * FROM aluno WHERE id = ? AND ativo = 1";
        Aluno aluno = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                aluno = new Aluno(rs.getString("nome"), rs.getString("email"), rs.getString("cpf"));
                aluno.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aluno;
    }

    // Buscar aluno por nome
    public List<Aluno> pesquisar(String nome) {
        String sql = "SELECT * FROM aluno WHERE nome LIKE ? AND ativo = 1";
        List<Aluno> AlunoList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%"); // Adiciona os curingas % ao redor do nome
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getString("nome"), rs.getString("email"), rs.getString("cpf"), rs.getInt("ativo"));
                aluno.setId(rs.getInt("id"));
                AlunoList.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AlunoList;
    }


    /**
     * Atualiza um registro na tabela Aluno.
     *
     * @param aluno Objeto Aluno a ser atualizado.
     */
    public void atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, email = ?, cpf = ?, ativo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getCpf());
            stmt.setInt(4, aluno.isAtivo() ? 1 : 0);
            stmt.setInt(5, aluno.getId());
            stmt.executeUpdate();

            int rowsUpdated = stmt.executeUpdate();

            // Mensagem de sucesso
            if (rowsUpdated > 0) {
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado para atualizar.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um registro na tabela Aluno.
     *
     * @param id ID do registro a ser deletado.
     */
    public void apagar(int id) {
        String sql = "UPDATE aluno SET ativo = 0 WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            int rowsUpdated = stmt.executeUpdate();

            // Mensagem de sucesso
            if (rowsUpdated > 0) {
                System.out.println("Aluno deletado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado para deletar.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma lista com todos os registros da tabela Aluno.
     *
     * @return Lista de objetos Aluno.
     */
    public List<Aluno> listarTudo() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> AlunoList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getString("nome"), rs.getString("email"), rs.getString("cpf"), rs.getInt("ativo"));
                aluno.setId(rs.getInt("id"));
                AlunoList.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AlunoList;
    }
}
