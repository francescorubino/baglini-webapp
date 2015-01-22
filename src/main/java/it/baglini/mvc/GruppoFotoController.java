package it.baglini.mvc;

import it.baglini.model.GruppoFoto;
import it.baglini.service.GruppoFotoService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/gruppofoto")
public class GruppoFotoController {

	@Inject
	private GruppoFotoService gruppoFotoService;
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public GruppoFoto getGruppoFoto(@PathVariable("id") Long id){
		return this.gruppoFotoService.getGruppoFoto(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public GruppoFoto updateFoto(@RequestParam("gruppoFoto") GruppoFoto gruppoFoto) {
		return this.gruppoFotoService.updateGruppoFoto(gruppoFoto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public GruppoFoto createFoto(@RequestParam("gruppoFoto") GruppoFoto gruppoFoto) {
		return this.gruppoFotoService.createGruppoFoto(gruppoFoto);
	}
	
	@RequestMapping(value="list")
	public List<GruppoFoto> getGruppiFoto(Model model){
		return gruppoFotoService.getGruppiFoto();
	}
	
	@RequestMapping(value="/gruppoByNome", method = RequestMethod.GET)
	public List<GruppoFoto> getGruppoFotoByNome(@RequestParam("nome") String nome){
		return this.gruppoFotoService.findByNome(nome);
	}
	
	@RequestMapping(value="/azienda", method=RequestMethod.GET)
	public GruppoFoto getAzienda(){
		return gruppoFotoService.findByNome("azienda").get(0);
	}

	@RequestMapping(value="/servizi", method=RequestMethod.GET)
	public GruppoFoto getServizi(){
		return gruppoFotoService.findByNome("servizi").get(0);
	}
}
