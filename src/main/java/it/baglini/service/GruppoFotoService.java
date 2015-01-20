package it.baglini.service;

import it.baglini.model.GruppoFoto;

import java.util.List;

public interface GruppoFotoService {

	public GruppoFoto salvaGruppoFoto(GruppoFoto gruppoFoto);
	public List<GruppoFoto> getGruppiFoto();
	public GruppoFoto findById(long id);
	public GruppoFoto findByNome(String nome);
}
