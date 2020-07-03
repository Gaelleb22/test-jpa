package fr.diginamic.banque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**Représente une banque
 * @author formation
 *
 */
@Entity
@Table (name = "banque")
public class Banque {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/** nom de la banque */
	@Column(name = "NOM")
	private String nom;

	
	@OneToMany(mappedBy = "banque")
	private Set<Client> clients;
	
	
	
	/** Getter
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/** Setter
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
