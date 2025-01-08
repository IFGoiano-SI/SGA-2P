package org.ifgoiano.classes;

/**
 * Classe que representa um aluno no sistema escolar.
 * Contém informações sobre o nome, e-mail, CPF e status do aluno.
 * <p>
 * Atributos:
 *  <ul>
 *     <li>{@code id}: ID único de cada aluno.</li>
 *     <li>{@code nome}: Nome do aluno.</li>
 *     <li>{@code email}: E-mail do aluno.</li>
 *     <li>{@code cpf}: CPF do aluno.</li>
 *     <li>{@code ativo}: Status do aluno (ativo ou inativo).</li>
 * </ul>
 */
public class Aluno {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private boolean ativo;

    /**
     * Construtor da classe Aluno.
     *
     * @param nome  Nome do aluno.
     * @param email E-mail do aluno.
     * @param cpf   CPF do aluno.
     */
    public Aluno(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.ativo = true;
    }

    /**
     * Construtor da classe Aluno.
     *
     * @param nome  Nome do aluno.
     * @param email E-mail do aluno.
     * @param cpf   CPF do aluno.
     */
    public Aluno(int id, String nome, String email, String cpf, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.ativo = ativo;
    }

    /**
     * Construtor da classe Aluno.
     *
     * @param nome  Nome do aluno.
     * @param email E-mail do aluno.
     * @param cpf   CPF do aluno.
     * @param ativo Status do aluno.
     */
    public Aluno(String nome, String email, String cpf, int ativo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.ativo = ativo == 1;
    }

    /**
     * Método que retorna o ID do aluno.
     *
     * @return ID do aluno.
     */
    public int getId() {
        return id;
    }

    /**
     * Método que altera o ID do aluno.
     *
     * @param id Novo ID do aluno.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que retorna o nome do aluno.
     *
     * @return Nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que altera o nome do aluno.
     *
     * @param nome Novo nome do aluno.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retorna o e-mail do aluno.
     *
     * @return E-mail do aluno.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método que altera o e-mail do aluno.
     *
     * @param email Novo e-mail do aluno.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método que retorna o CPF do aluno.
     *
     * @return CPF do aluno.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Método que altera o CPF do aluno.
     *
     * @param cpf Novo CPF do aluno.
     */
    public void setCpf(String cpf) {
        // Verifica se o CPF é válido
        if (cpf.length() == 14) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido.");
        }
    }

    /**
     * Método que retorna o status do aluno.
     *
     * @return {@code true} se o aluno estiver ativo, caso contrário, {@code false}.
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * Método que altera o status do aluno.
     *
     * @param ativo Novo status do aluno.
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * Sobrescrita do método {@code toString} para retornar os dados do aluno.
     * A string retornada contém o nome, o ID, o e-mail, o CPF e o status do aluno.
     *
     * @return String com os dados do aluno.
     */
    @Override
    public String toString() {
        return "\n Aluno: " + nome + '\n'
                + " ID: " + id + '\n'
                + " Email: " + email + '\n'
                + " CPF: " + cpf + '\n'
                + " Ativo: " + (ativo ? "Sim" : "Não") + '\n';
    }
}
