package it.baglini.service;

import it.baglini.model.GruppoFoto;

import java.util.List;

public interface GruppoFotoService {

	public List<GruppoFoto> getGruppiFoto();
	public List<GruppoFoto> findByNome(String nome);
	
	public GruppoFoto getGruppoFoto(long id);
	public GruppoFoto createGruppoFoto(GruppoFoto gruppoFoto);
	public GruppoFoto updateGruppoFoto(GruppoFoto gruppoFoto);
}
