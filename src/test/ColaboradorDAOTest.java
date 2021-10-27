package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

import org.junit.Test;

import factory.JPAUtil;
import model.entity.Colaborador;

public class ColaboradorDAOTest {

	@PersistenceUnit
	JPAUtil jaJpaUtil;

	EntityManager entityManager = JPAUtil.getEntityManager();

	@Test
	public void saveTest() {
		Colaborador colaborador = new Colaborador();
		colaborador.setId(1);
		colaborador.setNome("Teste");
		colaborador.setDataNascimento(LocalDate.now());
		entityManager.persist(colaborador);
	}
}
