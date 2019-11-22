package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.rest.PeminjamanDetail;
import apap.tugasakhir.sikoperasi.rest.Setting;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.Map;

@Service
@Transactional
public class RuanganRestServiceImpl implements RuanganRestService {
    private  final WebClient webClient;

    public RuanganRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.ruanganUrl).build();
    }

    @Override
    public PeminjamanDetail postPeminjamanRuang(JSONObject jsonObject) {
        String jsonReqBody = jsonObject.toString();
        System.out.println(jsonReqBody);

        return this.webClient.post()
                .uri("/ruang/peminjaman")
                .syncBody(jsonReqBody)
                .retrieve()
                .bodyToMono(PeminjamanDetail.class).block();
    }

    @Override
    public JSONObject convertToJSONObject(String idRuang,
                                          String waktuMulai,
                                          String waktuSelesai,
                                          String tanggalMulai,
                                          String tanggalSelesai,
                                          String tujuan,
                                          String jumlahPeserta,
                                          String keterangan,
                                          String nomorSurat,
                                          String uuid_user_peminjam) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("idRuang", idRuang);
        jsonObject.put("waktuMulai", waktuMulai);
        jsonObject.put("waktuSelesai", waktuSelesai);
        jsonObject.put("tanggalMulai", tanggalMulai);
        jsonObject.put("tanggalSelesai", tanggalSelesai);
        jsonObject.put("tujuan", tujuan);
        jsonObject.put("jumlahPeserta", jumlahPeserta);
        jsonObject.put("keterangan", keterangan);
        jsonObject.put("nomorSurat", nomorSurat);
        jsonObject.put("uuid_user_peminjam", uuid_user_peminjam);
        return jsonObject;
    }
}
