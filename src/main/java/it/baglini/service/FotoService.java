package it.baglini.service;

import it.baglini.model.Foto;

import java.util.List;

public interface FotoService {

	public Foto salvaFoto(Foto foto);
	public List<Foto> getFotos();
	public List<Foto> findByNome(String nome);
	public Foto findByPath(String path);
	public List<Foto> getFotosByGruppoId(long id);
}
