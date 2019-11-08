package apap.tugasakhir.sikoperasi.service;

import java.util.Optional;

import apap.tugasakhir.sikoperasi.model.PinjamanModel;

public interface PinjamanService {
	Optional<PinjamanModel> getPinjamanById(Long id);
}
