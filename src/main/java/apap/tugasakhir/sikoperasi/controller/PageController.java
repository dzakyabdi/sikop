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

import java.util.ArrayList;
import java.util.Arrays;
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
        Authentication rawDataUser = SecurityContextHolder.getContext().getAuthentication();
        if(rawDataUser.getAuthorities().toString().contains("ADMIN")){
            model.addAttribute("admin", "true");
        }

        ArrayList<String> str = new ArrayList<String>();
        str.add("Tidak");

        Integer jumlahPengurus = 0;
        Integer jumlahFasilitas = 0;

        for(AnggotaModel obj : anggotaService.getAllAnggota()) {
            if(obj.getIs_pengurus() == true) jumlahPengurus+=1;
        }

        for(FasilitasDetail fasil : ruanganRestService.getFasilitas()) {
            jumlahFasilitas += Integer.parseInt(fasil.getJumlah());
        }


//        System.out.println(jumlahFasilitas);
//        System.out.println(jumlahPengurus);

        if(jumlahFasilitas > jumlahPengurus) {
            str.add("Ya");
        }

        model.addAttribute("isPengurus", str);
        model.addAttribute("listRole", roleService.findAll());
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}

