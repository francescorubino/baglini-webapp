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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SEZIONE")
public class Sezione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "NOME_SEZIONE", length = 30)
	private String nomeSezione; 
	
	@JsonIgnore
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name = "SEZIONE_TO_GRUPPOFOTO", joinColumns = { @JoinColumn(name = "SEZIONE_ID", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "GRUPPOFOTO_ID", referencedColumnName = "id") })
	private List<GruppoFoto> gruppoFotos = new ArrayList<GruppoFoto>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeSezione() {
		return nomeSezione;
	}

	public void setNomeSezione(String nomeSezione) {
		this.nomeSezione = nomeSezione;
	}

	public List<GruppoFoto> getGruppoFotos() {
		return gruppoFotos;
	}

	public void setGruppoFotos(List<GruppoFoto> gruppoFotos) {
		this.gruppoFotos = gruppoFotos;
	}
}
