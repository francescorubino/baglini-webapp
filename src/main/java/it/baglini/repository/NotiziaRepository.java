package it.baglini.repository;

import it.baglini.model.Notizia;

import java.util.Calendar;
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
	
	@Query("select n from Notizia n where n.data between :inizio AND :fine")
	public List<Notizia> getNotizieByAnno(@Param(value = "inizio")Calendar i, @Param(value = "fine")Calendar f);
	
	@Query("select n from Notizia n where n.data between :inizio AND :fine")
	public List<Notizia> getNotizieByAnnoAndMese(@Param(value = "inizio")Calendar i, @Param(value = "fine")Calendar f);
}
