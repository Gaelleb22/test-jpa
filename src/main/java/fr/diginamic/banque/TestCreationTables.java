package fr.diginamic.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**Création des tables de la BD banque avec entré de donnée
 * @author formation
 *
 */
public class TestCreationTables {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque_pu");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Banque banque = new Banque();
		banque.setNom("Mondial Credit");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(banque);
		tx.commit();
		
		
		Client client1 = new Client();
		client1.setNom("Petroski");
		client1.setPrenom("Dimitri");
		client1.setDateNaissance(LocalDateTime.parse("1970-09-03T00:00:00"));
		Adresse adressse1 = new Adresse();
		adressse1.setNumero(10);
		adressse1.setRue("Rue des Coquelicot");
		adressse1.setCodePostal(59290);
		adressse1.setVille("Wasquehal");
		client1.setAdresse(adressse1);
		client1.setBanque(banque);
		EntityTransaction tx2 = em.getTransaction();
		tx2.begin();
		em.persist(client1);
		tx2.commit();
		
		
		Client client2 = new Client();
		client2.setNom("Tanaka");
		client2.setPrenom("Ikemi");
		client2.setDateNaissance(LocalDateTime.parse("1992-03-15T00:00:00"));
		Adresse adressse2 = new Adresse();
		adressse2.setNumero(5);
		adressse2.setRue("Avenue de la mer");
		adressse2.setCodePostal(35802);
		adressse2.setVille("Dinard");
		client2.setAdresse(adressse2);
		client2.setBanque(banque);
		EntityTransaction tx3 = em.getTransaction();
		tx3.begin();
		em.persist(client2);
		tx3.commit();
		
		
		Client client3 = new Client();
		client3.setNom("François");
		client3.setPrenom("Etienne");
		client3.setDateNaissance(LocalDateTime.parse("1986-01-26T00:00:00"));
		Adresse adressse3 = new Adresse();
		adressse3.setNumero(7);
		adressse3.setRue("Allée de la Mine");
		adressse3.setCodePostal(42000);
		adressse3.setVille("Saint-Etienne");
		client3.setAdresse(adressse3);
		client3.setBanque(banque);
		EntityTransaction tx4 = em.getTransaction();
		tx4.begin();
		em.persist(client3);
		tx4.commit();
		
		Client client4 = new Client();
		client4.setNom("Tanaka");
		client4.setPrenom("Shinichi");
		client4.setDateNaissance(LocalDateTime.parse("1990-05-12T00:00:00"));
		client4.setAdresse(adressse2);
		client4.setBanque(banque);
		EntityTransaction tx19 = em.getTransaction();
		tx19.begin();
		em.persist(client4);
		tx19.commit();
		
		
		AssuranceVie compte1 = new AssuranceVie();
		compte1.setNumero("78953001");
		compte1.setSolde(7802.20);
		compte1.setDateFin(LocalDate.of(2060, 12, 30));
		compte1.setTaux(2.3);
		Set<Client> set1 = new HashSet<>();
		set1.add(client1);
		compte1.setClients(set1);
		EntityTransaction tx5 = em.getTransaction();
		tx5.begin();
		em.persist(compte1);
		tx5.commit();
		
		LivretA compte2 = new LivretA();
		compte2.setNumero("78953002");
		compte2.setSolde(360.00);
		compte2.setTaux(0.5);
		compte2.setClients(set1);
		EntityTransaction tx6 = em.getTransaction();
		tx6.begin();
		em.persist(compte2);
		tx6.commit();
		
		AssuranceVie compte3 = new AssuranceVie();
		compte3.setNumero("78953003");
		compte3.setDateFin(LocalDate.of(2070, 12, 31));
		compte3.setSolde(4005.50);
		compte3.setTaux(2.3);
		Set<Client> set2 = new HashSet<>();
		set2.add(client2);
		set2.add(client4);
		compte3.setClients(set2);
		EntityTransaction tx7 = em.getTransaction();
		tx7.begin();
		em.persist(compte3);
		tx7.commit();
		
		LivretA compte4 = new LivretA();
		compte4.setNumero("78953004");
		compte4.setSolde(273.61);
		compte4.setTaux(0.5);
		Set<Client> set3 = new HashSet<>();
		set3.add(client3);
		compte4.setClients(set3);
		EntityTransaction tx8 = em.getTransaction();
		tx8.begin();
		em.persist(compte4);
		tx8.commit();
		
		Operation operation1 = new Operation();
		operation1.setCompte(compte1);
		operation1.setDateOp(LocalDateTime.parse("2020-07-02T00:00:00"));
		operation1.setMontant(500);
		EntityTransaction tx9 = em.getTransaction();
		tx9.begin();
		em.persist(operation1);
		tx9.commit();
		
		Virement operation2 = new Virement();
		operation2.setCompte(compte2);
		operation2.setMontant(-700);
		operation2.setDateOp(LocalDateTime.parse("2020-07-02T00:00:00"));
		operation2.setMotif("Loyer");
		operation2.setBeneficiaire("Propriétaire");
		EntityTransaction tx10 = em.getTransaction();
		tx10.begin();
		em.persist(operation2);
		tx10.commit();
		
		Operation operation3 = new Operation();
		operation3.setCompte(compte4);
		operation3.setDateOp(LocalDateTime.parse("2020-07-02T00:00:00"));
		operation3.setMontant(25.00);
		operation3.setMotif("achat");
		EntityTransaction tx11 = em.getTransaction();
		tx11.begin();
		em.persist(operation3);
		tx11.commit();
		
		EntityTransaction tx12 = em.getTransaction();
		tx12.begin();
		Set<Client> clients = new HashSet<>();
		clients.add(client1);
		clients.add(client2);
		clients.add(client3);
		clients.add(client4);
		banque.setClients(clients);
		tx12.commit();
		
		EntityTransaction tx13 = em.getTransaction();
		tx13.begin();
		Set<Compte> comptesClient1 = new HashSet<>();
		comptesClient1.add(compte1);
		comptesClient1.add(compte2);
		client1.setComptes(comptesClient1);
		tx13.commit();
		
		EntityTransaction tx14 = em.getTransaction();
		tx14.begin();
		Set<Compte> comptesClient2 = new HashSet<>();
		comptesClient2.add(compte3);
		client4.setComptes(comptesClient2);
		tx14.commit();
		
		EntityTransaction tx15 = em.getTransaction();
		tx15.begin();
		Set<Compte> comptesClient3 = new HashSet<>();
		comptesClient3.add(compte4);
		client3.setComptes(comptesClient3);
		tx15.commit();
		
		
		EntityTransaction tx16 = em.getTransaction();
		tx16.begin();
		Set<Operation> operationsCompte1 = new HashSet<>();
		operationsCompte1.add(operation1);
		compte1.setOperations(operationsCompte1);;
		tx16.commit();
		
		EntityTransaction tx17 = em.getTransaction();
		tx17.begin();
		Set<Operation> operationsCompte2 = new HashSet<>();
		operationsCompte2.add(operation2);
		compte2.setOperations(operationsCompte2);;
		tx17.commit();
		
		EntityTransaction tx18 = em.getTransaction();
		tx18.begin();
		Set<Operation> operationsCompte4 = new HashSet<>();
		operationsCompte4.add(operation3);
		compte4.setOperations(operationsCompte4);;
		tx18.commit();
		
		
		
		em.close();
		entityManagerFactory.close();

	}

}
