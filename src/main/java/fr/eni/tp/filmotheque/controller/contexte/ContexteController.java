package fr.eni.tp.filmotheque.controller.contexte;


import fr.eni.tp.filmotheque.bll.contexte.ContexteService;
import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/contexte")
@SessionAttributes("membreEnSession")
public class ContexteController {
    private ContexteService contexteService;

    @Autowired
    public ContexteController(ContexteService contexteService) {
        this.contexteService = contexteService;
    }

    @ModelAttribute("membreEnSession")
    public Membre membreEnSession() {
        return new Membre();
    }

    @GetMapping
    public String choixContexte() {
        return "contexte/view-contexte";
    }

    @GetMapping("/session")
    public String connexion(
            @ModelAttribute("membreEnSession") Membre membreEnSession,
            @RequestParam(name = "email", required = false, defaultValue = "jtrillard@campus-eni.fr") String email) {
        System.out.println("Email: " + email);
        Membre aCharger = contexteService.charger(email);
        System.out.println(aCharger);
        if (aCharger != null) {
            membreEnSession.setId(aCharger.getId());
            membreEnSession.setNom(aCharger.getNom());
            membreEnSession.setPrenom(aCharger.getPrenom());
            membreEnSession.setPseudo(aCharger.getPseudo());
            membreEnSession.setAdmin(aCharger.isAdmin());
            System.out.println("c'est cool tes pas null");
        } else {
            membreEnSession.setId(0);
            membreEnSession.setNom("null");
            membreEnSession.setPrenom(null);
            membreEnSession.setPseudo("null");
            membreEnSession.setAdmin(false);
        }
        System.out.println(membreEnSession);
        return "redirect:/films";
    }

    @GetMapping("/cloture")
    public String finSession(SessionStatus status) {
        status.setComplete();
        return "redirect:/films";
    }
}
