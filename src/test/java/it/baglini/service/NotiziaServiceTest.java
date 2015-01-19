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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BagliniWebappApplication.class)
@WebAppConfiguration
public class NotiziaServiceTest {

	@Inject
	private NotiziaService notiziaService;
	
	@Test
	public void creaNotizia() {
		Notizia n = new Notizia();
		n.setTitolo("Seconda Notizia");
		n.setTesto("La nostra bruttissima seconda notizia");
		Calendar cal = Calendar.getInstance();
		n.setData(cal);
		Notizia newN = notiziaService.salvaNotizia(n);
		System.err.println(newN.getId());
	}

	@Test
	public void findByTitolo() {
		List<Notizia> result = this.notiziaService.findByTitolo(
				"Seconda Notizia");
		Assert.assertEquals(1, result.size());
	}

	@Test
	public void findByLikeTitolo() {
		List<Notizia> result = this.notiziaService
				.getNotizieByLikeTitolo("Sec%");
		Assert.assertEquals(1, result.size());
	}

	@Test
	public void findNotizieByAnno() {
		List<Notizia> result = this.notiziaService
				.getNotizieByAnno(2015);
		Assert.assertEquals(1, result.size());
	}
}
