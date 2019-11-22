package apap.tugasakhir.sikoperasi.restcontroller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.rest.PinjamanDetail;
import apap.tugasakhir.sikoperasi.service.AnggotaService;
import apap.tugasakhir.sikoperasi.service.PinjamanService;

@RestController
public class PinjamanRestController {
	@Qualifier("pinjamanServiceImpl")
	@Autowired
	private PinjamanService pinjamanService;
	
	@Autowired
    private AnggotaService anggotaService;
	
	@PostMapping(value="/api/pinjaman/ajukan")
	private PinjamanDetail createPinjaman(@Valid @RequestBody PinjamanDetail pinjaman, BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
		} else {
			PinjamanModel newPinjaman = new PinjamanModel();
			newPinjaman.setStatus(0);
			newPinjaman.setJumlahPengembalian(0);
			newPinjaman.setJumlahPinjaman(pinjaman.getJumlahPinjaman());
			newPinjaman.setTanggalPengajuan(pinjaman.getTanggalPengajuan());
			try{
				AnggotaModel anggota = anggotaService.getAnggotaById(Long.valueOf(pinjaman.getIdAnggota()));
				newPinjaman.setAnggota(anggota);
				pinjamanService.addPinjaman(newPinjaman);
				return pinjaman;
			} catch (NoSuchElementException e) {
				throw new ResponseStatusException(
						HttpStatus.NOT_FOUND, "Anggota with ID " + pinjaman.getIdAnggota() + " not found!");
			}
		}		
	}
	
}
