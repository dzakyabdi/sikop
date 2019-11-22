package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.service.AnggotaService;
import apap.tugasakhir.sikoperasi.service.UserRestService;
import apap.tugasakhir.sikoperasi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("UserRestServiceImpl")
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
            String nia = "";
            Random random = new Random();

            for(int i = 0; i < 8; i++) {
                int x = random.nextInt(10);
                nia += String.valueOf(x);
            }
            anggota.setNia(nia);

            userRestService.postUserAnggotaToSiSivitas(userRestService.postUserDetail(user, anggota));
            anggotaService.addAnggota(anggota);
            userService.addUser(user);
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
}

