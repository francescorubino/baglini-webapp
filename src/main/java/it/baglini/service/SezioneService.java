package it.baglini.service;

import java.util.List;

import it.baglini.model.Sezione;

public interface SezioneService {

	public Sezione getSezione(long id);
	public List<Sezione> getSezioneByNomeSezione(String nomeSezione);
	public Sezione createSezione(Sezione sezione1);
}
