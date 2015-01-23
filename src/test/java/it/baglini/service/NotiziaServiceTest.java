package it.baglini.service;

import it.baglini.BagliniWebappApplication;
import it.baglini.model.Notizia;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
public class NotiziaServiceTest {

	@Inject
	private NotiziaService notiziaService;

	@Rollback(true)
	@Test
	public void creaNotizie() throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Notizia n1 = new Notizia();
		n1.setTitolo("Prima Notizia");
		n1.setTesto("Una notizia di maggio 2000");
		LocalDate ld = LocalDate.parse("2000-05-01", formatter);
		Date d1 = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		n1.setData(d1);
		Notizia newN1 = notiziaService.salvaNotizia(n1);
		System.err.println(newN1.getId());

		Notizia n2 = new Notizia();
		n2.setTitolo("Seconda Notizia");
		n2.setTesto("Una notizia di settembre 2000");
		ld = LocalDate.parse("2000-09-11", formatter);
		Date d2 = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		n2.setData(d2);
		Notizia newN2 = notiziaService.salvaNotizia(n2);
		System.err.println(newN2.getId());


		Notizia n3 = new Notizia();
		n3.setTitolo("Terza Notizia");
		n3.setTesto("Una notizia di febbraio 2014");
		ld = LocalDate.parse("2014-02-07", formatter);
		Date d3 = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		n3.setData(d3);
		Notizia newN3 = notiziaService.salvaNotizia(n3);
		System.err.println(newN3.getId());

		Notizia n4 = new Notizia();
		n4.setTitolo("Quarta Notizia");
		n4.setTesto("Una notizia di settembre 2015");
		ld = LocalDate.parse("2015-09-01", formatter);
		Date d4 = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		n4.setData(d4);
		Notizia newN4 = notiziaService.salvaNotizia(n4);
		System.err.println(newN4.getId());

		Notizia n5 = new Notizia();
		n5.setTitolo("Quinta Notizia");
		n5.setTesto("Una notizia di settembre 2015");
		ld = LocalDate.parse("2015-09-31", formatter);
		Date d5 = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		n5.setData(d5);
		Notizia newN5 = notiziaService.salvaNotizia(n5);
		System.err.println(newN5.getId());
		
		Notizia n6 = new Notizia();
		n6.setTitolo("Sesta Notizia");
		n6.setTesto("Una notizia di ottobre 2015");
		ld = LocalDate.parse("2015-10-01", formatter);
		Date d6 = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		n6.setData(d6);
		Notizia newN6 = notiziaService.salvaNotizia(n6);
		System.err.println(newN6.getId());
	}

	@Test
	public void findByTitolo() {
		List<Notizia> result = this.notiziaService
				.findByTitolo("Prima Notizia");
		Assert.assertEquals(1, result.size());
	}

	@Test
	public void getByLikeTitolo() {
		List<Notizia> result = this.notiziaService
				.getNotizieByLikeTitolo("Sec%");
		Assert.assertEquals(1, result.size());
	}

	@Test
	public void getNotizieByAnno() throws ParseException {
		List<Notizia> result = this.notiziaService.getNotizieByAnno("2000");
		Assert.assertEquals(2, result.size());
	}

	@Test
	public void getNotizieByAnnoAndMese() throws ParseException {
		List<Notizia> result = this.notiziaService.getNotizieByAnnoAndMese(
				"2015", "09");
		Assert.assertEquals(2, result.size());
	}
}
