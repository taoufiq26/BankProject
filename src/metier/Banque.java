package metier;

import java.util.ArrayList;

public class Banque {
	private long id;
	private String nom;
	private String code;
	private ArrayList<Agence> agences;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
