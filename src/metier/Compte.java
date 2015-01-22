package metier;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Compte {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private Date updatedAt;
	private Date createdAt;
	private String code;
	private String maxDecouvert;
	private Double solde;
	@ManyToOne
	private Client client;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public String getMaxDecouvert() {
		return maxDecouvert;
	}
	public void setMaxDecouvert(String maxDecouvert) {
		this.maxDecouvert = maxDecouvert;
	}
	
	
	
}
