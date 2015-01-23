package it.baglini.repository;

import it.baglini.model.Notizia;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotiziaRepository extends CrudRepository<Notizia, Long>{

	public List<Notizia> findByTitolo(String titolo);
	
	@Query("select n from Notizia n where n.titolo like :likestr")
	public List<Notizia> getNotizieByLikeTitolo(@Param(value = "likestr") String s);
	
	public List<Notizia> findByDataBetween(Date dataInizio, Date dataFine);
}
