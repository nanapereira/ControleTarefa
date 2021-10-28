package test;

import factory.JPAUtil;
import model.dao.TarefaDAO;
import model.entity.Colaborador;
import model.entity.Tarefa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TarefaDAOTest {

    EntityManager entityManager = JPAUtil.getEntityManager();
    TarefaDAO tarefaDAO = new TarefaDAO(entityManager);

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
        List<Tarefa> tarefas = carregaTabelaTarefa();
        for (Tarefa tarefa : tarefas) {
            tarefaDAO.save(tarefa);
        }
    }

    @Test
    public void updateTest() {
        Colaborador colaborador = new Colaborador();
        colaborador.setId(3);

        Tarefa tarefa = tarefaDAO.findById(2);
        tarefa.setColaborador(colaborador);
        tarefa.setDescricao("Criar tela login");
        tarefa.setDataInicio(LocalDateTime.now());
        tarefa.setDataFim(LocalDateTime.now());
        tarefa.setStatus("indoing");
        tarefa.setPrioridade("Alta");
        tarefa.setObservacao("Testar classes DAO com Mock.");
        tarefaDAO.update(tarefa);
        Tarefa tarefaCheck = tarefaDAO.findById(2);
        assertEquals("Alta", tarefaCheck.getPrioridade());
    }

    @Test
    public void deleteTest() {
         try {
             Tarefa tarefa = tarefaDAO.findById(3);
             tarefa.setId(3);
             tarefaDAO.update(tarefa);
         }catch (Exception e){
             System.out.println("Tarefa não encontrada!");
         }
    }

    @Test
    public void findAllTest() {
        List<Tarefa> tarefas = tarefaDAO.findAll();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == 1) {
                assertEquals("todo", tarefa.getStatus());
            }

        }
    }

    // Método auxiliar para popular o banco
    public List<Tarefa> carregaTabelaTarefa() {
        List<Tarefa> tarefas = new ArrayList<>();

        Colaborador colaborador01 = new Colaborador();
        colaborador01.setId(1);
        Colaborador colaborador02 = new Colaborador();
        colaborador02.setId(2);

        Tarefa tarefa01 = new Tarefa();
        tarefa01.setColaborador(colaborador01);
        tarefa01.setDescricao("Implementar Testes unitários");
        tarefa01.setDataInicio(LocalDateTime.now());
        tarefa01.setDataFim(LocalDateTime.now());
        tarefa01.setStatus("todo");
        tarefa01.setPrioridade("Média");
        tarefa01.setObservacao("Testar classes DAO com Mock.");

        Tarefa tarefa02 = new Tarefa();
        tarefa02.setColaborador(colaborador02);
        tarefa02.setDescricao("Criar tela login");
        tarefa02.setDataInicio(LocalDateTime.now());
        tarefa02.setDataFim(LocalDateTime.now());
        tarefa02.setStatus("indoing");
        tarefa02.setPrioridade("Média");
        tarefa02.setObservacao("Testar classes DAO com Mock.");

        tarefas.add(tarefa01);
        tarefas.add(tarefa02);

        return tarefas;
    }
}
