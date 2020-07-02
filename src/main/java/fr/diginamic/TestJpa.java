package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestJpa {

	/**Tester la connection à la BD compte avec JPA
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compta_pu");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		//Recherche simple
		Livre livre = em.find(Livre.class, 2);
		System.out.println(livre.getTitre()+" à été écrit par "+livre.getAuteur());
		
		//Insertion livre
		Livre livre2 = new Livre();
		livre2.setId(6);
		livre2.setTitre("Le seigneur des anneaux");
		livre2.setAuteur("J.R.R.Tolkien");
 
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(livre2);
		tx.commit();
		
		//Modification livre
		EntityTransaction tx2 = em.getTransaction();
		tx2.begin();
		
		Livre livreModif = em.find(Livre.class, 5);
		livreModif.setTitre("Du plaisir dans la cuisine");
		
		tx2.commit();
		
		//requête JPQL 1
		TypedQuery<Livre> query1 = em.createQuery("select l from Livre l where l.titre = 'Guerre et paix'", Livre.class);
		Livre l2 = query1.getResultList().get(0);
		System.out.println(l2.getTitre()+" à été écrit par "+l2.getAuteur());
		
		//requête JPQL 2
		TypedQuery<Livre> query2 = em.createQuery("select l from Livre l where l.auteur = 'Jules Verne'", Livre.class);
		Livre l3 = query2.getResultList().get(0);
		System.out.println(l3.getTitre()+" à été écrit par "+l3.getAuteur());
		
		//Suppimer un livre
		Livre livreSuppr = em.find(Livre.class, 4);
		EntityTransaction tx3 = em.getTransaction();
		tx3.begin();
		em.remove(livreSuppr);
		tx3.commit();
		
		//Afficher livres
		TypedQuery<Livre> query3 = em.createQuery("select l from Livre l", Livre.class);
		List<Livre> liste = query3.getResultList();
		
		for(Livre l : liste) {
			System.out.println(l.getTitre()+"  de "+l.getAuteur());
		}
		
		em.close();
		
		entityManagerFactory.close();

	}

}
