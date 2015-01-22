package it.baglini.service;

import it.baglini.BagliniWebappApplication;
import it.baglini.model.Notizia;

import java.util.Calendar;
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
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
@Transactional
@WebAppConfiguration
public class NotiziaServiceTest {

	@Inject
	private NotiziaService notiziaService;
	
	@Rollback(true)
	@Test
	public void creaNotizia() {
		Notizia n = new Notizia();
		n.setTitolo("Prima Notizia");
		n.setTesto("Una bella notizia");
		Calendar cal = Calendar.getInstance();
		n.setData(cal);
		Notizia newN = notiziaService.salvaNotizia(n);
		System.err.println(newN.getId());
	}

	@Test
	public void creaNotiziaPersonalizzata() {
		Notizia n = new Notizia();
		n.setTitolo("Notizia antica");
		n.setTesto("Notizia di prova con anno = 2000");
		Calendar cal = Calendar.getInstance();
		cal.set(2000, 0, 1);
		n.setData(cal);
		Notizia newN = notiziaService.salvaNotizia(n);
		System.err.println(newN.getId());
	}

	@Test
	public void findByTitolo() {
		List<Notizia> result = this.notiziaService.findByTitolo(
				"Prima Notizia");
		Assert.assertEquals(1, result.size());
	}

	@Test
	public void findByLikeTitolo() {
		List<Notizia> result = this.notiziaService
				.getNotizieByLikeTitolo("Pr%");
		Assert.assertEquals(1, result.size());
	}

	@Test
	public void findNotizieByAnno() {
		List<Notizia> result = this.notiziaService
				.getNotizieByAnno(2000);
		Assert.assertEquals(1, result.size());
	}
}
