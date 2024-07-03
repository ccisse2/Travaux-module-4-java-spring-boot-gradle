package fr.eni.tp.filmotheque.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String titre;
	private int annee;
	private int duree;
	private String synopsis;

	// Association avec Participant - realisateur
	private Participant realisateur;

	// Association avec Participant - acteurs
	private List<Participant> acteurs;

	// Association avec Genre - genre
	private Genre genre;

	// Association Avis
	private List<Avis> avis;

	public Film() {
		acteurs = new ArrayList<>();
		avis = new ArrayList<>();
	}

	public Film(long id, String titre, int annee, int duree, String synopsis) {
		this();
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
	}

	public Film(String titre, int annee, int duree, String synopsis, Participant realisateur, List<Participant> acteurs,
			Genre genre, List<Avis> avis) {
		this();
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		this.realisateur = realisateur;
		this.acteurs = acteurs;
		this.genre = genre;
		this.avis = avis;
	}

	public Film(long id, String titre, int annee, int duree, String synopsis, Participant realisateur,
			List<Participant> acteurs, Genre genre, List<Avis> avis) {
		this();
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		this.realisateur = realisateur;
		this.acteurs = acteurs;
		this.genre = genre;
		this.avis = avis;
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

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Participant getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Participant realisateur) {
		this.realisateur = realisateur;
	}

	public List<Participant> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Participant> acteurs) {
		this.acteurs = acteurs;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film (");
		builder.append(id);
		builder.append(")\n\tTitre : ");
		builder.append(titre);
		builder.append(" [annee :");
		builder.append(annee);
		builder.append(", duree : ");
		builder.append(duree);
		builder.append(" minutes]");
		builder.append("\n\tSynopsis : ");
		builder.append(synopsis);
		builder.append("\n\tRealisateur : ");
		builder.append(realisateur);
		builder.append("\n\tActeurs : ");
		builder.append(acteurs);
		builder.append("\n\tGenre : ");
		builder.append(genre);
		builder.append("\n\tAvis : ");
		builder.append(avis);
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
		Film other = (Film) obj;
		return id == other.id && Objects.equals(titre, other.titre);
	}

}
