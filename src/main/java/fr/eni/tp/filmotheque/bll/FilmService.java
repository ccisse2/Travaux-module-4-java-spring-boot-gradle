package fr.eni.tp.filmotheque.bll;

import java.util.List;

import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Participant;

public interface FilmService {
	List<Film> consulterFilms();

	Film consulterFilmParId(long id);

	List<Genre> consulterGenres();

	Genre consulterGenreParId(long id);

	List<Participant> consulterParticipants();

	Participant consulterParticipantParId(long id);

	void creerFilm(Film film);

}
