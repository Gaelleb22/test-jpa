package fr.diginamic.banque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**Représente une opération réalisé sur un compte
 * @author formation
 *
 */
@Entity
@Table(name = "operation")
public class Operation {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
	/** date de l'opération */
	@Column(name = "DATE_OP")
	private LocalDateTime dateOp;
	/** montant de l'opération */
	@Column(name = "MONTANT")
	private double montant;
	/** motif */
	@Column(name = "MOTIF")
	private String motif;
	
	
	@ManyToOne
	@JoinColumn(name = "ID_COM")
	private Compte compte;
	
	
	/** Getter
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}
	/** Setter
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	/** Getter
	 * @return the dateOp
	 */
	public LocalDateTime getDateOp() {
		return dateOp;
	}
	/** Setter
	 * @param dateOp the dateOp to set
	 */
	public void setDateOp(LocalDateTime dateOp) {
		this.dateOp = dateOp;
	}
	/** Getter
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}
	/** Setter
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}
	/** Getter
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}
	/** Setter
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

}
