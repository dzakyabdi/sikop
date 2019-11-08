package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnggotaController {
    @Autowired
    private AnggotaService anggotaService;

    @RequestMapping(value = "/anggota/detail", method = RequestMethod.GET)
    public String detailAnggota(@RequestParam("id") Long id, Model model) {
        AnggotaModel anggota = anggotaService.getAnggotaById(id);

        model.addAttribute("anggota", anggota);
        return "detail-anggota";
    }
}
