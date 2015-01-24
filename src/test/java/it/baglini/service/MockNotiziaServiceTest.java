package it.baglini.service;

import it.baglini.model.Notizia;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MockNotiziaServiceTest {

	private NotiziaService notiziaService;

	@Before
	public void setUp(){
		this.notiziaService =  Mockito.mock(NotiziaService.class);
		
		Notizia notizia1 = new Notizia();
		notizia1.setId(123);
		notizia1.setTesto("Sono una notizia mock");
		notizia1.setTitolo("Notizia mock 1");
		notizia1.setData(new Date());

		Notizia notizia2 = new Notizia();
		notizia2.setId(123);
		notizia2.setTesto("Sono una notizia mock");
		notizia2.setTitolo("Notizia mock 2");
		notizia2.setData(new Date());
		
		Mockito.when(this.notiziaService.findByTitolo("Notizia mock 1")).thenReturn(Arrays.asList(notizia1));
		Mockito.when(this.notiziaService.getNotizieByAnno("2015")).thenReturn(Arrays.asList(notizia1, notizia2));
		Mockito.when(this.notiziaService.getNotizia(123)).thenReturn(notizia1);
	}

	@Test
	public void findByTitolo() {
		List<Notizia> result = this.notiziaService.findByTitolo("Notizia mock 1");
		Assert.assertEquals(1, result.size());
	}

	@Test
	public void getNotizieByAnno() throws ParseException {
		List<Notizia> result = this.notiziaService.getNotizieByAnno("2015");
		Assert.assertEquals(2, result.size());
	}

	@Test
	public void getNotizi123() throws ParseException {
		Notizia result = this.notiziaService.getNotizia(123);
		Assert.assertEquals(123, result.getId());
	}
}
