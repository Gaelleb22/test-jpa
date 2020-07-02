package fr.diginamic.Bibliothèque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**Repr�sente un client de la bilbioth�que
 * @author formation
 *
 */
@Entity
@Table (name = "client")
public class Client {
	
	@Id
	private int id;
	@Column (name = "NOM")
	private String nom;
	@Column (name = "PRENOM")
	private String prenom;
	
	@OneToMany (mappedBy = "client")
	private Set<Emprunt> emprunt;
	
	/** Getter
	 * @return the emprunt
	 */
	public Set<Emprunt> getEmprunt() {
		return emprunt;
	}
	/** Setter
	 * @param emprunt the emprunt to set
	 */
	public void setEmprunt(Set<Emprunt> emprunt) {
		this.emprunt = emprunt;
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
	/** Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
