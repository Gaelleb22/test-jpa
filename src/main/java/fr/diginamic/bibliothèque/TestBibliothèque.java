package fr.diginamic.bibliothèque;

import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**Tester les relations entres les classes emprunt, client et livre
 * @author formation
 *
 */
public class TestBibliothèque {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio_pu");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//1ère requête
		TypedQuery<Emprunt> query1 = em.createQuery("select e from Emprunt e where e.id = 1", Emprunt.class);
		Emprunt emprunt = query1.getSingleResult();
		
		DateTimeFormatter formatteur = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println(" -> Emprunté le : " + emprunt.getDateDebut().format(formatteur) 
		+ " par " +emprunt.getClient().getNom() + " "+emprunt.getClient().getPrenom());
		for(Livre livre : emprunt.getLivres()) {
			System.out.println(livre.getTitre() + " de " +livre.getAuteur());
		}
		System.out.println("Rendu le : " + emprunt.getDateFin().format(formatteur));
		tx.commit();
		
		//2ème requête
		EntityTransaction tx2 = em.getTransaction();
		tx2.begin();
		TypedQuery<Client> query2 = em.createQuery("select c from Client c where c.nom = 'BERRAD'", Client.class);
		Client client = query2.getSingleResult();
		
		client.getEmprunt().forEach(System.out :: println);
		
		tx2.commit();
		
		em.close();
		entityManagerFactory.close();

	}

}
