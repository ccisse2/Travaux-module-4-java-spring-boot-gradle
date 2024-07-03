package fr.eni.tp.filmotheque.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/films")
public class FilmController {

	private FilmService filmService;

	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@GetMapping
	public String afficherFilms(Model model) {
		List<Film> films = filmService.consulterFilms();
		model.addAttribute("films", films);
		System.out.println("\nTous les films :");
		return "view-films";
	}

	@GetMapping("/detail")
	public String afficherUnFilm(@RequestParam long id, Model model) {
		Film film = filmService.consulterFilmParId(id);
		model.addAttribute("film", film);
		return "view-film-detail";
	}
}
