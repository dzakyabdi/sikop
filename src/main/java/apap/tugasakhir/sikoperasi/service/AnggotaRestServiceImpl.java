package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.repository.AnggotaDB;
import apap.tugasakhir.sikoperasi.repository.SimpananDB;
import apap.tugasakhir.sikoperasi.repository.UserDB;
import apap.tugasakhir.sikoperasi.rest.AnggotaDetail;
import apap.tugasakhir.sikoperasi.rest.Setting;
import jdk.jfr.SettingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;



import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class AnggotaRestServiceImpl implements AnggotaRestService{

    public AnggotaRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.anggotaUrl).build();
    }

    private final WebClient webClient;

    @Autowired
    SimpananDB simpananDB;

    @Autowired
    UserDB userDB;

    @Override
    public Map<String, Object> getAnggotaByIdAPI(String id){
        HashMap<String, Object> result = new HashMap<>();
        AnggotaModel anggota = userDB.findById(id).getAnggota();
        result.put("id", anggota.getId());
        result.put("nama", anggota.getNama());
        result.put("nia", anggota.getNia());
        result.put("is_pengurus", anggota.getIs_pengurus());
        result.put("total_simpanan", (simpananDB.sumSimpanan(anggota)));
        return result;
    }
}
