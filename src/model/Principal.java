package model;

import factory.JPAUtil;
import model.dao.ColaboradorDAO;
import model.entity.Colaborador;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while(flag){

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

                System.out.println("Digite a data de nascimento: dd/MM/yyyy ");
                String dataNascimento = scanner.next();

                Colaborador colaborador = new Colaborador();
                ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);
                colaborador.setNome(nome);
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

                System.out.println("Digite a data de nascimento: dd/MM/yyyy ");
                String dataNascimento = scanner.next();

                colaborador.setNome(nome);
                colaborador.setEmail(email);
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




    }

}





