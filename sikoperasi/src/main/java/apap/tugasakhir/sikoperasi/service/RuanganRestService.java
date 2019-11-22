package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.rest.PeminjamanDetail;
import org.json.JSONObject;

import java.util.Map;

public interface RuanganRestService {
    PeminjamanDetail postPeminjamanRuang(JSONObject jsonObject);
    JSONObject convertToJSONObject(String idRuang,
                                   String waktuMulai,
                                   String waktuSelesai,
                                   String tanggalMulai,
                                   String tanggalSelesai,
                                   String tujuan,
                                   String jumlahPeserta,
                                   String keterangan,
                                   String nomorSurat,
                                   String uuid_user_peminjam);

}
