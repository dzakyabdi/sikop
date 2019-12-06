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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @RequestMapping(value = "/simpanan/view-all", method = RequestMethod.GET)
    public String viewSimpananList(Model model){
        List<SimpananModel> simpananList =  simpananService.getAllSimpanan();
        model.addAttribute("simpananList",simpananList);
        return "view-all-simpanan";
    }

    @RequestMapping("simpanan/view")
    public String viewById(
            @RequestParam("id") Long id, Model model) {
        SimpananModel  existingSimpanan = simpananService.getSimpananById(id);
        model.addAttribute("simpanan", existingSimpanan);
        return "detail-simpanan";
    }

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

    @RequestMapping(value = "simpanan/ubah/{id}", method = RequestMethod.GET)
    public String changeSimpananFormPage(@PathVariable Long id, Model model) {
        SimpananModel existingSimpanan = simpananService.getSimpananById(id);
        List<JenisSimpananModel> listJenisSimpanan = jenisSimpananService.getAllJenisSimpanan();
        List<AnggotaModel> listAnggota = anggotaService.getAllAnggota();

        model.addAttribute("simpanan", existingSimpanan);
        model.addAttribute("jenisSimpananList", listJenisSimpanan);
        model.addAttribute("listAnggota", listAnggota);
        return "form-change-simpanan";
    }

    @RequestMapping(value = "simpanan/ubah/{id}", method = RequestMethod.POST)
    public String changeSimpananSubmit(@PathVariable Long id, @ModelAttribute SimpananModel simpanan, Model model) {
        SimpananModel newSimpanan = simpananService.updateSimpanan(simpanan);
        model.addAttribute("simpanan", newSimpanan);
        return "changed-simpanan";
    }

}
