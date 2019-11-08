package apap.tugasakhir.sikoperasi.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.repository.PinjamanDB;

@Service
@Transactional
public class PinjamanServiceImpl implements PinjamanService {
	@Autowired
	private PinjamanDB pinjamanDb;
	
	@Override
	public Optional<PinjamanModel> getPinjamanById(Long id){
		return pinjamanDb.findById(id);
	}
}
