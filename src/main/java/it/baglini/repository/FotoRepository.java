package it.baglini.repository;

import it.baglini.model.Foto;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends CrudRepository<Foto, Long>{

	public List<Foto> findByNome(String nome);
	public Foto findByPath(String path);
	
	@Query("select f from Foto f join f.gruppoFoto g where g.id = :id")
	public List<Foto> findByIdGruppoFoto(@Param(value="id") long id);
	
}
