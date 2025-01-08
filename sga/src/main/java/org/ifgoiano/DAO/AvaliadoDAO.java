package org.ifgoiano.DAO;

import org.ifgoiano.Conexao;
import org.ifgoiano.classes.Aluno;
import org.ifgoiano.classes.Avaliacao;
import org.ifgoiano.classes.Avaliado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar operações de CRUD na tabela Avaliado do banco de dados.
 */
public class AvaliadoDAO {

    // Atributo de conexão com o banco de dados.
    private Connection connection;

    /**
     * Construtor da classe AvaliadoDAO.
     */
    public AvaliadoDAO() {
        this.connection = new Conexao().getConnection();
    }

    /**
     * Salva um novo registro na tabela Avaliado.
     *
     * @param avaliado Objeto Avaliado a ser salvo.
     */
    public void inserir(Avaliado avaliado) {
        String sql = "INSERT INTO avaliado (id_aluno, id_avaliacoes, nota, obs) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, avaliado.getIdAluno());
            stmt.setInt(2, avaliado.getIdAvaliacao());
            stmt.setFloat(3, avaliado.getNota());
            stmt.setString(4, avaliado.getObservacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca um registro na tabela Avaliado pelo ID.
     *
     * @param id ID do registro a ser buscado.
     * @return Objeto Avaliado encontrado ou null caso não exista.
     */
    public Avaliado pesquisar(int id) {
        String sql = "SELECT a.id, id_aluno, id_avaliacoes, nota, obs,  al.nome nome_aluno, email, cpf, av.nome nome_prova, descri, nota_max, nota_min, criado_em FROM avaliado a inner join aluno al on al.id = a.id_aluno inner join avaliacao av on av.id = a.id_avaliacoes where a.ativo = 1 and al.ativo and av.ativo = 1 and a.id = ?";
        Avaliado avaliado = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                avaliado = new Avaliado(rs.getInt("id_aluno"), rs.getInt("id_avaliacoes"), rs.getFloat("nota"), rs.getString("obs"), new Aluno(rs.getString("nome_aluno"), rs.getString("email"), rs.getString("cpf"), 1), new Avaliacao(rs.getString("nome_prova"), rs.getString("descri"), rs.getDouble("nota_max"), rs.getDouble("nota_min")));
                avaliado.setId(rs.getInt("id"));
                avaliado.setAtivo(true);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar avaliado.");
            e.printStackTrace();
        }
        return avaliado;
    }

    /**
     * Atualiza um registro na tabela Avaliado.
     *
     * @param avaliado Objeto Avaliado a ser atualizado.
     */
    public void atualizar(Avaliado avaliado) {
        String sql = "UPDATE avaliado SET  nota = ?, obs = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setFloat(1, avaliado.getNota());
            stmt.setString(2, avaliado.getObservacao());
            stmt.setInt(3, avaliado.getId());
            stmt.executeUpdate();


            int rowsUpdated = stmt.executeUpdate();

            // Mensagem de sucesso
            if (rowsUpdated > 0) {
                System.out.println("Avaliado atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado para atualizar.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um registro na tabela Avaliado.
     *
     * @param id ID do registro a ser deletado.
     */
    public void apagar(int id) {
        String sql = "UPDATE avaliado SET ativo = 0 WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            int rowsUpdated = stmt.executeUpdate();

            // Mensagem de sucesso
            if (rowsUpdated > 0) {
                System.out.println("Avaliado deletado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado para deletar.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma lista com todos os registros da tabela Avaliado.
     *
     * @return Lista de objetos Avaliado.
     */
    public List<Avaliado> listarTudo() {
        String sql = "SELECT a.id, id_aluno, id_avaliacoes, nota, obs,  al.nome nome_aluno, email, cpf, av.nome nome_prova, descri, nota_max, nota_min, criado_em FROM avaliado a inner join aluno al on al.id = a.id_aluno inner join avaliacao av on av.id = a.id_avaliacoes where a.ativo = 1 and al.ativo and av.ativo = 1;";
        List<Avaliado> avaliadoList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Avaliado avaliado = new Avaliado(rs.getInt("id_aluno"), rs.getInt("id_avaliacoes"), rs.getFloat("nota"), rs.getString("obs"), new Aluno(rs.getString("nome_aluno"), rs.getString("email"), rs.getString("cpf"), 1), new Avaliacao(rs.getString("nome_prova"), rs.getString("descri"), rs.getDouble("nota_max"), rs.getDouble("nota_min")));
                avaliado.setId(rs.getInt("id"));
                avaliadoList.add(avaliado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avaliadoList;
    }
}
