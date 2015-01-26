package it.baglini.mvc;

import it.baglini.model.Sezione;
import it.baglini.service.SezioneService;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/sezione")
public class SezioneController {

	@Inject
	private SezioneService sezioneService;

	@RequestMapping(value = "{idSezione}", method = RequestMethod.GET)
	public Sezione getSezione(@PathVariable("idSezione") Long idSezione) {
		return this.sezioneService.getSezione(idSezione);
	}
}
