package fr.eni.tp.filmotheque.controller;

import java.util.List;

import fr.eni.tp.filmotheque.bo.Genre;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/films")
@SessionAttributes({"genresSession", "membreEnSession", "realisateurs", "acteurs"})
public class FilmController {
	private FilmService filmService;

	@Autowired
	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@ModelAttribute("realisateurs")
	public List<Participant> chargerRealisateurs() {
		System.out.println("charger realisateurs");
		return filmService.consulterParticipants();
	}

	@ModelAttribute("acteurs")
	public List<Participant> chargerActeurs() {
		System.out.println("charger acteurs");
		return filmService.consulterParticipants();
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
		model.addAttribute("film", new Film());
        return "view-film-creer";
	}

	//Creer un film
	@PostMapping("/creer")
	public String creerFilm(@ModelAttribute Film film) {
		filmService.creerFilm(film);
		return "redirect:/films";
	}
}
