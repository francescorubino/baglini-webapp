package it.baglini.service;

import it.baglini.model.Sezione;
import it.baglini.repository.SezioneRepository;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class SezioneServiceImpl implements SezioneService {

	@Inject
	private SezioneRepository sezioneRepository; 
	
	@Override
	public Sezione getSezione(long id) {
		return sezioneRepository.findById(id); 
	}

	@Override
	public List<Sezione> getSezioneByNomeSezione(String nomeSezione) {
		return sezioneRepository.findByNomeSezione(nomeSezione);
	}

	@Override
	public Sezione createSezione(Sezione sezione) {
		return sezioneRepository.save(sezione);
	}

}
