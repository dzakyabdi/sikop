package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.rest.PeminjamanDetail;
import apap.tugasakhir.sikoperasi.rest.RuanganDetail;
import apap.tugasakhir.sikoperasi.service.RuanganRestService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ruangan")
public class RuanganController {

    @Autowired
    private RuanganRestService ruanganRestService;

    @RequestMapping(value = "/peminjaman", method = RequestMethod.GET)
    public String addPeminjamanRuangForm() {
        return "form-add-peminjaman-ruang";
    }

    @RequestMapping(value = "/tambah", method = RequestMethod.POST)
    public String addPeminjamanRuangSumbit(
            @ModelAttribute PeminjamanDetail peminjamanDetail,
            Model model,
            HttpServletRequest req
    ) {
//        String idRuang = req.getParameter("idRuang");
//        String waktuMulai = req.getParameter("waktuMulai");
//        String waktuSelesai = req.getParameter("waktuSelesai");
//        String tanggalMulai = req.getParameter("tanggalMulai");
//        String tanggalSelesai = req.getParameter("tanggalSelesai");
//        String tujuan = req.getParameter("tujuan");
//        String jumlahPeserta = req.getParameter("jumlahPeserta");
//        String keterangan = req.getParameter("keterangan");
//        String nomorSurat = req.getParameter("nomorSurat");
//        String uuid_user_peminjam = req.getParameter("uuid_user_peminjam");

//        JSONObject jsonObject = ruanganRestService.convertToJSONObject( idRuang, waktuMulai, waktuSelesai, tanggalMulai,
//                                                                        tanggalSelesai, tujuan, jumlahPeserta, keterangan,
//                                                                        nomorSurat, uuid_user_peminjam);

        JSONObject jsonObject = ruanganRestService.convertToJSONObject(peminjamanDetail);

        ruanganRestService.postPeminjamanRuang(jsonObject);

        return "action-success";
    }

    @RequestMapping(value = "/listRuangan",  method = RequestMethod.GET)
    public Mono<List<RuanganDetail>> getListRuangan(
    ) {
        return ruanganRestService.getListRuangan();
    }




}
