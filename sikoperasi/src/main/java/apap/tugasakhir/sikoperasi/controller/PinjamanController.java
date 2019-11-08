package apap.tugasakhir.sikoperasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.service.PinjamanService;

@Controller
public class PinjamanController {
	@Autowired
	private PinjamanService pinjamanService;
	
	@RequestMapping("pinjaman/detail")
	public String viewByNoReg(
			@RequestParam("idPinjaman") Long idPinjaman, Model model) {
		PinjamanModel existingPinjaman = pinjamanService.getPinjamanById(idPinjaman).get();
		if( existingPinjaman.getStatus() == 0) { model.addAttribute("status", "Menunggu Persetujuan"); }
		else if ( existingPinjaman.getStatus() == 1) { model.addAttribute("status", "Ditolak"); }
		else if ( existingPinjaman.getStatus() == 2) { model.addAttribute("status", "Disetujui"); }
		else if ( existingPinjaman.getStatus() == 3) { model.addAttribute("status", "Sudah Diambil"); }
		else if ( existingPinjaman.getStatus() == 4) { model.addAttribute("status", "Sudah Dikembalikan"); }
		else if ( existingPinjaman.getStatus() == 5) { model.addAttribute("status", "Overdue"); }
		model.addAttribute("pinjaman", existingPinjaman);
		return "detail-pinjaman";
	}
}
