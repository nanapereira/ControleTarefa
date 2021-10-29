package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import controller.Encrypt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factory.JPAUtil;
import model.dao.GestorDAO;
import model.entity.Gestor;

public class GestorDAOTest {
	
	EntityManager entityManager = JPAUtil.getEntityManager();
    GestorDAO gestorDAO = new GestorDAO(entityManager);

    @Before
    public void before() {
        entityManager.getTransaction().begin();
    }

    @After
    public void after() {
        entityManager.getTransaction().commit();
    }
        
    @Test
    public void saveTest() {
        List<Gestor> gestores = carregaTabelaGestor();
        for (Gestor gestor : gestores) {
        	gestorDAO.save(gestor);
        }
    }

    @Test
    public void updateTest() {
    	Gestor gestor = gestorDAO.findById(2);
    	gestor.setNome("Pedro");
    	gestor.setEmail("pedro.joao@gmail.com");
    	gestor.setSenha(Encrypt.encryption("12345"));
    	gestorDAO.update(gestor);
    }

    @Test
    public void deleteTest() {
        try {
            Gestor gestor = gestorDAO.findById(3);
            gestor.setId(4);
            gestorDAO.delete(gestor);
        }catch (Exception e){
            System.out.println("Gestor não encontrado!");
        }
    }

    @Test
    public void findAllTest() {
        List<Gestor> gestores = gestorDAO.findAll();
        for (Gestor gestor : gestores) {
            if (gestor.getId() == 3) {
                assertEquals("Lucas", gestor.getNome());
            }

        }
    }

    // Método auxiliar para popular o banco
    public List<Gestor> carregaTabelaGestor() {
        List<Gestor> gestores = new ArrayList<>();

        Gestor gestor01 = new Gestor();          
        gestor01.setNome("Maria");
        gestor01.setEmail("maria@gmail.com");
        gestor01.setSenha("12345");

        Gestor gestor02 = new Gestor();          
        gestor02.setNome("Mateus");
        gestor02.setEmail("mateus@gmail.com");
        gestor02.setSenha("12345");
        
        Gestor gestor03 = new Gestor();          
        gestor03.setNome("Lucas");
        gestor03.setEmail("lucas@gmail.com");
        gestor03.setSenha("12345");
        
        gestores.add(gestor01);
        gestores.add(gestor02);
        gestores.add(gestor03);
        
        return gestores;
    }
}



