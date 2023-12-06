package orm.actions;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Tarefa;

public class InserirTarefa {
	public static void main(String[] args) {
		Tarefa tarefa1 = new Tarefa();
		tarefa1.setDescricao("zarefa");
		tarefa1.setFinalizado(false);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin(); //inicializar a transação
		manager.persist(tarefa1); //linha que faz o hibernate inserir um objeto no banco
		manager.getTransaction().commit(); //Encerramento da transação
		
		manager.close();
		factory.close();
	}

}
