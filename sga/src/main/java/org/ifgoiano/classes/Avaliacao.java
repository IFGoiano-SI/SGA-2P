package org.ifgoiano.classes;

/**
 * Classe que representa uma avaliação no sistema escolar.
 * Contém informações sobre o nome, descrição, notas máximas e mínimas, e a data de criação.
 * <p>
 * Atributos:
 *  <ul>
 *     <li>{@code id}: ID único de cada avaliação.</li>
 *     <li>{@code nome}: Nome da avaliação.</li>
 *     <li>{@code descricao}: Descrição da avaliação.</li>
 *     <li>{@code notaMaxima}: Nota máxima possível da avaliação.</li>
 *     <li>{@code notaMinima}: Nota mínima possível da avaliação.</li>
 *     <li>{@code criadoEm}: Data e hora de criação da avaliação.</li>
 * </ul>
 */
public class Avaliacao {
    private int id;
    private String nome;
    private String descricao;
    private double notaMaxima;
    private double notaMinima;
    private String criadoEm;

    /**
     * Construtor da classe Avaliacao.
     *
     * @param nome       Nome da avaliação.
     * @param descricao  Descrição da avaliação.
     * @param notaMaxima Nota máxima possível da avaliação.
     * @param notaMinima Nota mínima possível da avaliação.
     */
    public Avaliacao(String nome, String descricao, double notaMaxima, double notaMinima) {
        this.nome = nome;
        this.descricao = descricao;
        this.notaMaxima = notaMaxima;
        this.notaMinima = notaMinima;
    }

    /**
     * Método que retorna o ID da avaliação.
     * @return ID da avaliação.
     */
    public int getId() {
        return id;
    }

    /**
     * Método que altera o ID da avaliação.
     * @param id Novo ID da avaliação.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que retorna o nome da avaliação.
     * @return Nome da avaliação.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que altera o nome da avaliação.
     * @param nome Novo nome da avaliação.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retorna a descrição da avaliação.
     * @return Descrição da avaliação.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método que altera a descrição da avaliação.
     * @param descricao Nova descrição da avaliação.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Método que retorna a nota máxima da avaliação.
     * @return Nota máxima da avaliação.
     */
    public double getNotaMaxima() {
        return notaMaxima;
    }

    /**
     * Método que altera a nota máxima da avaliação.
     * @param notaMaxima Nova nota máxima da avaliação.
     */
    public void setNotaMaxima(double notaMaxima) {
        this.notaMaxima = notaMaxima;
    }

    /**
     * Método que retorna a nota mínima da avaliação.
     * @return Nota mínima da avaliação.
     */
    public double getNotaMinima() {
        return notaMinima;
    }

    /**
     * Método que altera a nota mínima da avaliação.
     * @param notaMinima Nova nota mínima da avaliação.
     */
    public void setNotaMinima(double notaMinima) {
        this.notaMinima = notaMinima;
    }

    /**
     * Método que retorna a data e hora de criação da avaliação.
     * @return Data e hora de criação da avaliação.
     */
    public String getCriadoEm() {
        return criadoEm;
    }

    /**
     * Método que altera a data e hora de criação da avaliação.
     * @param criadoEm Nova data e hora de criação da avaliação.
     */
    public void setCriadoEm(String criadoEm) {
        this.criadoEm = criadoEm;
    }

    /**
     * Sobrescrita do método {@code toString} para retornar os dados da avaliação.
     * A string retornada contém o nome, ID, descrição, notas máximas e mínimas, e a data de criação da avaliação.
     * @return String com os dados da avaliação.
     */
    @Override
    public String toString() {
        return "\n Avaliação: " + nome + '\n'
                + " ID: " + id + '\n'
                + " Descrição: " + descricao + '\n'
                + " Nota Máxima: " + notaMaxima + '\n'
                + " Nota Mínima: " + notaMinima + '\n'
                + " Criado Em: " + criadoEm + '\n';
    }
}

