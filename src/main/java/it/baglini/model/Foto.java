package it.baglini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "FOTO")
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NOME", length = 30)
	private String nome;

	@Column(name = "PATH")
	private String path;
	
	@Column(name = "DESCRIZIONE", length = 4000)
	private String descrizione;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GRUPPO_ID")
	private GruppoFoto gruppoFoto;
	
	public Foto() {
		super();
	}

	public Foto(long id) {
		super();
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String testo) {
		this.nome = testo;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String autore) {
		this.path = autore;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public GruppoFoto getGruppoFoto() {
		return gruppoFoto;
	}

	public void setGruppoFoto(GruppoFoto gruppoFoto) {
		this.gruppoFoto = gruppoFoto;
	}

}
