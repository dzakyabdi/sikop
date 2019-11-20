package apap.tugasakhir.sikoperasi.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.service.PinjamanRestService;

@RestController
@RequestMapping("/api")
public class PinjamanRestController {
	@Autowired
	private PinjamanRestService pinjamanRestService;
	
	@PostMapping(value="/pinjaman")
	private PinjamanModel createPinjaman(@Valid @RequestBody PinjamanModel pinjaman, BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
		} else {
			pinjaman.setStatus(0);
			pinjaman.setJumlahPengembalian(0);
			return pinjamanRestService.createPinjaman(pinjaman);
		}
	}

}
