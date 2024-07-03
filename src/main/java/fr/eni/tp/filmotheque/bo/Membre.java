package fr.eni.tp.filmotheque.bo;

import java.util.Objects;

public class Membre extends Personne {

	private static final long serialVersionUID = 1L;

	private String pseudo;
	private String motDePasse;
	private boolean admin;

	public Membre() {
	}

	public Membre(String nom, String prenom, String pseudo, String motDePasse, boolean admin) {
		super(nom, prenom);
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}

	public Membre(long id, String nom, String prenom, String pseudo, String motDePasse) {
		super(id, nom, prenom);
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
	}

	public Membre(long id, String nom, String prenom, String pseudo, String motDePasse, boolean admin) {
		super(id, nom, prenom);
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		
		builder.append(" - Membre (pseudo=");
		builder.append(pseudo);
		builder.append(", admin=");
		builder.append(admin);
		builder.append(")");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(pseudo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membre other = (Membre) obj;
		return Objects.equals(pseudo, other.pseudo);
	}

}
