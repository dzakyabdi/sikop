package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.JenisSimpananModel;
import apap.tugasakhir.sikoperasi.model.SimpananModel;
import apap.tugasakhir.sikoperasi.service.AnggotaService;
import apap.tugasakhir.sikoperasi.service.JenisSimpananService;
import apap.tugasakhir.sikoperasi.service.SimpananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SimpananController {

    @Autowired
    private SimpananService simpananService;

    @Autowired
    @Qualifier("jenisSimpananServiceImpl")
    private JenisSimpananService jenisSimpananService;

    @Autowired
    @Qualifier("anggotaServiceImpl")
    private AnggotaService anggotaService;


    @RequestMapping(value = "/simpanan/tambah", method = RequestMethod.GET)
    public String addSimpananFormPage(
            Model model
    ){
        SimpananModel simpananBaru = new SimpananModel();
        List<JenisSimpananModel> listJenisSimpanan = jenisSimpananService.getAllJenisSimpanan();
        List<AnggotaModel> listAnggota = anggotaService.getAllAnggota();
        model.addAttribute("simpananBaru", simpananBaru);
        model.addAttribute("listAnggota", listAnggota);
        model.addAttribute("listJenisSimpanan", listJenisSimpanan);
        return "form-add-simpanan";
    }

    @RequestMapping(value = "/simpanan/tambah", method = RequestMethod.POST)
    public String addSimpananSubmitPage(
            @ModelAttribute SimpananModel simpananBaru,
            Model model
    ){
        simpananService.addSimpanan(simpananBaru);
        model.addAttribute("simpananBaru", simpananBaru);
        return "action-success";
    }

}
