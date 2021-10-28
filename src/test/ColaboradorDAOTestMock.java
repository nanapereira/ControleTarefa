package test;

import javax.persistence.EntityManager;

import model.entity.Colaborador;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import factory.JPAUtil;
import model.dao.ColaboradorDAO;


import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class ColaboradorDAOTestMock {

    EntityManager entityManager = JPAUtil.getEntityManager();

    @Mock
    ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);

    @InjectMocks
    Colaborador colaborador = new Colaborador();

    @Test
    public void deleteTeste() {
        doNothing().when(colaboradorDAO).delete(colaborador);
    }

}
