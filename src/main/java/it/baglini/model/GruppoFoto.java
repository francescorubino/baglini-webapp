package it.baglini.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "GRUPPOFOTO")
public class GruppoFoto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NOME", length = 30)
	private String nome;
	
	@Column(name = "DESCRIZIONE", length = 4000)
	private String descrizione;

	@JsonIgnore
	@OneToMany(mappedBy = "gruppoFoto", cascade = CascadeType.ALL)
	private List<Foto> fotos = new ArrayList<Foto>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public GruppoFoto() {
		super();
	}

	public GruppoFoto(long id) {
		super();
		this.id = id;
	}



}
