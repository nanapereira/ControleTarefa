package model;

import factory.JPAUtil;
import control.Encrypt;
import model.dao.ColaboradorDAO;
import model.dao.GestorDAO;
import model.dao.TarefaDAO;
import model.entity.Colaborador;
import model.entity.Gestor;
import model.entity.Tarefa;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();

        Scanner scanner = new Scanner(System.in);
        boolean flag2 = true;

        while (flag2) {
            boolean flag = true;
            System.out.println("Qual ação deseja executar?");
            System.out.println("1- Cadastro de Gestor");
            System.out.println("2- Cadastro de Colaborador");
            System.out.println("2- Cadastro de Tarefa");
            System.out.println("0- Sair");

            int option2 = scanner.nextInt();

            switch (option2) {
                case 1:
                    while (flag) {
                        System.out.println("Qual ação deseja executar?");
                        System.out.println("1-CADASTRAR");
                        System.out.println("2-ALTERAR");
                        System.out.println("3-DELETAR");
                        System.out.println("4-PESQUISAR POR ID");
                        System.out.println("5-PESQUISAR TODOS");
                        System.out.println("0-SAIR");

                        int option = scanner.nextInt();

                        if (option == 1) {

                            //a classe Scanner só pega o primeiro nome
                            System.out.println("Digite o nome");
                            String nome = scanner.next();

                            System.out.println("Digite o email");
                            String email = scanner.next();

                            System.out.println("Digite a senha");
                            String senha = scanner.next();

                            Gestor gestor = new Gestor();
                            GestorDAO gestorDAO = new GestorDAO(entityManager);
                            gestor.setNome(nome);
                            gestor.setEmail(email);
                            gestor.setSenha(Encrypt.encryption(senha));

                            //inicia a transaçao com o BD
                            entityManager.getTransaction().begin();
                            gestorDAO.save(gestor);

                            //comita
                            entityManager.getTransaction().commit();

                            System.out.println(gestor);
                            System.out.println("Gestor Cadastrado!");


                        } else if (option == 2) {

                            GestorDAO gestorDAO = new GestorDAO(entityManager);

                            //testando o update
                            System.out.println("Digite o id do gestor que deseja alterar");
                            int id = scanner.nextInt();

                            Gestor gestor = gestorDAO.findById(id);

                            System.out.println("Digite o nome");
                            String nome = scanner.next();

                            System.out.println("Digite o email");
                            String email = scanner.next();

                            System.out.println("Digite a senha");
                            String senha = scanner.next();

                            gestor.setNome(nome);
                            gestor.setEmail(email);
                            gestor.setSenha(Encrypt.encryption(senha));

                            //inicia a transaçao com o BD
                            entityManager.getTransaction().begin();

                            gestorDAO.update(gestor);

                            //comita
                            entityManager.getTransaction().commit();

                            System.out.println("Gestor Alterado!");
                            System.out.println(gestor);

                        } else if (option == 3) {

                            //testando o delete
                            System.out.println("Digite o id do gestor que deseja excluir");
                            int id = scanner.nextInt();

                            GestorDAO gestorDAO = new GestorDAO(entityManager);
                            Gestor gestor = gestorDAO.findById(id);

                            //inicia a transaçao com o BD
                            entityManager.getTransaction().begin();
                            gestorDAO.delete(gestor);

                            //comita
                            entityManager.getTransaction().commit();

                            System.out.println("Gestor Excluído!");

                        } else if (option == 4) {

                            GestorDAO gestorDAO = new GestorDAO(entityManager);

                            System.out.println("Digite o id do gestor que deseja pesquisar");
                            int id = scanner.nextInt();

                            Gestor gestor = gestorDAO.findById(id);
                            System.out.println(gestor);

                        } else if (option == 5) {

                            GestorDAO gestorDAO = new GestorDAO(entityManager);

                            //testando o findAll
                            System.out.println("Lista de Gestores");
                            List<Gestor> listaGestor = gestorDAO.findAll();
                            listaGestor.forEach(c -> System.out.println(c));

                        } else if (option == 0) {
                            flag = false;
                        }
                    }
                    break;
                case 2:
                    while (flag) {
                        System.out.println("Qual ação deseja executar?");
                        System.out.println("1-CADASTRAR");
                        System.out.println("2-ALTERAR");
                        System.out.println("3-DELETAR");
                        System.out.println("4-PESQUISAR POR ID");
                        System.out.println("5-PESQUISAR TODOS");
                        System.out.println("0-SAIR");

                        int option = scanner.nextInt();

                        if (option == 1) {

                            //a classe Scanner só pega o primeiro nome
                            System.out.println("Digite o nome");
                            String nome = scanner.next();

                            System.out.println("Digite o email");
                            String email = scanner.next();

                            System.out.println("Digite a senha");
                            String senha = scanner.next();

                            System.out.println("Digite a data de nascimento: dd/MM/yyyy ");
                            String dataNascimento = scanner.next();

                            Colaborador colaborador = new Colaborador();
                            ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);
                            colaborador.setNome(nome);
                            colaborador.setSenha(Encrypt.encryption(senha));
                            colaborador.setEmail(email);

                            colaborador.setDataNascimento(LocalDate.parse(dataNascimento, Principal.formatter));

                            //inicia a transaçao com o BD
                            entityManager.getTransaction().begin();
                            colaboradorDAO.save(colaborador);

                            //comita
                            entityManager.getTransaction().commit();

                            System.out.println(colaborador);
                            System.out.println("Colaborador Cadastrado!");


                        } else if (option == 2) {

                            ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);

                            //testando o update
                            System.out.println("Digite o id do colaborador que deseja alterar");
                            int id = scanner.nextInt();

                            Colaborador colaborador = colaboradorDAO.findById(id);

                            System.out.println("Digite o nome");
                            String nome = scanner.next();

                            System.out.println("Digite o email");
                            String email = scanner.next();

                            System.out.println("Digite a senha");
                            String senha = scanner.next();

                            System.out.println("Digite a data de nascimento: dd/MM/yyyy ");
                            String dataNascimento = scanner.next();

                            colaborador.setNome(nome);
                            colaborador.setEmail(email);
                            colaborador.setSenha(Encrypt.encryption(senha));
                            colaborador.setDataNascimento(LocalDate.parse(dataNascimento, Principal.formatter));

                            //inicia a transaçao com o BD
                            entityManager.getTransaction().begin();

                            colaboradorDAO.update(colaborador);

                            //comita
                            entityManager.getTransaction().commit();

                            System.out.println("Colaborador Alterado!");
                            System.out.println(colaborador);

                        } else if (option == 3) {

                            //testando o delete
                            System.out.println("Digite o id do colaborador que deseja excluir");
                            int id = scanner.nextInt();

                            ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);
                            Colaborador colaborador = colaboradorDAO.findById(id);

                            //inicia a transaçao com o BD
                            entityManager.getTransaction().begin();
                            colaboradorDAO.delete(colaborador);

                            //comita
                            entityManager.getTransaction().commit();

                            System.out.println("Colaborador Excluído!");

                        } else if (option == 4) {

                            ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);

                            System.out.println("Digite o id do colaborador que deseja pesquisar");
                            int id = scanner.nextInt();

                            Colaborador colaborador = colaboradorDAO.findById(id);
                            System.out.println(colaborador);

                        } else if (option == 5) {

                            ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);

                            //testando o findAll
                            System.out.println("Lista de Colaborador");
                            List<Colaborador> listaColaborador = colaboradorDAO.findAll();
                            listaColaborador.forEach(c -> System.out.println(c));


                        } else if (option == 0) {
                            flag = false;
                        }
                    }
                    break;
                case 3:
                    while (flag) {
                        System.out.println("Qual ação deseja executar?");
                        System.out.println("1-CADASTRAR");
                        System.out.println("2-ALTERAR");
                        System.out.println("3-DELETAR");
                        System.out.println("4-PESQUISAR POR ID");
                        System.out.println("5-PESQUISAR TODOS");
                        System.out.println("0-SAIR");

                        int option = scanner.nextInt();

                        if (option == 1) {

                            //a classe Scanner só pega o primeiro nome
                            System.out.println("Digite o id colaborador");
                            int idColaborador = scanner.nextInt();

                            System.out.println("Digite a descrição");
                            String descricao = scanner.next();

                            System.out.println("Digite a data de início: dd/MM/yyyy hh:ss");
                            String dataInicio = scanner.next();

                            System.out.println("Digite a data final: dd/MM/yyyy ");
                            String dataFim = scanner.next();

                            System.out.println("Digite o status da tarefa ");
                            String status = scanner.next();

                            System.out.println("Digite a prioridade ");
                            String prioridade = scanner.next();

                            System.out.println("Digite a observacao");
                            String observacao = scanner.next();

                            Tarefa tarefa = new Tarefa();
                            TarefaDAO tarefaDAO = new TarefaDAO(entityManager);

                            ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);
                            Colaborador colaborador = colaboradorDAO.findById(idColaborador);
                            tarefa.setColaborador(colaborador);
                            tarefa.setDescricao(descricao);
                            tarefa.setDataInicio(LocalDateTime.parse(dataInicio, Principal.formatter));
                            tarefa.setDataFim(LocalDateTime.parse(dataFim, Principal.formatter));
                            tarefa.setStatus(status);
                            tarefa.setPrioridade(prioridade);
                            tarefa.setObservacao(observacao);

                            //inicia a transaçao com o BD
                            entityManager.getTransaction().begin();
                            tarefaDAO.save(tarefa);

                            //comita
                            entityManager.getTransaction().commit();

                            System.out.println(colaborador);
                            System.out.println("Tarefa Cadastrada!");

                        } else if (option == 2) {

                            TarefaDAO tarefaDAO = new TarefaDAO(entityManager);

                            //testando o update
                            System.out.println("Digite o id da tarefa que deseja alterar");
                            int id = scanner.nextInt();

                            Tarefa tarefa = tarefaDAO.findById(id);

                            System.out.println("Digite o id colaborador");
                            int idColaborador = scanner.nextInt();

                            System.out.println("Digite a descrição");
                            String descricao = scanner.next();

                            System.out.println("Digite a data de início: dd/MM/yyyy hh:ss");
                            String dataInicio = scanner.next();

                            System.out.println("Digite a data final: dd/MM/yyyy ");
                            String dataFim = scanner.next();

                            System.out.println("Digite o status da tarefa ");
                            String status = scanner.next();

                            System.out.println("Digite a prioridade ");
                            String prioridade = scanner.next();

                            System.out.println("Digite a observacao");
                            String observacao = scanner.next();

                            ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);
                            Colaborador colaborador = colaboradorDAO.findById(idColaborador);
                            tarefa.setColaborador(colaborador);
                            tarefa.setDescricao(descricao);
                            tarefa.setDataInicio(LocalDateTime.parse(dataInicio, Principal.formatter));
                            tarefa.setDataFim(LocalDateTime.parse(dataFim, Principal.formatter));
                            tarefa.setStatus(status);
                            tarefa.setPrioridade(prioridade);
                            tarefa.setObservacao(observacao);

                            //inicia a transaçao com o BD
                            entityManager.getTransaction().begin();

                            tarefaDAO.update(tarefa);

                            //comita
                            entityManager.getTransaction().commit();

                            System.out.println("Tarefa Alterado!");
                            System.out.println(colaborador);

                        } else if (option == 3) {

                            //testando o delete
                            System.out.println("Digite o id da tarefa que deseja excluir");
                            int id = scanner.nextInt();

                            TarefaDAO tarefaDAO = new TarefaDAO(entityManager);
                            Tarefa tarefa = tarefaDAO.findById(id);

                            //inicia a transaçao com o BD
                            entityManager.getTransaction().begin();
                            tarefaDAO.delete(tarefa);

                            //comita
                            entityManager.getTransaction().commit();

                            System.out.println("Tarefa Excluída!");

                        } else if (option == 4) {

                            TarefaDAO tarefaDAO = new TarefaDAO(entityManager);

                            System.out.println("Digite o id da tarefa que deseja pesquisar");
                            int id = scanner.nextInt();

                            Tarefa tarefa = tarefaDAO.findById(id);
                            System.out.println(tarefa);

                        } else if (option == 5) {

                            TarefaDAO tarefaDAO = new TarefaDAO(entityManager);

                            //testando o findAll
                            System.out.println("Lista de Colaborador");
                            List<Tarefa> listaTarefa = tarefaDAO.findAll();
                            listaTarefa.forEach(c -> System.out.println(c));


                        } else if (option == 0) {
                            flag = false;
                        }
                    }
                    break;
                case 0:
                    flag2 = false;
                    break;
            }
        }
    }
}





