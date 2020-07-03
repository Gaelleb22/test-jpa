package fr.diginamic.banque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**Représente un compte bancaire
 * @author formation
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/** numero du compte */
	@Column(name = "NUMERO", unique = true)
	private String numero;
	/** solde du compte */
	@Column(name = "SOLDE")
	private double solde;
	
	@ManyToMany
	@JoinTable(name = "CLI_COM", 
		joinColumns = @JoinColumn(name = "ID_COM", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"))
	private Set<Client> clients;
	
	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations;
	
	
	
	/** Getter
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}
	/** Setter
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	/** Getter
	 * @return the operations
	 */
	public Set<Operation> getOperations() {
		return operations;
	}
	/** Setter
	 * @param operations the operations to set
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
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
