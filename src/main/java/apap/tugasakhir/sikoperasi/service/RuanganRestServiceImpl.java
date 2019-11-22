package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.rest.PeminjamanDetail;
import apap.tugasakhir.sikoperasi.rest.RuanganDetail;
import apap.tugasakhir.sikoperasi.rest.Setting;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RuanganRestServiceImpl implements RuanganRestService {
    private  final WebClient webClient;

    public RuanganRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.dummyUrl).build();
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
    public JSONObject convertToJSONObject(PeminjamanDetail peminjamanDetail) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("idRuang", peminjamanDetail.getIdRuang());
        jsonObject.put("waktuMulai", peminjamanDetail.getWaktuMulai());
        jsonObject.put("waktuSelesai", peminjamanDetail.getWaktuSelesai());
        jsonObject.put("tanggalMulai", peminjamanDetail.getTanggalMulai());
        jsonObject.put("tanggalSelesai", peminjamanDetail.getTanggalSelesai());
        jsonObject.put("tujuan", peminjamanDetail.getTujuan());
        jsonObject.put("jumlahPeserta", peminjamanDetail.getJumlahPeserta());
        jsonObject.put("keterangan", peminjamanDetail.getKeterangan());
        jsonObject.put("nomorSurat", peminjamanDetail.getNomorSurat());
        jsonObject.put("uuid_user_peminjam", peminjamanDetail.getUuidUserPeminjam());
        return jsonObject;
    }

    @Override
    public Mono<List<RuanganDetail>> getListRuangan() {
        return this.webClient.get()
                .uri("/ruangan/")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(RuanganDetail.class)
                .collectList()
                .log();
    }
}
