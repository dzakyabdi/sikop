package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.service.PinjamanService;
import org.hibernate.tool.hbm2ddl.SchemaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PinjamanController {
    @Qualifier("pinjamanServiceImpl")
    @Autowired
    private PinjamanService pinjamanService;

    @RequestMapping(value = "/pinjaman/view-all", method = RequestMethod.GET)
    public String viewPinjamanList(Model model){
        List<PinjamanModel> pinjamanList =  pinjamanService.getPinjamanList();
        model.addAttribute("pinjamanList",pinjamanList);
        return "view-all-pinjaman";
    }

    @RequestMapping(value = "/pinjaman/view", method = RequestMethod.GET)
    public String viewPinjaman(@RequestParam(value = "id") Long id, Model model){
        PinjamanModel pinjaman =  pinjamanService.getPinjamanById(id).get();
        model.addAttribute(pinjaman);
        return "view-pinjaman";
    }

    @RequestMapping("pinjaman/detail")
    public String viewById(
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
