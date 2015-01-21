package it.baglini.service;

import it.baglini.model.Foto;

import java.util.List;

public interface FotoService {

	public Foto getFoto(Long idFoto);
	public Foto updateFoto(Foto foto);
	public Foto createFoto(Foto foto);
	public List<Foto> getFotos();
	public List<Foto> findByNome(String nome);
	public List<Foto> findByIdGruppo(long id);
}
