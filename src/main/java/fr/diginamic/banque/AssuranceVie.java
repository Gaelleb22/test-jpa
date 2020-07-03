package fr.diginamic.banque;

import java.time.LocalDate;

import javax.persistence.Entity;

/**Représente un compte de type Assurance Vie
 * @author formation
 *
 */
@Entity
public class AssuranceVie extends Compte {
	
	/** date de fin du contrat */
	private LocalDate dateFin;
	/** taux */
	private double taux;
	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	/** Getter
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}
	/** Setter
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

}
