package fr.diginamic.banque;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**Représente un client de la banque
 * @author formation
 *
 */
@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/** nom du client */
	@Column(name = "NOM")
	private String nom;
	/** prenom du client */
	@Column(name = "PRENOM")
	private String prenom;
	/** date de naissance du client */
	@Column(name = "DATE_NAISSANCE")
	private LocalDateTime dateNaissance;
	
	@Embedded
	private Adresse adresse;

	
	@ManyToOne
	@JoinColumn(name = "ID_BAN")
	private Banque banque;
	
	@ManyToMany(mappedBy = "clients")
	private Set<Compte> comptes;
	
	
	/** Getter
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/** Setter
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/** Getter
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
	}

	/** Setter
	 * @param comptes the comptes to set
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
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

	/** Getter
	 * @return the dateNaissance
	 */
	public LocalDateTime getDateNaissance() {
		return dateNaissance;
	}

	/** Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDateTime dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/** Getter
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

}
