package orm.actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.modelo.Tarefa;

public class BuscaTarefasPorLetra {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		//Query em JPQL que é traduzida para o SQL do banco definido persistence.xml
		
	//	Query query = manager.createQuery("select t from Tarefa as t where t.finalizado =:paramFinalizado");
	//	query.setParameter("paramFinalizado", true);
		
	//	Query query = manager.createQuery("select t from Tarefa as t where t.descricao =:descricaobuscada");
	//	query.setParameter("descricaobuscada", "zarefa");
		
		Query query = manager.createQuery("select t from Tarefa as t where t.descricao LIKE :letraBuscada");
        query.setParameter("letraBuscada", "e%"); // "%" indica que a descrição deve começar com "z"
		
		List<Tarefa> lista = query.getResultList();
		
		for (Tarefa t : lista) {
			System.out.println(t.getDescricao() + t.getId());
		}
		
		manager.close();
		factory.close();
		
	}

}
