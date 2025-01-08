package org.ifgoiano;

import org.ifgoiano.DAO.AlunoDAO;
import org.ifgoiano.classes.Aluno;

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
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Voltar");
            System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(System.console().readLine());
            switch (opcao) {
                case 1:
                    //cadastrarAvaliacao();
                    break;
                case 2:
                    //listarAvaliacoes();
                    break;
                case 3:
                    //atualizarAvaliacao();
                    break;
                case 4:
                    //excluirAvaliacao();
                    break;
                case 5:
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
                    //cadastrarAvaliacaoAluno();
                    break;
                case 2:
                    //listarAvaliacoesAlunos();
                    break;
                case 3:
                    //atualizarAvaliacaoAluno();
                    break;
                case 4:
                    //excluirAvaliacaoAluno();
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
    }

    public static void main(String[] args) {
        menu();
    }
}
