package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.rest.PeminjamanDetail;
import apap.tugasakhir.sikoperasi.service.RuanganRestService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ruangan")
public class RuanganController {

    @Autowired
    private RuanganRestService ruanganRestService;

    @RequestMapping(value = "/peminjaman", method = RequestMethod.GET)
    public String addPeminjamanRuangForm() {
        return "form-add-peminjaman-ruang";
    }

    @RequestMapping(value = "/tambah", method = RequestMethod.POST,
    params = {"idRuang", "waktuMulai" , "waktuSelesai", "tanggalMulai",
            "tanggalSelesai", "tujuan", "jumlahPeserta", "keterangan",
            "nomorSurat", "uuid_user_peminjam"}
    )
    public String addPeminjamanRuangSumbit(
            Model model,
            HttpServletRequest req
    ) {
        String idRuang = req.getParameter("idRuang");
        String waktuMulai = req.getParameter("waktuMulai");
        String waktuSelesai = req.getParameter("waktuSelesai");
        String tanggalMulai = req.getParameter("tanggalMulai");
        String tanggalSelesai = req.getParameter("tanggalSelesai");
        String tujuan = req.getParameter("tujuan");
        String jumlahPeserta = req.getParameter("jumlahPeserta");
        String keterangan = req.getParameter("keterangan");
        String nomorSurat = req.getParameter("nomorSurat");
        String uuid_user_peminjam = req.getParameter("uuid_user_peminjam");

        JSONObject jsonObject = ruanganRestService.convertToJSONObject( idRuang, waktuMulai, waktuSelesai, tanggalMulai,
                                                                        tanggalSelesai, tujuan, jumlahPeserta, keterangan,
                                                                        nomorSurat, uuid_user_peminjam);

        PeminjamanDetail peminjamanDetail = ruanganRestService.postPeminjamanRuang(jsonObject);
        System.out.println(peminjamanDetail.getIdRuang());

        return "action-success";
    }

    @RequestMapping(value = "/listRuangan",  method = RequestMethod.GET)
    public String getListRuangan(

    ) {
        return ruanganRestService.
    }


}
