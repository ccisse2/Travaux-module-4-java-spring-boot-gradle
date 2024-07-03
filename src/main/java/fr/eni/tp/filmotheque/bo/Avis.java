package fr.eni.tp.filmotheque.bo;

import java.io.Serializable;
import java.util.Objects;

public class Avis implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private int note;
	private String commentaire;

	// Association avec Membre
	private Membre membre;

	public Avis() {
	}

	public Avis(int note, String commentaire, Membre membre) {
		this.note = note;
		this.commentaire = commentaire;
		this.membre = membre;
	}

	public Avis(long id, int note, String commentaire, Membre membre) {
		this.id = id;
		this.note = note;
		this.commentaire = commentaire;
		this.membre = membre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Avis de ");
		builder.append(membre.toString());
		builder.append(" - note=");
		builder.append(note);
		builder.append(", commentaire=");
		builder.append(commentaire);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avis other = (Avis) obj;
		return id == other.id;
	}

}
