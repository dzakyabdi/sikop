package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.RoleModel;
import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.service.AnggotaService;
import apap.tugasakhir.sikoperasi.service.RoleService;
import apap.tugasakhir.sikoperasi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
public class AnggotaController {
    @Autowired
    private AnggotaService anggotaService;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;

    @RequestMapping(value = "/anggota/detail", method = RequestMethod.GET)
    public String detailAnggota(Model model) {
        UserModel userNow = userService.getUser();
        AnggotaModel anggota = anggotaService.getAnggotaByUser(userNow);
        model.addAttribute("anggota", anggota);
        return "detailAnggota";
    }

    @RequestMapping(value = "/anggota/tambah", method = RequestMethod.GET)
    public String tambahAnggotaFormPage(Model model) {
        AnggotaModel anggota = new AnggotaModel();

        model.addAttribute("anggota", anggota);

        return "form-tambah-anggota";
    }

    @RequestMapping(value = "/anggota/tambah", method = RequestMethod.POST)
    public String tambahAnggotaFormSubmit(@ModelAttribute AnggotaModel anggota, Model model) {
        String nia = "";
        Random random = new Random();
        for(int i = 0; i < 8; i++) {
            int x = random.nextInt(10);
            nia += String.valueOf(x);
        }
        anggota.setNia(nia);
        anggotaService.addAnggota(anggota);

        model.addAttribute("anggota", anggota);
        return "tambah-anggota";
    }
    
    @RequestMapping(value ="/anggota/ubah-status", method = RequestMethod.GET)
    public String ubahStatus(@RequestParam("id") Long id, Model model) {
    	AnggotaModel anggota= anggotaService.getAnggotaById(id);
    	model.addAttribute("anggota", anggota);
    	return "ubah-status-anggota";
    }
    
    @RequestMapping(value ="/anggota/ubah-status", method = RequestMethod.POST)
    public String ubahStatusSubmit(@RequestParam("id") Long id, @ModelAttribute AnggotaModel anggota, Model model) {
    	AnggotaModel target = anggotaService.getAnggotaById(id);
        target.setIs_pengurus(anggota.getIs_pengurus());
        if(anggota.getIs_pengurus()){
        	RoleModel role = roleService.getRoleById(Long.valueOf(6));
            target.getUser().setRole(role);
        } else {
        	RoleModel role = roleService.getRoleById(Long.valueOf(7));
            target.getUser().setRole(role);
        }
        anggotaService.addAnggota(target);
    	List<AnggotaModel> listAnggota = anggotaService.getAllAnggota();
        model.addAttribute("anggotaList",listAnggota);
    	return "view-all-anggota";
    }

    @RequestMapping(value = "/anggota/viewall", method = RequestMethod.GET)
    public String viewall(Model model){
        List<AnggotaModel> listAnggota = anggotaService.getAllAnggota();
        model.addAttribute("anggotaList",listAnggota);
        return "view-all-anggota";
    }
}
