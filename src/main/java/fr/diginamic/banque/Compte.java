package fr.diginamic.banque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**Représente un compte bancaire
 * @author formation
 *
 */
@Entity
@Table (name = "compte")
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/** numero du compte */
	@Column(name = "NUMERO")
	private String numero;
	/** solde du compte */
	@Column(name = "SOLDE")
	private double solde;
	
	@ManyToMany
	@JoinTable(name = "CLI_COM", 
		joinColumns = @JoinColumn(name = "ID_COM", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"))
	private Set<Client> clients;
	
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/** Getter
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}
	/** Setter
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

}
