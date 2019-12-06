package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.rest.FasilitasDetail;
import apap.tugasakhir.sikoperasi.rest.PeminjamanDetail;
import apap.tugasakhir.sikoperasi.rest.RuanganDetail;
import org.json.JSONObject;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RuanganRestService {
    Mono<PeminjamanDetail> postPeminjamanRuang(JSONObject jsonObject);
    JSONObject convertToJSONObject(PeminjamanDetail peminjamanDetail, RuanganDetail ruanganDetail);
    List<RuanganDetail> getListRuangan();
    Mono<FasilitasDetail> getFasilitas();
//    Mono<String> getFasilitas();

}
