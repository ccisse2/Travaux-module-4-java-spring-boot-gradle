package fr.eni.tp.filmotheque.controller.contexte;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/avis")
@SessionAttributes("membreEnSession")
public class AvisController {
    private final FilmService filmService;

    @Autowired
    public AvisController(FilmService filmService) {
        this.filmService = filmService;
    }

    // Creer un avis
    @GetMapping("/creer")
    public String creerAvis(@RequestParam("idFilm") Long filmId, Model model) {
        Film film = filmService.consulterFilmParId(filmId);
        model.addAttribute("film", film);
        return "view-avis-creer"; // Redirige vers la page de creation d'avis
    }

    // Envoyer un avis
    @PostMapping("/creer")
    public String creerAvis(
            @RequestParam("idFilm") Long filmId,
            @RequestParam("commentaire") String commentaire,
            @RequestParam("note") int note,
            @ModelAttribute("membreEnSession") Membre membre) {
        Film film = filmService.consulterFilmParId(filmId);
        Avis avis = new Avis(note, commentaire, membre);
        filmService.publierAvis(avis, filmId);
        return "redirect:/films/detail?id=" + filmId; // Redirige vers la page du film après publication de l'avis
    }
}
