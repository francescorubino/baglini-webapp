package it.baglini.repository;

import it.baglini.model.GruppoFoto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GruppoFotoRepository extends CrudRepository<GruppoFoto, Long>{

	public GruppoFoto findById(long id);
	public GruppoFoto findByNome(String nome);
	

}
