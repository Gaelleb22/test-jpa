package fr.diginamic.banque;

import javax.persistence.Entity;

/**Représente un compte de type livret A
 * @author formation
 *
 */
@Entity
public class LivretA extends Compte {
	
	/** taux */
	private double taux;

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
