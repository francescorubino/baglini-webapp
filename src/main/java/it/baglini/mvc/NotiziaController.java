package it.baglini.mvc;

import it.baglini.model.Notizia;
import it.baglini.service.NotiziaService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notizia")
public class NotiziaController {

	@Inject
	private NotiziaService notiziaService;

	@RequestMapping(value = "{idNotizia}", method = RequestMethod.GET)
	public Notizia getNotizia(@PathVariable("idNotizia") Long idNotizia) {
		return this.notiziaService.getNotizia(idNotizia);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Notizia createNotizia(@RequestParam("notizia") Notizia notizia) {
		return this.notiziaService.salvaNotizia(notizia);
	}

	@RequestMapping(value = "list")
	public List<Notizia> getNotizie(Model model) {
		return notiziaService.getNotizie();
	}

	@RequestMapping(value = "findByAnno", method = RequestMethod.GET)
	public List<Notizia> getNotizieByAnno(@RequestParam String anno) {
		return notiziaService.getNotizieByAnno(anno);
	}

	@RequestMapping(value = "findByAnnoAndMese", method = RequestMethod.GET)
	public List<Notizia> getNotizieByAnno(@RequestParam String anno,
			@RequestParam String mese) {
		return notiziaService.getNotizieByAnnoAndMese(anno, mese);
	}

}
