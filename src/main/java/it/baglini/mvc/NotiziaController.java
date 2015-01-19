package it.baglini.mvc;

import it.baglini.model.Notizia;
import it.baglini.service.NotiziaService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/notizia")
public class NotiziaController {

	@Inject
	private NotiziaService notiziaService;
	
	@RequestMapping(value="list")
	public List<Notizia> getArticoli(Model model){
		return notiziaService.getNotizie();
	}
	
}
