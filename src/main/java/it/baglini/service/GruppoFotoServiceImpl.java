package it.baglini.service;

import it.baglini.model.GruppoFoto;
import it.baglini.repository.GruppoFotoRepository;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;


@Service
public class GruppoFotoServiceImpl implements GruppoFotoService {

	@Inject
	private GruppoFotoRepository GruppoFotoRepository;


	@Override
	public List<GruppoFoto> getGruppiFoto() {
		return Lists.newArrayList(GruppoFotoRepository.findAll());
	}
	
	@Override
	public GruppoFoto salvaGruppoFoto(GruppoFoto gruppoFoto) {
		return this.GruppoFotoRepository.save(gruppoFoto);
	}

	@Override
	public GruppoFoto findById(long id) {
		return GruppoFotoRepository.findById(id);
	}
	
	@Override
	public GruppoFoto findByNome(String nome) {
		return GruppoFotoRepository.findByNome(nome);
	}
}
