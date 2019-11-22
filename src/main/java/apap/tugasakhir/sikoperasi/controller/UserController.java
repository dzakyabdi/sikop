package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSumbit(
            RedirectAttributes attributes,
            @ModelAttribute UserModel user
    ) {
        Boolean passwordChecker = userService.passwordRegexChecker(user.getPassword());
        if (passwordChecker) {
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

