package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.model.SimpananModel;
//import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.service.AnggotaService;
import apap.tugasakhir.sikoperasi.service.PinjamanService;
import apap.tugasakhir.sikoperasi.service.SimpananService;
//import apap.tugasakhir.sikoperasi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class LaporanKeuanganController {
    @Autowired
    private PinjamanService pinjamanService;

    @Autowired
    @Qualifier("simpananServiceImpl")
    private SimpananService simpananService;

    @Autowired
    @Qualifier("anggotaServiceImpl")
    private AnggotaService anggotaService;

//    @Autowired
//    @Qualifier("userServiceImpl")
//    private UserService userService;

    @RequestMapping("/laporan-keuangan")
    public String viewDokter(
            @RequestParam("nia") String nia,
            Model model
    ) {
//        UserModel userNow = userService.getUser();
//        AnggotaModel anggotaNow = anggotaService.getAnggotaByUser(userNow);
        AnggotaModel anggotaNow = anggotaService.getAnggotaByNia(nia);
        List<SimpananModel> listSimpanan = simpananService.getAllSimpananByAnggota(anggotaNow);
        List<PinjamanModel> listPinjaman = pinjamanService.getAllPinjamanByStatusAndAnggota(pinjamanService.getStatusPinjaman("Disetujui"), anggotaNow);
        int jumlahSimpanan = simpananService.sumSimpanan(anggotaNow);
        int jumlahPinjaman = pinjamanService.sumPinjaman(anggotaNow);
        model.addAttribute("listSimpanan",listSimpanan);
        model.addAttribute("listPinjaman",listPinjaman);
        model.addAttribute("jumlahSimpanan",jumlahSimpanan);
        model.addAttribute("jumlahPinjaman",jumlahPinjaman);
        return "view-laporan-keuangan";
    }

}
