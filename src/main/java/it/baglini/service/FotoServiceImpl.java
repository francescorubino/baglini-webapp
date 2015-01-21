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
	private FotoRepository fotoRepository;

	@Override
	public Foto getFoto(Long idFoto) {
		return fotoRepository.findOne(idFoto);
	}

	@Override
	public Foto updateFoto(Foto foto) {
		return this.fotoRepository.save(foto);
	}

	@Override
	public Foto createFoto(Foto foto) {
		return this.fotoRepository.save(foto);
	}

	@Override
	public List<Foto> getFotos() {
		return Lists.newArrayList(fotoRepository.findAll());
	}

	@Override
	public List<Foto> findByNome(String nome) {
		return fotoRepository.findByNome(nome);
	}

	@Override
	public List<Foto> findByIdGruppo(long idGruppo) {
		return fotoRepository.findByIdGruppoFoto(idGruppo);
	}
}
