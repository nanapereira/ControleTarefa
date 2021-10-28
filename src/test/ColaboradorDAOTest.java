package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import factory.JPAUtil;
import model.entity.Colaborador;

public class ColaboradorDAOTest {

	EntityManager entityManager = JPAUtil.getEntityManager();
    private static final DateTimeFormatter formatterLocalDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//	ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);

//	@Before
//	public void before() {
//		entityManager.getTransaction().begin();
//	}
//
//	@After
//	public void after() {
//		entityManager.getTransaction().commit();
//	}

//	@Test
//	public void saveTest() {
//		List<Colaborador> colaboradores = carregaTabelaColaborador();
//		for (Colaborador colaborador : colaboradores) {
//			colaboradorDAO.save(colaborador);
//		}
//	}

//    @Test
//	public void updateTest() {
//		ColaboradorDAO colaboradorDAO = new ColaboradorDAO(entityManager);
//        Colaborador colaborador = colaboradorDAO.findById(2);
//
//        colaborador.setNome("Pedro Joao");
//        colaborador.setEmail("pedro.joao@gmail.com");
//        colaborador.setSenha(Encrypt.encryption("12345"));
//        colaborador.setDataNascimento(LocalDate.parse("25/10/1990", ColaboradorDAOTest.formatterLocalDate));
//
//        //inicia a transa√ßao com o BD
//        entityManager.getTransaction().begin();
//
//        colaboradorDAO.update(colaborador);
//
//        //comita
//        entityManager.getTransaction().commit();
//
//        System.out.println("Colaborador Alterado!");
//        System.out.println(colaborador);
//	}

//	@Test
//	public void deleteTest() {
//		Colaborador colaborador = new Colaborador();
//		colaborador.setId(3);
//		colaboradorDAO.delete(colaborador);
//	}

//	@Test
//	public void findByIdTest() {
//		Colaborador colaborador = colaboradorDAO.findById(3);
//		assertEquals("ana@gmail.com", colaborador.getEmail());
//	}

//	@Test
//	public void findAllTest() {
//		List<Colaborador> colaboradores = carregaTabelaColaborador();
//	}

/////////////////////////////MÈtodo Auxiliar////////////////////
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
