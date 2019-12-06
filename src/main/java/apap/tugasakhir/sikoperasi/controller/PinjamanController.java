package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.service.AnggotaService;
import apap.tugasakhir.sikoperasi.service.PinjamanService;
import org.hibernate.annotations.common.reflection.XMethod;
import org.hibernate.tool.hbm2ddl.SchemaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PinjamanController {
	@Qualifier("pinjamanServiceImpl")
    @Autowired
    private PinjamanService pinjamanService;
    
    @Autowired
    private AnggotaService anggotaService;

    @RequestMapping(value = "/pinjaman/view-all", method = RequestMethod.GET)
    public String viewPinjamanList(Model model){
        List<PinjamanModel> pinjamanList =  pinjamanService.getPinjamanList();
        model.addAttribute("pinjamanList",pinjamanList);
        return "view-all-pinjaman";
    }

    @RequestMapping(value = "pinjaman/view/{id}", method = RequestMethod.GET)
    public String viewPinjaman(@PathVariable Long id, Model model) {
        PinjamanModel existingPinjaman = pinjamanService.getPinjamanById(id).get();
        if( existingPinjaman.getStatus() == 0) { model.addAttribute("status", "Menunggu Persetujuan"); }
        else if ( existingPinjaman.getStatus() == 1) { model.addAttribute("status", "Ditolak"); }
        else if ( existingPinjaman.getStatus() == 2) { model.addAttribute("status", "Disetujui"); }
        else if ( existingPinjaman.getStatus() == 3) { model.addAttribute("status", "Sudah Diambil"); }
        else if ( existingPinjaman.getStatus() == 4) { model.addAttribute("status", "Sudah Dikembalikan"); }
        else if ( existingPinjaman.getStatus() == 5) { model.addAttribute("status", "Overdue"); }
        model.addAttribute("pinjaman", existingPinjaman);
        return "detail-pinjaman";
    }
    
    @RequestMapping(value="/pinjaman/ajukan", method = RequestMethod.GET)
    public String addPinjaman(Model model) {
    	PinjamanModel newPinjaman = new PinjamanModel();
    	List<AnggotaModel> listAnggota = anggotaService.getAllAnggota();
    	model.addAttribute("pinjaman", newPinjaman);
    	model.addAttribute("allAnggota", listAnggota);
    	return "form-ajukan-pinjaman";
    }
    
    @RequestMapping(value="/pinjaman/ajukan", method = RequestMethod.POST)
    public String submitAddPinjaman(
    		@RequestParam("idAnggota") Long idAnggota, @ModelAttribute PinjamanModel pinjaman, Model model) {
    	AnggotaModel anggota = anggotaService.getAnggotaById(idAnggota);
    	pinjaman.setAnggota(anggota);
    	pinjaman.setStatus(0);
    	pinjaman.setJumlahPengembalian(0);
    	pinjamanService.addPinjaman(pinjaman);
    	return "homepage";
    }

    @RequestMapping(value = "pinjaman/ubah/{id}", method = RequestMethod.GET)
    public String changePinjamanFormPage(@PathVariable Long id, Model model) {
        PinjamanModel existingPinjaman = pinjamanService.getPinjamanById(id).get();
        model.addAttribute("pinjaman", existingPinjaman);
        return "form-change-pinjaman";
    }

    @RequestMapping(value = "pinjaman/ubah/{id}", method = RequestMethod.POST)
    public String changePinjamanSubmit(@PathVariable Long id, @ModelAttribute PinjamanModel pinjaman, Model model) {
        PinjamanModel newPinjaman = pinjamanService.updatePinjaman(pinjaman);
        model.addAttribute("pinjaman", newPinjaman);
        return "changed-pinjaman";
    }

}
