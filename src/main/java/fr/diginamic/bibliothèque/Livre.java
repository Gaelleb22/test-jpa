package fr.diginamic.bibliothèque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**Repr�sente une entit� livre
 * @author formation
 *
 */
@Entity
@Table (name = "livre")
public class Livre {
	
	@Id
	private int id;
	@Column (name = "AUTEUR")
	private String auteur;
	@Column (name = "TITRE")
	private String titre;
	
	@ManyToMany(mappedBy = "livres")
	private Set<Emprunt> emprunts;

	/** Getter
	 * @return the emprunts
	 */
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	/** Setter
	 * @param emprunts the emprunts to set
	 */
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	/** Getter
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/** Setter
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/** Getter
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/** Setter
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
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

}
