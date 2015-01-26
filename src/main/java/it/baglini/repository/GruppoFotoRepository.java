package it.baglini.repository;

import it.baglini.model.GruppoFoto;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GruppoFotoRepository extends CrudRepository<GruppoFoto, Long>{

	public GruppoFoto findById(long id);
	public List<GruppoFoto> findByNome(String nome);
	public List<GruppoFoto> findBySezioni_nomeSezione(String nomeSezione);
	

}
