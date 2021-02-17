package aulajpa.principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import aulajpa.dominio.Pessoa;

public class Principal {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.persist(new Pessoa(null, "Heitor Ramos1", "1heitorhfbr@gmail.com"));
		em.persist(new Pessoa(null, "Heitor Ramos2", "2heitorhfbr@gmail.com"));
		em.persist(new Pessoa(null, "Heitor Ramos3", "3heitorhfbr@gmail.com"));
		em.persist(new Pessoa(null, "Heitor Ramos4", "4heitorhfbr@gmail.com"));
		em.persist(new Pessoa(null, "Heitor Ramos5", "5heitorhfbr@gmail.com"));
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		Pessoa p = em.find(Pessoa.class, 1);
		
		em.remove(p);
	
		
		em.getTransaction().begin();;
		em.getTransaction().commit();
		
		System.out.println(p);
		p = em.find(Pessoa.class, 2);
		em.remove(p);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		emf.close();
		em.close();
	}

}
