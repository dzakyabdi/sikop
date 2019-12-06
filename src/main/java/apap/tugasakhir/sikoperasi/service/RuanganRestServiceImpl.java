package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.rest.*;
import apap.tugasakhir.sikoperasi.rest.PeminjamanDetail;
import apap.tugasakhir.sikoperasi.rest.RuanganDetail;
import apap.tugasakhir.sikoperasi.rest.RuanganNamaDetail;
import apap.tugasakhir.sikoperasi.rest.Setting;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RuanganRestServiceImpl implements RuanganRestService {
    private final WebClient webClient;

    public RuanganRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.dummyUrl).build();
    }

    @Override
    public Mono<PeminjamanDetail> postPeminjamanRuang(JSONObject jsonObject) {
        String jsonReqBody = jsonObject.toString();
        System.out.println(jsonReqBody);

        return this.webClient.post()
                .uri("/ruangan/peminjaman/tambah")
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody(jsonReqBody)
                .retrieve()
                .bodyToMono(PeminjamanDetail.class);
    }

    @Override
    public JSONObject convertToJSONObject(PeminjamanDetail peminjamanDetail, RuanganDetail ruanganDetail) {
        JSONObject jsonObjectRuangan = new JSONObject();
        jsonObjectRuangan.put("id", peminjamanDetail.getRuangan().getId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ruangan", jsonObjectRuangan);
        jsonObject.put("waktuMulai", peminjamanDetail.getWaktuMulai());
        jsonObject.put("waktuSelesai", peminjamanDetail.getWaktuSelesai());
        jsonObject.put("tanggalMulai", peminjamanDetail.getTanggalMulai().toString());
        jsonObject.put("tanggalSelesai", peminjamanDetail.getTanggalSelesai().toString());
        jsonObject.put("tujuan", peminjamanDetail.getTujuan());
        jsonObject.put("jumlahPeserta", peminjamanDetail.getJumlahPeserta());
        jsonObject.put("keterangan", peminjamanDetail.getKeterangan());
//        jsonObject.put("nomorSurat", peminjamanDetail.getNomorSurat());
//        jsonObject.put("uuid_user_peminjam", peminjamanDetail.getUuidUserPeminjam());
        return jsonObject;
    }

    @Override
    public List<RuanganDetail> getListRuangan() {
        List<RuanganDetail> listRuanganDetail = this.webClient.get()
                .uri("/ruangan/")
                .retrieve()
                .bodyToFlux(RuanganDetail.class)
                .collectList()
                .block();
        return listRuanganDetail;
    }

    @Override
    public List<FasilitasDetail> getFasilitas() {
        return this.webClient.get()
                .uri("/fasilitas/koperasi")
                .retrieve()
                .bodyToFlux(FasilitasDetail.class)
                .collectList()
                .block();
    }

    public List<RuanganNamaDetail> getListRuanganWithNama() {
        List<RuanganNamaDetail> listRuanganDetail = this.webClient.get()
                .uri("/ruangan/")
                .retrieve()
                .bodyToFlux(RuanganNamaDetail.class)
                .collectList()
                .block();
        return listRuanganDetail;
    }

}
