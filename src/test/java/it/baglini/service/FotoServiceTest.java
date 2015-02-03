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
		gf.setNome("Casa in montagna");
		gf.setDescrizione("Bella casa in montagna");
		
		Foto f1 = new Foto();
		f1.setNome("casamontagna1");
		f1.setDescrizione("Casa montagna wow");
		f1.setPath("img/baglini/casamontagna1.jpg");
		f1.setGruppoFoto(gf);
		gf.getFotos().add(f1);
		
		Foto f2 = new Foto();
		f2.setNome("casamontagna2");
		f2.setDescrizione("Casa montagna wow");
		f2.setPath("img/baglini/casamontagna2.jpg");
		f2.setGruppoFoto(gf);
		gf.getFotos().add(f2);
		
//		Sezione sezione1 = sezioneService.getSezioneByNomeSezione("realizzazioni").get(0);
		gf.getSezioni().add(sezione1);
		sezione1.getGruppoFotos().add(gf);
		
		Sezione sezione = sezioneService.createSezione(sezione1);
		System.err.println(sezione.getId());
	}
	
	@Rollback(value = false)
	@Test
	public void creaGruppoInRealizzazioni() {
		Sezione sezione = sezioneService.getSezioneByNomeSezione("realizzazioni").get(0);
		
		GruppoFoto gf = new GruppoFoto();
		gf.setNome("ventura");
		gf.setDescrizione("Ristrutturazione casa ventura");

		Foto f1 = new Foto();
		f1.setNome("ventura1");
		f1.setDescrizione("Facciata");
		f1.setPath("img/baglini/Ventura/ventura1.jpg");
		f1.setGruppoFoto(gf);
		gf.getFotos().add(f1);

		Foto f2 = new Foto();
		f2.setNome("ventura2");
		f2.setDescrizione("Vecchia facciata");
		f2.setPath("img/baglini/Ventura/ventura2.jpg");
		f2.setGruppoFoto(gf);
		gf.getFotos().add(f2);
		
//		Foto f3 = new Foto();
//		f3.setNome("ventura3");
//		f3.setDescrizione("Lavori");
//		f3.setPath("img/baglini/ventura/ventura3.jpg");
//		f3.setGruppoFoto(gf);
//		gf.getFotos().add(f3);
//		
//		Foto f4 = new Foto();
//		f4.setNome("ventura4");
//		f4.setDescrizione("Lavori");
//		f4.setPath("img/baglini/ventura/ventura4.jpg");
//		f4.setGruppoFoto(gf);
//		gf.getFotos().add(f4);
//		
//		Foto f5 = new Foto();
//		f5.setNome("ventura5");
//		f5.setDescrizione("Lavori");
//		f5.setPath("img/baglini/ventura/ventura5.jpg");
//		f5.setGruppoFoto(gf);
//		gf.getFotos().add(f5);
//		
//		Foto f6 = new Foto();
//		f6.setNome("ventura6");
//		f6.setDescrizione("Lavori");
//		f6.setPath("img/baglini/ventura/ventura6.jpg");
//		f6.setGruppoFoto(gf);
//		gf.getFotos().add(f6);
//		
//		Foto f7 = new Foto();
//		f7.setNome("ventura7");
//		f7.setDescrizione("Lavori");
//		f7.setPath("img/baglini/ventura/ventura7.jpg");
//		f7.setGruppoFoto(gf);
//		gf.getFotos().add(f7);
//		
//		Foto f8 = new Foto();
//		f8.setNome("ventura8");
//		f8.setDescrizione("lavori");
//		f8.setPath("img/baglini/ventura/ventura8.jpg");
//		f8.setGruppoFoto(gf);
//		gf.getFotos().add(f8);
//		
//		Foto f9 = new Foto();
//		f9.setNome("ventura9");
//		f9.setDescrizione("Lavori");
//		f9.setPath("img/baglini/ventura/ventura9.jpg");
//		f9.setGruppoFoto(gf);
//		gf.getFotos().add(f9);
		
		gf.getSezioni().add(sezione);
		sezione.getGruppoFotos().add(gf);
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
