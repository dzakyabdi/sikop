package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.service.AnggotaService;
import apap.tugasakhir.sikoperasi.rest.UserDetail;
import apap.tugasakhir.sikoperasi.service.UserRestService;
import apap.tugasakhir.sikoperasi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @Qualifier("userRestServiceImpl")
    @Autowired
    private UserRestService userRestService;

    @Autowired
    private AnggotaService anggotaService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSumbit(
            RedirectAttributes attributes,
            @ModelAttribute UserModel user, AnggotaModel anggota
    ) {
        Boolean passwordChecker = userService.passwordRegexChecker(user.getPassword());
        if (passwordChecker) {

            userService.addUser(user);
            String nia = "";
            Random random = new Random();

            for(int i = 0; i < 8; i++) {
                int x = random.nextInt(10);
                nia += String.valueOf(x);
            }
            anggota.setNia(nia);
            anggota.setKtp(anggota.getKtp());
            anggota.setUser(user);
            anggotaService.addAnggota(anggota);


//            userService.addUser(user);
            if(user.getRole().getNama().equals("Kepala Sekolah") || user.getRole().getNama().equals("Guru")) {
                userRestService.postUserGuruToSiSivitas(userRestService.postGuruDetail(user, anggota));
                return "redirect:/";
            }
            else if (user.getRole().getNama().equals("Admin TU") || user.getRole().getNama().equals("Pustakawan")
                    || user.getRole().getNama().equals("Pengurus Koperasi")
                    || user.getRole().getNama().equals("Anggota Koperasi")) {
                userRestService.postUserPegawaiToSiSivitas(userRestService.postPegawaiDetail(user, anggota));
                return "redirect:/";
            }

            userRestService.postUserSiswaToSiSivitas(userRestService.postSiswaDetail(user, anggota));
            return "redirect:/";
        }
        String message = "Password harus terdiri dari setidaknya 1 huruf dan 1 angka dan terdiri dari setidaknya 8 karakter";
        attributes.addFlashAttribute("notification", message);
        return "redirect:/";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    private String changePasswordForm(
    ) {
        return "change-password";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    private String changePasswordSumbit(
            @RequestParam("newPassword") String newPassword,
            @RequestParam("retypePassword") String retypePassword,
            @RequestParam("oldPassword") String oldPassword,
            RedirectAttributes attributes
    ) {
        UserModel user = userService.getUser();
        if (userService.passwordValidChecker(user, oldPassword)) {
            if (newPassword.equals(retypePassword)) {
                UserModel newUser = userService.changePassword(user, newPassword);
                return "redirect:/";
            }
        }

        String message = "Proses Gagal, Ulang Kembali Penggantian Password";
        attributes.addFlashAttribute("notification", message);
        return "redirect:/user/changePassword";
    }
    
    @RequestMapping(value ="/profile", method = RequestMethod.GET)
    private String getProfile(Model model) {
   	    UserModel user = userService.getUser();
    	boolean isSivitas = false;
    	boolean isPegawai = false;
    	boolean isGuru = false;
    	try {
    		
    		UserDetail pegawai = userRestService.getEmployee(user.getId()).block().getResult();
    		isSivitas = true;
    		isPegawai = true;
    		model.addAttribute("sivitas", pegawai);
    	} catch (WebClientResponseException.NotFound e)	{
    		try {
    			
    			UserDetail guru = userRestService.getTeacher(user.getId()).block().getResult();
        		isSivitas = true;
        		isGuru = true;
            	model.addAttribute("sivitas", guru);
    		} catch (WebClientResponseException.NotFound er) {
    		}
    	} 
    	model.addAttribute("isSivitas", isSivitas);
    	model.addAttribute("isPegawai", isPegawai);
        model.addAttribute("isGuru", isGuru);
        model.addAttribute("user", user);
    	return "user-profile";
    	
    }
}

