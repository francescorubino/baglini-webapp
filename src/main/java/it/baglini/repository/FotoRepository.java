package it.baglini.repository;

import it.baglini.model.Foto;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends CrudRepository<Foto, Long>{

	public List<Foto> findByNome(String nome);
	public Foto findByPath(String path);
	public List<Foto> findByGruppoFoto_Id(long id);
	
}
