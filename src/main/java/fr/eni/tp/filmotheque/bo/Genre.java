package fr.eni.tp.filmotheque.bo;

import java.io.Serializable;
import java.util.Objects;

/**
 * BO - Design Pattern POJO (Plained Old Java Object)
 * 
 * Constructeur sans paramètre
 * 
 * Getter/Setter
 * 
 * toString
 * 
 * Equals
 * 
 * Spring - Implementer Serializable
 */
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String titre;

	public Genre() {
	}

	public Genre(long id, String titre) {
		this.id = id;
		this.titre = titre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(titre);
		builder.append(" (");
		builder.append(id);
		builder.append(")");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, titre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		return id == other.id && Objects.equals(titre, other.titre);
	}

}
