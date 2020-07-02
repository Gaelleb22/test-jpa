package fr.diginamic.banque;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**Représente l'adresse d'un client
 * @author formation
 *
 */
@Embeddable
public class Adresse {
	
	/** numero de rue */
	@Column(name = "NUMERO")
	private int numero;
	/** nom de la rue */
	@Column(name = "RUE")
	private String rue;
	/** code postal de la ville */
	@Column(name = "CODE_POSTAL")
	private int codePostal;
	/** ville */
	@Column(name = "VILLE")
	private String ville;
	
	/** Getter
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/** Getter
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}
	/** Setter
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/** Getter
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}
	/** Setter
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	/** Getter
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/** Setter
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

}
