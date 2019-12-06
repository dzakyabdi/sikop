package apap.tugasakhir.sikoperasi.controller;


import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.rest.FasilitasDetail;
import apap.tugasakhir.sikoperasi.service.AnggotaService;
import apap.tugasakhir.sikoperasi.service.RoleService;
import apap.tugasakhir.sikoperasi.service.RuanganRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    RoleService roleService;

    @Autowired
    AnggotaService anggotaService;

    @Autowired
    RuanganRestService ruanganRestService;

    @RequestMapping("/")
    public String home(
            Model model
    ) {
        model.addAttribute("listRole", roleService.findAll());
        Authentication rawDataUser = SecurityContextHolder.getContext().getAuthentication();
        if(rawDataUser.getAuthorities().toString().contains("ADMIN")){
            model.addAttribute("admin", "true");
        }
        return "homepage";
    }

    @RequestMapping("/home")
    public String homepage(Model model) {
        model.addAttribute("listRole", roleService.findAll());

        Authentication rawDataUser = SecurityContextHolder.getContext().getAuthentication();
        if(rawDataUser.getAuthorities().toString().contains("ADMIN")){
            model.addAttribute("admin", "true");
        }

        List<FasilitasDetail> listFasilitas = ruanganRestService.getFasilitas();
        List<String> isPengurus = {"Tidak"};

        int jumlahPengurus = 0;
        int jumlahFasilitas = 0;

        for(FasilitasDetail fasilitas : listFasilitas) {
            jumlahFasilitas += Integer.parseInt(fasilitas.getJumlah());
        }

        for(AnggotaModel anggota : anggotaService.getAllAnggota()) {
            if(anggota.getIs_pengurus() == true) {
                jumlahPengurus +1;
            }
        }

        if(jumlahFasilitas > jumlahPengurus) {
            isPengurus.add("Ya");
        }

        model.addAttribute("isPengurus", isPengurus);

        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}

