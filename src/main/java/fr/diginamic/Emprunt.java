package fr.diginamic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**Repr�sente un emprunt effectu� par un client
 * @author formation
 *
 */
@Entity
@Table (name = "emprunt")
public class Emprunt {
	
	@Id
	private int id;
	@Column (name = "DELAI")
	private int delai;
	@Column (name = "DATE_DEBUT")
	private LocalDateTime dateDebut;
	@Column (name = "DATE_FIN")
	private LocalDateTime dateFin;
	
	@ManyToOne
	@JoinColumn (name = "ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable (name = "compo", 
		joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private Set<Livre> livres;
	
	/** Getter
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/** Setter
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/** Getter
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}
	/** Setter
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
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
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}
	/** Setter
	 * @param delai the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}
	
	/** Getter
	 * @return the dateDebut
	 */
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}
	/** Setter
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}
	/** Getter
	 * @return the dateFin
	 */
	public LocalDateTime getDateFin() {
		return dateFin;
	}
	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}
	@Override
	public String toString() {
		return "Emprunt effectué le : " + dateDebut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " par " + client.getNom() + " " + client.getPrenom();
	}

}
