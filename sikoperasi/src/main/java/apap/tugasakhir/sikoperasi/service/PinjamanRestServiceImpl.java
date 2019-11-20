package apap.tugasakhir.sikoperasi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.repository.PinjamanDB;


@Service
@Transactional
public class PinjamanRestServiceImpl implements PinjamanRestService {
//	private final WebClient webClient;
	
	@Autowired
	private PinjamanDB pinjamanDB;
	
	@Override
	public PinjamanModel createPinjaman(PinjamanModel pinjaman) {
		return pinjamanDB.save(pinjaman);
	}
}
