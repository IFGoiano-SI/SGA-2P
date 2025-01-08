package org.ifgoiano.classes;

/**
 * Classe que representa a relação de um aluno com uma avaliação no sistema escolar.
 * Contém informações sobre o aluno, a avaliação realizada, a nota recebida e observações adicionais.
 * <p>
 * Atributos:
 *  <ul>
 *     <li>{@code id}: ID único para cada relação.</li>
 *     <li>{@code idAluno}: ID do aluno relacionado.</li>
 *     <li>{@code idAvaliacao}: ID da avaliação relacionada.</li>
 *     <li>{@code nota}: Nota recebida pelo aluno.</li>
 *     <li>{@code observacao}: Observação adicional sobre a avaliação.</li>
 *     <li>{@code ativo}: Status da relação (ativo ou inativo).</li>
 * </ul>
 */
public class Avaliado {
    private int id;
    private int idAluno;
    private int idAvaliacao;
    private float nota;
    private String observacao;
    private boolean ativo;
    private Aluno aluno;
    private Avaliacao aval;

    /**
     * Construtor da classe Avaliado.
     *
     * @param idAluno     ID do aluno relacionado.
     * @param idAvaliacao ID da avaliação relacionada.
     * @param nota        Nota recebida pelo aluno.
     * @param observacao  Observação adicional (opcional).
     */
    public Avaliado(int idAluno, int idAvaliacao, float nota, String observacao) {
        this.idAluno = idAluno;
        this.idAvaliacao = idAvaliacao;
        this.nota = nota;
        this.observacao = observacao;
        this.ativo = true;
    }

    /**
     * Construtor da classe Avaliado.
     *
     * @param idAluno     ID do aluno relacionado.
     * @param idAvaliacao ID da avaliação relacionada.
     * @param nota        Nota recebida pelo aluno.
     * @param observacao  Observação adicional (opcional).
     * @param aluno       Aluno relacionado.
     * @param aval        Avaliação relacionada.
     */
    public Avaliado(int idAluno, int idAvaliacao, float nota, String observacao, Aluno aluno, Avaliacao aval) {
        this.idAluno = idAluno;
        this.idAvaliacao = idAvaliacao;
        this.nota = nota;
        this.observacao = observacao;
        this.ativo = true;
        this.aluno = aluno;
        this.aval = aval;
    }

    /**
     * Método que retorna o ID da relação.
     *
     * @return ID da relação.
     */
    public int getId() {
        return id;
    }

    /**
     * Método que altera o ID da relação.
     *
     * @param id Novo ID da relação.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que retorna o ID do aluno relacionado.
     *
     * @return ID do aluno relacionado.
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * Método que altera o ID do aluno relacionado.
     *
     * @param idAluno Novo ID do aluno relacionado.
     */
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    /**
     * Método que retorna o ID da avaliação relacionada.
     *
     * @return ID da avaliação relacionada.
     */
    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    /**
     * Método que altera o ID da avaliação relacionada.
     *
     * @param idAvaliacao Novo ID da avaliação relacionada.
     */
    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    /**
     * Método que retorna a nota recebida pelo aluno.
     *
     * @return Nota recebida pelo aluno.
     */
    public float getNota() {
        return nota;
    }

    /**
     * Método que altera a nota recebida pelo aluno.
     *
     * @param nota Nova nota recebida pelo aluno.
     */
    public void setNota(float nota) {
        this.nota = nota;
    }

    /**
     * Método que retorna a observação adicional.
     *
     * @return Observação adicional.
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Método que altera a observação adicional.
     *
     * @param observacao Nova observação adicional.
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * Método que retorna o status da relação.
     *
     * @return {@code true} se a relação estiver ativa, caso contrário, {@code false}.
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * Método que altera o status da relação.
     *
     * @param ativo Novo status da relação.
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * Sobrescrita do método {@code toString} para retornar os dados da relação.
     * A string retornada contém o ID, o aluno, a avaliação, a nota e a observação.
     *
     * @return String com os dados da relação.
     */
    @Override
    public String toString() {
        return "\n Avaliado: " + id + '\n'
                + " ID Aluno: " + idAluno + '\n'
                + " ID Avaliação: " + idAvaliacao + '\n'
                + " Nota: " + nota + '\n'
                + " Observação: " + observacao + '\n'
                + " Ativo: " + (ativo ? "Sim" : "Não") + '\n'
                + " Aluno: " + aluno.getNome() + '\n'
                + " Avaliação: " + aval.getNome();
    }
}
