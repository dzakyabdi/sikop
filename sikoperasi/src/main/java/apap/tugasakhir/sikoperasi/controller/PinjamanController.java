package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.service.AnggotaService;
import apap.tugasakhir.sikoperasi.service.PinjamanService;
import apap.tugasakhir.sikoperasi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;

@Controller
public class PinjamanController {
    @Autowired
    private PinjamanService pinjamanService;

    @Autowired
    @Qualifier("anggotaServiceImpl")
    private AnggotaService anggotaService;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @RequestMapping("/dokter")
    public String viewPeminjaman(
            Model model
    ) {
        UserModel user = userService.getUser();

        SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_lahir = formater.format(dokter.getTanggal_lahir());
        String headerMessage = "Informasi Dokter " + dokter.getNama();

        model.addAttribute("headerMessage", headerMessage);
        model.addAttribute("dokter", dokter);
        model.addAttribute("tanggal_lahir", tanggal_lahir);
        return "view-dokter";
    }
}
