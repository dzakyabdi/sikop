package apap.tugasakhir.sikoperasi.controller;


import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.service.PinjamanService;
import apap.tugasakhir.sikoperasi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @Autowired
    RoleService roleService;

    @Qualifier("pinjamanServiceImpl")
    @Autowired
    private PinjamanService pinjamanService;

    @RequestMapping("/")
    public String home(
            Model model
    ) {
        model.addAttribute("listRole", roleService.findAll());
        Authentication rawDataUser = SecurityContextHolder.getContext().getAuthentication();
        PinjamanModel existingPinjaman = pinjamanService.getPinjamanById(id).get();
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
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}

