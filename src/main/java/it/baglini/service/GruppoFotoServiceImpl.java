package it.baglini.service;

import it.baglini.model.GruppoFoto;
import it.baglini.model.Sezione;
import it.baglini.repository.GruppoFotoRepository;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;


@Service
public class GruppoFotoServiceImpl implements GruppoFotoService {

	@Inject
	private GruppoFotoRepository gruppoFotoRepository;


	@Override
	public List<GruppoFoto> getGruppiFoto() {
		return Lists.newArrayList(gruppoFotoRepository.findAll());
	}


	@Override
	public GruppoFoto getGruppoFoto(long id) {
		return gruppoFotoRepository.findById(id);
	}
	
	@Override
	public List<GruppoFoto> findByNome(String nome) {
		return gruppoFotoRepository.findByNome(nome);
	}


	@Override
	public GruppoFoto createGruppoFoto(GruppoFoto gruppoFoto) {
		return this.gruppoFotoRepository.save(gruppoFoto);
	}


	@Override
	public GruppoFoto updateGruppoFoto(GruppoFoto gruppoFoto) {
		return this.gruppoFotoRepository.save(gruppoFoto);
	}


	@Override
	public List<GruppoFoto> findBySezione(Sezione sezione) {
		return this.gruppoFotoRepository.findBySezioni_nomeSezione(sezione.getNomeSezione());
	}
}
