package it.baglini.service;

import it.baglini.BagliniWebappApplication;
import it.baglini.model.Foto;
import it.baglini.model.GruppoFoto;
import it.baglini.model.Sezione;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BagliniWebappApplication.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@WebAppConfiguration
public class FotoServiceTest {

	@Inject
	private GruppoFotoService gruppoFotoService;

	@Inject
	private SezioneService sezioneService; 
	
	@Inject
	private FotoService fotoService;

	@Rollback(value = true)
	@Test
	public void creaAzienda() {
		Sezione sezione1 = new Sezione(); 
		sezione1.setNomeSezione("azienda");
		
		GruppoFoto gf = new GruppoFoto();
		gf.setNome("Azienda");
		gf.setDescrizione("Pagina di descrizione dell'azienda");

		Foto f1 = new Foto();
		f1.setNome("azienda1");
		f1.setDescrizione("Azienda vista da fuori");
		f1.setPath("img/baglini/azienda1.jpg");
		f1.setGruppoFoto(gf);
		gf.getFotos().add(f1);

		Foto f2 = new Foto();
		f2.setNome("azienda2");
		f2.setDescrizione("Azienda vista da dentro");
		f2.setPath("img/baglini/azienda2.jpg");
		f2.setGruppoFoto(gf);
		gf.getFotos().add(f2);
		
		gf.getSezioni().add(sezione1);
		sezione1.getGruppoFotos().add(gf);
		
		Sezione sezione = sezioneService.createSezione(sezione1);
		System.err.println(sezione.getId());
	}

	@Rollback(value = true)
	@Test
	public void creaServizi() {
		Sezione sezione1 = new Sezione(); 
		sezione1.setNomeSezione("servizi");
		
		GruppoFoto gf = new GruppoFoto();
		gf.setNome("Servizi");
		gf.setDescrizione("Pagina di descrizione dei servizi");

		Foto f1 = new Foto();
		f1.setNome("servizio1");
		f1.setDescrizione("Servizio wow");
		f1.setPath("img/baglini/servizi1.jpg");
		f1.setGruppoFoto(gf);
		gf.getFotos().add(f1);

		Foto f2 = new Foto();
		f2.setNome("servizio2");
		f2.setDescrizione("Servizio antani");
		f2.setPath("img/baglini/servizi2.jpg");
		f2.setGruppoFoto(gf);
		gf.getFotos().add(f2);
		
		gf.getSezioni().add(sezione1);
		sezione1.getGruppoFotos().add(gf);
		
		Sezione sezione = sezioneService.createSezione(sezione1);
		System.err.println(sezione.getId());
	}

	@Rollback(value = true)
	@Test
	public void creaRealizzazioni() {
		Sezione sezione1 = new Sezione(); 
		sezione1.setNomeSezione("realizzazioni");
		
		GruppoFoto gf = new GruppoFoto();
		gf.setNome("Casa sul mare");
		gf.setDescrizione("Bella casa sul mare");
		
		Foto f1 = new Foto();
		f1.setNome("casamare1");
		f1.setDescrizione("Casa mare wow");
		f1.setPath("img/baglini/casamare1.jpg");
		f1.setGruppoFoto(gf);
		gf.getFotos().add(f1);
		
		Foto f2 = new Foto();
		f2.setNome("casamare2");
		f2.setDescrizione("Casa mare wow");
		f2.setPath("img/baglini/casamare2.jpg");
		f2.setGruppoFoto(gf);
		gf.getFotos().add(f2);
		
		gf.getSezioni().add(sezione1);
		sezione1.getGruppoFotos().add(gf);
		
		Sezione sezione = sezioneService.createSezione(sezione1);
		System.err.println(sezione.getId());
	}
	
	@Test
	public void searchGruppoFotoBySezione(){
		Sezione sezione = new Sezione();
		sezione.setNomeSezione("realizzazioni");
		List<GruppoFoto> result = this.gruppoFotoService.findBySezione(sezione);
		Assert.assertEquals(1, result.size());
	}

	@Test
	public void findGruppoByNome() {
		List<GruppoFoto> result = this.gruppoFotoService.findByNome("Varie");
		Assert.assertNotNull(result);
	}

	@Test
	public void findFotoByNome() {
		List<Foto> result = this.fotoService.findByNome("azienda1");
		Assert.assertEquals(1, result.size());
	}


	@Test
	public void getFotosByGruppoFoto() {
		List<Foto> result = this.fotoService.findByIdGruppo(1);
		Assert.assertEquals(2, result.size());
	}
}
