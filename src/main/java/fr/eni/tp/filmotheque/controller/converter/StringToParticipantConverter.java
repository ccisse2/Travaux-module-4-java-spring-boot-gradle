package fr.eni.tp.filmotheque.controller.converter;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToParticipantConverter implements Converter<String, Participant> {
    private FilmService filmService;

    @Autowired
    public StringToParticipantConverter(FilmService filmService) {
        this.filmService = filmService;
    }

    @Override
    public Participant convert(String id) {
        Integer idInt = Integer.parseInt(id);
        return filmService.consulterParticipantParId(idInt);
    }
}
