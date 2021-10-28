package test;

import control.Encrypt;
import factory.JPAUtil;
import model.dao.ColaboradorDAO;
import model.entity.Colaborador;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ColaboradorDAOTest {

    EntityManager entityManager = JPAUtil.getEntityManager();
    private static final DateTimeFormatter formatterLocalDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);

    @Before
    //Método executado no início de cada teste -> Por isso @before! Nesse caso, inicializa a conexaão com o banco.
    public void before() {
        entityManager.getTransaction().begin();
    }

    @After
    //Método executado no final de cada teste -> Por isso @After! Nesse caso, encerra a conexaão com o banco.
    public void after() {
        entityManager.getTransaction().commit();
    }

    @Test
    //Salva a lista do método auxiliar no banco.
    public void saveTest() {
        List<Colaborador> colaboradores = carregaTabelaColaborador();
        for (Colaborador colaborador : colaboradores) {
            colaboradorDAO.save(colaborador);
        }
    }

    @Test
    //Busca usuário por id no banco, faz o update dos atributos e passa uma senha.
    public void updateTest() {
        Colaborador colaborador = colaboradorDAO.findById(2);
        colaborador.setNome("Pedro Joao");
        colaborador.setEmail("pedro.joao@gmail.com");
        colaborador.setSenha(Encrypt.encryption("12345"));
        colaborador.setDataNascimento(LocalDate.parse("25/10/1990", ColaboradorDAOTest.formatterLocalDate));
        colaboradorDAO.update(colaborador);
    }

    @Test
    // Verifica usuário antes de deletar
    public void deleteTest() {
        try {
            Colaborador colaborador = colaboradorDAO.findById(4);
            colaborador.setId(4);
            colaboradorDAO.delete(colaborador);
        } catch (Exception e) {
            System.out.println("Colaborador não encontrado!");
        }
    }
    @Test
    //Faz o teste comparando uma lista retornada do banco com a lista que foi passada no método save.
    public void findAllTest() {
        List<Colaborador> colaboradores = colaboradorDAO.findAll();
        for (Colaborador colaborador : colaboradores) {
            if (colaborador.getId() == 5) {
                assertEquals("Tales", colaborador.getNome());
            }

        }
    }

    // Método auxiliar para popular o banco.
    public List<Colaborador> carregaTabelaColaborador() {
        List<Colaborador> colaboradores = new ArrayList<>();

        Colaborador colaborador01 = new Colaborador();
        colaborador01.setNome("Maria");
        colaborador01.setEmail("maria@gmail.com");
        colaborador01.setSenha("12345");
        colaborador01.setDataNascimento(LocalDate.parse("01/01/2000", ColaboradorDAOTest.formatterLocalDate));

        Colaborador colaborador02 = new Colaborador();
        colaborador02.setNome("Pedro");
        colaborador02.setEmail("pedro@gmail.com");
        colaborador02.setSenha("12345");
        colaborador02.setDataNascimento(LocalDate.parse("13/09/1998", ColaboradorDAOTest.formatterLocalDate));

        Colaborador colaborador03 = new Colaborador();
        colaborador03.setNome("Ana");
        colaborador03.setEmail("ana@gmail.com");
        colaborador03.setSenha("12345");
        colaborador03.setDataNascimento(LocalDate.parse("25/04/1981", ColaboradorDAOTest.formatterLocalDate));

        Colaborador colaborador04 = new Colaborador();
        colaborador04.setNome("Marcus");
        colaborador04.setEmail("marcus@gmail.com");
        colaborador04.setSenha("12345");
        colaborador04.setDataNascimento(LocalDate.parse("12/07/1984", ColaboradorDAOTest.formatterLocalDate));

        Colaborador colaborador05 = new Colaborador();
        colaborador05.setNome("Tales");
        colaborador05.setEmail("tales@gmail.com");
        colaborador05.setSenha("12345");
        colaborador05.setDataNascimento(LocalDate.parse("20/08/2002", ColaboradorDAOTest.formatterLocalDate));

        colaboradores.add(colaborador01);
        colaboradores.add(colaborador02);
        colaboradores.add(colaborador03);
        colaboradores.add(colaborador04);
        colaboradores.add(colaborador05);
        return colaboradores;
    }
}
