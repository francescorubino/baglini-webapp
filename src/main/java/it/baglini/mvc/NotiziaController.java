package it.baglini.mvc;

import it.baglini.model.Notizia;
import it.baglini.service.NotiziaService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/notizie")
public class NotiziaController {

	@Inject
	private NotiziaService notiziaService;
	
	@RequestMapping(value="list")
	public List<Notizia> getNotizie(Model model){
		return notiziaService.getNotizie();
	}	
	
	@RequestMapping(value="{anno}")
	public List<Notizia> getNotizieByAnno(@PathVariable int anno){
		return notiziaService.getNotizieByAnno(anno);
	}
	
	@RequestMapping(value="{anno}/{mese}")
	public List<Notizia> getNotizieByAnno(@PathVariable int anno, @PathVariable String mese){
		ArrayList<String> mesi = new ArrayList<String>();
		mesi.add("gennaio");
		mesi.add("febbraio");
		mesi.add("marzo");
		mesi.add("aprile");
		mesi.add("maggio");
		mesi.add("giugno");
		mesi.add("luglio");
		mesi.add("agosto");
		mesi.add("settembre");
		mesi.add("ottobre");
		mesi.add("novembre");
		mesi.add("dicembre");
		int meseInt = mesi.indexOf(mese);	
		return notiziaService.getNotizieByAnnoAndMese(anno, meseInt);
	}
	
}
