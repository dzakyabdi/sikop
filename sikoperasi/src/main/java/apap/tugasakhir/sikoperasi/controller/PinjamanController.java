package apap.tugasakhir.sikoperasi.controller;

import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.service.PinjamanService;
import org.hibernate.tool.hbm2ddl.SchemaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PinjamanController {
    @Qualifier("pinjamanServiceImpl")
    @Autowired
    private PinjamanService pinjamanService;

    @RequestMapping(value = "/")
    public String homepage(){
        return "homepage";
    }

    @RequestMapping(value = "/pinjaman/view-all", method = RequestMethod.GET)
    public String viewPinjamanList(Model model){
        List<PinjamanModel> pinjamanList =  pinjamanService.getPinjamanList();
        model.addAttribute("pinjamanList",pinjamanList);
        return "view-all-pinjaman";
    }

    @RequestMapping(value = "/pinjaman/view", method = RequestMethod.GET)
    public String viewPinjaman(@RequestParam(value = "id") Long id, Model model){
        PinjamanModel pinjaman =  pinjamanService.getPinjamanById(id);
        model.addAttribute(pinjaman);
        return "view-pinjaman";
    }
}
