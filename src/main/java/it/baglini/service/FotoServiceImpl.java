package it.baglini.service;

import it.baglini.model.Foto;
import it.baglini.repository.FotoRepository;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;


@Service
public class FotoServiceImpl implements FotoService {

	@Inject
	private FotoRepository FotoRepository;


	@Override
	public List<Foto> getFotos() {
		return Lists.newArrayList(FotoRepository.findAll());
	}
	
	@Override
	public Foto salvaFoto(Foto foto) {
		return this.FotoRepository.save(foto);
	}

	@Override
	public List<Foto> findByNome(String nome) {
		return FotoRepository.findByNome(nome);
	}

	@Override
	public Foto findByPath(String path) {
		return FotoRepository.findByPath(path);
	}

	@Override
	public List<Foto> getFotosByGruppoId(long id) {
		return FotoRepository.findByGruppoFoto_Id(id);
	}




}
