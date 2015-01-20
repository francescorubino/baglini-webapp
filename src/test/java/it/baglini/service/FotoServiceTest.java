package it.baglini.service;

import it.baglini.BagliniWebappApplication;
import it.baglini.model.Foto;
import it.baglini.model.GruppoFoto;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BagliniWebappApplication.class)
@WebAppConfiguration
public class FotoServiceTest {

	@Inject
	private GruppoFotoService gruppoFotoService;
	
	@Inject
	private FotoService fotoService;
	
	@Test
	public void creaAlbum() {
		GruppoFoto gf = new GruppoFoto();
		gf.setNome("Varie");
		gf.setDescrizione("Immagini di prova");
		
		Foto f1 = new Foto();
		f1.setNome("ciao");
		f1.setDescrizione("Si");
		f1.setPath("/img/ciao.jpg");
		f1.setGruppoFoto(gf);
		gf.getFotos().add(f1);
		
		Foto f2 = new Foto();
		f2.setNome("hey");
		f2.setDescrizione("No");
		f2.setPath("/img/hey.jpg");
		f2.setGruppoFoto(gf);
		gf.getFotos().add(f2);
		
		GruppoFoto newGf = gruppoFotoService.salvaGruppoFoto(gf);
		System.err.println(newGf.getId());
	}

	@Test
	public void findGruppoByNome() {
		GruppoFoto result = this.gruppoFotoService.findByNome(
				"Varie");
		Assert.assertNotNull(result);
	}
	
	@Test
	public void findFotoByNome() {
		List<Foto> result = this.fotoService.findByNome(
				"azienda1");
		Assert.assertEquals(1, result.size());
	}

	@Test
	public void findByPath() {
		Foto result = this.fotoService.findByPath("/img/azienda2.jpg");
		Assert.assertNotNull(result);
	}

	@Test
	public void getFotosByGruppoFoto() {
		List<Foto> result = this.fotoService.getFotosByGruppoId(1);
		Assert.assertEquals(2, result.size());
	}
}
