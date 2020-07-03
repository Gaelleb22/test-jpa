package fr.diginamic.banque;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**Représente une opération de type virement
 * @author formation
 *
 */
@Entity
@DiscriminatorValue("V")
public class Virement extends Operation {
	
	/** beneficiaire */
	@Column(name = "BENEFICIAIRE")
	private String beneficiaire;

	/** Getter
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/** Setter
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
