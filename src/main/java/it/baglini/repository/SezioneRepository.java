package it.baglini.repository;

import it.baglini.model.Sezione;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SezioneRepository extends CrudRepository<Sezione, Long>{

	public Sezione findById(long id);
	public List<Sezione> findByNomeSezione(String nomeSezione);
	

}
