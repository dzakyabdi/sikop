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
}
