package it.baglini.service;

import it.baglini.model.Notizia;
import it.baglini.repository.NotiziaRepository;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;


@Service
public class NotiziaServiceImpl implements NotiziaService {

	@Inject
	private NotiziaRepository NotiziaRepository;

	@Override
	public Notizia salvaNotizia(Notizia notizia) {
		return this.NotiziaRepository.save(notizia);
	}

	@Override
	public List<Notizia> findByTitolo(String titolo) {
		return NotiziaRepository.findByTitolo(titolo);
	}

	@Override
	public List<Notizia> getNotizieByLikeTitolo(String titolo) {
		return NotiziaRepository.getNotizieByLikeTitolo(titolo);
	}

	@Override
	public List<Notizia> getNotizieByAnno(int anno) {
		Calendar inizio = Calendar.getInstance();
		Calendar fine = Calendar.getInstance();
		inizio.set(anno, 0, 1);
		fine.set(anno, 11, 31);
		return NotiziaRepository.getNotizieByAnno(inizio, fine);
	}

	@Override
	public List<Notizia> getNotizie() {
		return Lists.newArrayList(NotiziaRepository.findAll());
	}

}
