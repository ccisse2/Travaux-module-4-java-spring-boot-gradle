package fr.eni.tp.filmotheque.controller;

import java.util.List;

import fr.eni.tp.filmotheque.bo.Genre;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/films")
@SessionAttributes({"genresSession", "membreEnSession"})
public class FilmController {
	private FilmService filmService;

	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@ModelAttribute("genresSession")
	public List<Genre> chargerGenresSession() {
		System.out.println("chargerGenresSession");
		return filmService.consulterGenres();
    }

	@GetMapping
	public String afficherFilms(Model model) {
		List<Film> films = filmService.consulterFilms();
		model.addAttribute("films", films);
		return "view-films";
	}

	@GetMapping("/detail")
	public String afficherUnFilm(@RequestParam long id, Model model) {
		Film film = filmService.consulterFilmParId(id);
		model.addAttribute("film", film);
		return "view-film-detail";
	}

	@GetMapping("/creer")
	public String creerFilm(Model model) {
        return "view-film-creer";
	}
}
