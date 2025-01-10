package org.ifgoiano;

import org.ifgoiano.DAO.AlunoDAO;
import org.ifgoiano.DAO.AvaliacaoDAO;
import org.ifgoiano.DAO.AvaliadoDAO;
import org.ifgoiano.classes.Aluno;
import org.ifgoiano.classes.Avaliacao;
import org.ifgoiano.classes.Avaliado;

public class Main {

    public static void menuAlunos() {
        //loop
        while (true) {
            System.out.println("<=-= Alunos =-=>");
            System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Listar por ID");
            System.out.println("4 - Listar por Nome");
            System.out.println("5 - Atualizar");
            System.out.println("6 - Excluir");
            System.out.println("7 - Voltar");
            System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(System.console().readLine());
            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar");
                    System.out.println("Nome: ");
                    String nome = System.console().readLine();
                    System.out.println("Email: ");
                    String email = System.console().readLine();
                    System.out.println("CPF: ");
                    String cpf = System.console().readLine();
                    //cadastrarAluno(nome, email, cpf);
                    try {
                        Aluno aluno = new Aluno(nome, email, cpf);
                        AlunoDAO alunoDAO = new AlunoDAO();
                        alunoDAO.inserir(aluno);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
                        menu();
                        return;
                    }
                    break;
                case 2:
                    System.out.println("Listar todos");
                    try {
                        AlunoDAO alunoDAO = new AlunoDAO();
                        for (Aluno aluno : alunoDAO.listarTudo()) {
                            System.out.println(aluno.toString());
                            System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao listar alunos: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Listar por ID");
                        System.out.println("ID: ");
                        int idPesquisa = Integer.parseInt(System.console().readLine());
                        AlunoDAO alunoDAO = new AlunoDAO();
                        Aluno aluno = alunoDAO.pesquisar(idPesquisa);
                        if (aluno != null) {
                            System.out.println("Aluno encontrado: ");
                            System.out.println(aluno.toString());
                        } else {
                            System.out.println("Aluno não encontrado!");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao pesquisar aluno: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Listar por Nome");
                        System.out.println("Nome: ");
                        String nomePesquisa = System.console().readLine();
                        AlunoDAO alunoDAO = new AlunoDAO();
                        for (Aluno aluno : alunoDAO.pesquisar(nomePesquisa)) {
                            System.out.println(aluno.toString());
                            System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao pesquisar aluno: " + e.getMessage());

                    }
                    break;
                case 5:
                    System.out.println("Atualizar");
                    System.out.println("ID: ");
                    int id = Integer.parseInt(System.console().readLine());
                    System.out.println("Nome: ");
                    String nomeAtualizado = System.console().readLine();
                    System.out.println("Email: ");
                    String emailAtualizado = System.console().readLine();
                    System.out.println("CPF: ");
                    String cpfAtualizado = System.console().readLine();
                    //atualizarAluno(id, nomeAtualizado, emailAtualizado, cpfAtualizado);
                    try {
                        Aluno aluno = new Aluno(nomeAtualizado, emailAtualizado, cpfAtualizado);
                        aluno.setId(id);
                        AlunoDAO alunoDAO = new AlunoDAO();
                        alunoDAO.atualizar(aluno);
                    } catch (Exception e) {
                        System.out.println("Erro ao atualizar aluno: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Excluir");
                    System.out.println("ID: ");
                    int idExcluir = Integer.parseInt(System.console().readLine());
                    //excluirAluno(idExcluir);
                    try {
                        AlunoDAO alunoDAO = new AlunoDAO();
                        alunoDAO.apagar(idExcluir);
                    } catch (Exception e) {
                        System.out.println("Erro ao excluir aluno: " + e.getMessage());
                    }
                    break;
                case 7:

                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuAvaliacoes() {
        //loop
        while (true) {
            System.out.println("Avaliações");
            System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("6 - Voltar");
            System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(System.console().readLine());
            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar");
                    System.out.println("Nome: ");
                    String nome = System.console().readLine();
                    System.out.println("Descrição: ");
                    String descricao = System.console().readLine();
                    System.out.println("Nota Máxima: ");
                    double notaMaxima = Double.parseDouble(System.console().readLine());
                    System.out.println("Nota Mínima: ");
                    double notaMinima = Double.parseDouble(System.console().readLine());
                    //cadastrarAvaliacao(nome, descricao, notaMaxima, notaMinima);
                    try {
                        Avaliacao avaliacao = new Avaliacao(nome, descricao, notaMaxima, notaMinima);
                        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                        avaliacaoDAO.inserir(avaliacao);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar avaliação: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Listar");
                    try {
                        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                        for (Avaliacao avaliacao : avaliacaoDAO.listarTudo()) {
                            System.out.println(avaliacao.toString());
                            System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao listar avaliações: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Buscar por ID");
                    System.out.println("ID: ");
                    int idPesquisa = Integer.parseInt(System.console().readLine());
                    //buscarAvaliacao(idPesquisa);
                    try {
                        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                        Avaliacao avaliacao = avaliacaoDAO.pesquisar(idPesquisa);
                        if (avaliacao != null) {
                            System.out.println("Avaliação encontrada: ");
                            System.out.println(avaliacao.toString());
                        } else {
                            System.out.println("Avaliação não encontrada!");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao pesquisar avaliação: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Atualizar");
                    System.out.println("ID: ");
                    int id = Integer.parseInt(System.console().readLine());
                    System.out.println("Nome: ");
                    String nomeAtualizado = System.console().readLine();
                    System.out.println("Descrição: ");
                    String descricaoAtualizada = System.console().readLine();
                    System.out.println("Nota Máxima: ");
                    double notaMaximaAtualizada = Double.parseDouble(System.console().readLine());
                    System.out.println("Nota Mínima: ");
                    double notaMinimaAtualizada = Double.parseDouble(System.console().readLine());
                    //atualizarAvaliacao(id, nomeAtualizado, descricaoAtualizada, notaMaximaAtualizada, notaMinimaAtualizada);
                    try {
                        Avaliacao avaliacao = new Avaliacao(nomeAtualizado, descricaoAtualizada, notaMaximaAtualizada, notaMinimaAtualizada);
                        avaliacao.setId(id);
                        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                        avaliacaoDAO.atualizar(avaliacao);
                    } catch (Exception e) {
                        System.out.println("Erro ao atualizar avaliação: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Excluir");
                    System.out.println("ID: ");
                    int idExcluir = Integer.parseInt(System.console().readLine());
                    //excluirAvaliacao(idExcluir);
                    try {
                        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                        avaliacaoDAO.apagar(idExcluir);
                    } catch (Exception e) {
                        System.out.println("Erro ao excluir avaliação: " + e.getMessage());
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuAvaliacoesAlunos() {
        //loop
        while (true) {
            System.out.println("Avaliações de Alunos");
            System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Voltar");
            System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(System.console().readLine());
            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar");
                    //cadastrarAvaliacaoAluno();
                    System.out.println("ID do Aluno: ");
                    int idAluno = Integer.parseInt(System.console().readLine());
                    System.out.println("ID da Avaliação: ");
                    int idAvaliacao = Integer.parseInt(System.console().readLine());
                    System.out.println("Nota: ");
                    float nota = Float.parseFloat(System.console().readLine());
                    System.out.println("Observação: ");
                    String observacao = System.console().readLine();
                    //cadastrarAvaliacaoAluno(idAluno, idAvaliacao, nota, observacao);
                    try {
                        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                        Avaliacao avaliacao = avaliacaoDAO.pesquisar(idAvaliacao);
                        AlunoDAO alunoDAO = new AlunoDAO();
                        Aluno aluno = alunoDAO.pesquisar(idAluno);
                        if (avaliacao != null && aluno != null) {
                            Avaliado avaliado = new Avaliado(idAluno, idAvaliacao, nota, observacao, aluno, avaliacao);
                            AvaliadoDAO avaliadoDAO = new AvaliadoDAO();
                            avaliadoDAO.inserir(avaliado);
                        } else {
                            System.out.println("Aluno ou Avaliação não encontrados!");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar avaliação de aluno: " + e.getMessage());

                    }
                    break;
                case 2:
                    System.out.println("Listar");
                    try {
                        AvaliadoDAO avaliadoDAO = new AvaliadoDAO();
                        for (Avaliado avaliado : avaliadoDAO.listarTudo()) {
                            System.out.println(avaliado.toString());
                            System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao listar avaliações de alunos: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Atualizar");
                    System.out.println("ID: ");
                    int id = Integer.parseInt(System.console().readLine());
                    System.out.println("Nota: ");
                    float notaEditar = Float.parseFloat(System.console().readLine());
                    System.out.println("Observação: ");
                    String observacaoEditar = System.console().readLine();
                    //atualizarAvaliacaoAluno(id, idAluno, idAvaliacao, nota, observacao);
                    try {
                        AvaliadoDAO avaliadoDAO = new AvaliadoDAO();
                        Avaliado avaliado = avaliadoDAO.pesquisar(id);
                        if (avaliado != null) {
                            avaliado.setNota(notaEditar);
                            avaliado.setObservacao(observacaoEditar);
                            avaliadoDAO.atualizar(avaliado);
                        } else {
                            System.out.println("Avaliação de aluno não encontrada!");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao atualizar avaliação de aluno: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Excluir");
                    System.out.println("ID: ");
                    int idExcluir = Integer.parseInt(System.console().readLine());
                    //excluirAvaliacaoAluno(idExcluir);
                    try {
                        AvaliadoDAO avaliadoDAO = new AvaliadoDAO();
                        avaliadoDAO.apagar(idExcluir);
                    } catch (Exception e) {
                        System.out.println("Erro ao excluir avaliação de aluno: " + e.getMessage());
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menu() {
        //loop
        try {
            while (true) {
                System.out.println("SGA - Sistema de Gestão Acadêmica");
                System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                System.out.println("1 - Alunos");
                System.out.println("2 - Avaliações");
                System.out.println("3 - Avaliações de Alunos");
                System.out.println("4 - Sair");
                System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                System.out.print("Escolha uma opção: ");
                int opcao = Integer.parseInt(System.console().readLine());
                switch (opcao) {
                    case 1:
                        menuAlunos();
                        break;
                    case 2:
                        menuAvaliacoes();
                        break;
                    case 3:
                        menuAvaliacoesAlunos();
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        } catch (Exception e) {
            System.out.println("Houve um erro inesperado");
            menu();
        }
    }


    public static void main(String[] args) {
        menu();
    }
}
