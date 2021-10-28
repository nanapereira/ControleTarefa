package test;

import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import factory.JPAUtil;
import model.dao.ColaboradorDAO;

@RunWith(MockitoJUnitRunner.class)
public class ColaboradorDAOTestMock {

	EntityManager entityManager = JPAUtil.getEntityManager();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Mock
	ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);

//	@Test
//	public void deleteTeste() {
//		Colaborador colaborador = new Colaborador();
//		colaborador.setId(4);
//		colaboradorDAO.delete(colaborador);
//		Mockito.verify(colaboradorDAO, Mockito.times(1)).delete(colaborador);
//	}

}
