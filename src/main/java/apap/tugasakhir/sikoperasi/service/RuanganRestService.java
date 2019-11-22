package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.rest.PeminjamanDetail;
import apap.tugasakhir.sikoperasi.rest.RuanganDetail;
import org.json.JSONObject;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RuanganRestService {
    Mono<PeminjamanDetail> postPeminjamanRuang(JSONObject jsonObject);
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
    JSONObject convertToJSONObject(PeminjamanDetail peminjamanDetail, RuanganDetail ruanganDetail);
    List<RuanganDetail> getListRuangan();
}
