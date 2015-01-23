package it.baglini.service;

import it.baglini.model.Notizia;

import java.util.List;

public interface NotiziaService {

	public Notizia getNotizia(long idNotizia);

	public Notizia salvaNotizia(Notizia notizia);

	public List<Notizia> getNotizie();

	public List<Notizia> findByTitolo(String titolo);

	public List<Notizia> getNotizieByLikeTitolo(String titolo);

	public List<Notizia> getNotizieByAnno(String anno);

	public List<Notizia> getNotizieByAnnoAndMese(String anno, String mese);
}
