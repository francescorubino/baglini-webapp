package it.baglini.mvc;

import it.baglini.model.Foto;
import it.baglini.service.FotoService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/foto")
public class FotoController {

	@Inject
	private FotoService fotoService;

	@RequestMapping(value = "{idFoto}", method = RequestMethod.GET)
	public Foto getFoto(@PathVariable("idFoto") Long idFoto) {
		return this.fotoService.getFoto(idFoto);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Foto updateFoto(@RequestParam("foto") Foto foto) {
		return this.fotoService.updateFoto(foto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Foto createFoto(@RequestParam("foto") Foto foto) {
		return this.fotoService.createFoto(foto);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Foto> findAll() {
		return this.fotoService.getFotos();
	}

	@RequestMapping(value = "/findByGroup", method = RequestMethod.GET)
	public List<Foto> findByIdGruppo(@RequestParam("idGruppo") Long idGruppo) {
		return this.fotoService.findByIdGruppo(idGruppo);
	}

	@RequestMapping(value = "/findByName", method = RequestMethod.GET)
	public List<Foto> findByName(@RequestParam("nome") String nome) {
		return this.fotoService.findByNome(nome);
	}
}
