package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Tarefa;

public class RemoverTarefa {
	public static void main(String[] args) {
		Tarefa tarefa1 = new Tarefa();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
//		tarefa1.setId(1L);
		tarefa1 = manager.find(Tarefa.class, 2L);
		
		manager.getTransaction().begin(); //inicializar a transação
		manager.remove(tarefa1); //linha que faz o hibernate excluir um objeto no banco
		manager.getTransaction().commit(); //Encerramento da transação
		
		manager.close();
		factory.close();
	}

}
