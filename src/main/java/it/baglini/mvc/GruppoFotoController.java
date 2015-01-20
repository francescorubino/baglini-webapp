package it.baglini.mvc;

import it.baglini.model.Foto;
import it.baglini.model.GruppoFoto;
import it.baglini.repository.FotoRepository;
import it.baglini.service.GruppoFotoService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/foto")
public class GruppoFotoController {

	@Inject
	private GruppoFotoService gruppoFotoService;
	
	@Inject
	private FotoRepository fotoRepository;
	
	@RequestMapping(value="list")
	public List<GruppoFoto> getArticoli(Model model){
		return gruppoFotoService.getGruppiFoto();
	}
	
	@RequestMapping(value="{nome}")
	public List<Foto> getFotosByGruppoFotoId(@PathVariable String nome){
		GruppoFoto g = gruppoFotoService.findByNome(nome);
		return fotoRepository.findByGruppoFoto_Id(g.getId());
	}
	
}
