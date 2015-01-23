package it.baglini.service;

import it.baglini.model.Notizia;
import it.baglini.repository.NotiziaRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class NotiziaServiceImpl implements NotiziaService {

	@Inject
	private NotiziaRepository notiziaRepository;

	@Override
	public Notizia getNotizia(long idNotizia) {
		return notiziaRepository.findOne(idNotizia);
	}

	@Override
	public Notizia salvaNotizia(Notizia notizia) {
		return this.notiziaRepository.save(notizia);
	}

	@Override
	public List<Notizia> findByTitolo(String titolo) {
		return notiziaRepository.findByTitolo(titolo);
	}

	@Override
	public List<Notizia> getNotizieByLikeTitolo(String titolo) {
		return notiziaRepository.getNotizieByLikeTitolo(titolo);
	}

	@Override
	public List<Notizia> getNotizieByAnno(String anno) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime d1 = LocalDateTime.parse(anno + "-01-01 00:00", formatter);
		LocalDateTime d2 = d1.plusYears(1);
		d2 = d2.minus(1, ChronoUnit.SECONDS);
		Date dataInizio = new Date();
		Date dataFine = new Date();
		dataInizio = Date.from(d1.atZone(ZoneId.systemDefault()).toInstant());
		dataFine = Date.from(d2.atZone(ZoneId.systemDefault()).toInstant());
//		Date dataInizio = Date.from(d1.atStartOfDay(ZoneId.systemDefault()).toInstant());
//		Date dataFine = Date.from(d2.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return notiziaRepository.findByDataBetween(dataInizio, dataFine);
	}

	@Override
	public List<Notizia> getNotizieByAnnoAndMese(String anno, String mese) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime d1 = LocalDateTime.parse(anno + "-" + mese + "-01 00:00",
				formatter);
		LocalDateTime d2 = LocalDateTime.parse(anno + "-" + mese + "-01 00:00",
				formatter);
		d2 = d2.plusMonths(1);
		d2 = d2.minus(1, ChronoUnit.SECONDS);
		Date dataInizio = new Date();
		Date dataFine = new Date();
		dataInizio = Date.from(d1.atZone(ZoneId.systemDefault()).toInstant());
		dataFine = Date.from(d2.atZone(ZoneId.systemDefault()).toInstant());
		return notiziaRepository.findByDataBetween(dataInizio, dataFine);
	}

	@Override
	public List<Notizia> getNotizie() {
		return Lists.newArrayList(notiziaRepository.findAll());

	}
}
