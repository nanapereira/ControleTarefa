package model.daoTest;

import java.time.LocalDate;

import org.junit.Test;

import model.entity.Colaborador;

public class ColaboradorDAOTest {

	@Test
	public void saveTest() {
		Colaborador colaborador = new Colaborador();
		colaborador.setId(1);
		colaborador.setNome("Teste");
		colaborador.setDataNascimento(LocalDate.now());
//		JPAUtil.getEntityManager().persist(colaborador);
	}
}
