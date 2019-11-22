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
    public String addPeminjamanRuangForm(Model model) {
        model.addAttribute("listRuangan", ruanganRestService.getListRuangan());
        return "form-add-peminjaman-ruang";
    }

    @RequestMapping(value = "/peminjaman", method = RequestMethod.POST)
    public String addPeminjamanRuangSumbit(
            @ModelAttribute PeminjamanDetail peminjamanDetail,
            @ModelAttribute RuanganDetail ruanganDetail,
            Model model
    ) {
        peminjamanDetail.setRuangan(ruanganDetail);
        JSONObject jsonObject = ruanganRestService.convertToJSONObject(peminjamanDetail, ruanganDetail);

        ruanganRestService.postPeminjamanRuang(jsonObject).block();

        return "action-success";
    }





}
