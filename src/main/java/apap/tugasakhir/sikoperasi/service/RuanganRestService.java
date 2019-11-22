package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.rest.PeminjamanDetail;
import apap.tugasakhir.sikoperasi.rest.RuanganDetail;
import org.json.JSONObject;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public interface RuanganRestService {
    PeminjamanDetail postPeminjamanRuang(JSONObject jsonObject);
//    JSONObject convertToJSONObject(String idRuang,
//                                   String waktuMulai,
//                                   String waktuSelesai,
//                                   String tanggalMulai,
//                                   String tanggalSelesai,
//                                   String tujuan,
//                                   String jumlahPeserta,
//                                   String keterangan,
//                                   String nomorSurat,
//                                   String uuid_user_peminjam);
    JSONObject convertToJSONObject(PeminjamanDetail peminjamanDetail);
    public Mono<List<RuanganDetail>> getListRuangan();
}
