package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.rest.FasilitasDetail;
import apap.tugasakhir.sikoperasi.service.AnggotaService;
import apap.tugasakhir.sikoperasi.service.RuanganRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
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
    private RuanganRestService ruanganRestService;

    @RequestMapping(value = "/anggota/detail", method = RequestMethod.GET)
    public String detailAnggota(@RequestParam("id") Long id, Model model) {
        AnggotaModel anggota = anggotaService.getAnggotaById(id);

        model.addAttribute("anggota", anggota);
        return "detailAnggota";
    }

    @RequestMapping(value = "/anggota/tambah", method = RequestMethod.GET)
    public String tambahAnggotaFormPage(Model model) {
        AnggotaModel anggota = new AnggotaModel();

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
}
