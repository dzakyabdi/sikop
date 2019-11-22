package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;

import java.util.List;
//import apap.tugasakhir.sikoperasi.model.UserModel;

public interface AnggotaService {
    AnggotaModel getAnggotaByNia(String nia);
    AnggotaModel getAnggotaById(Long id);
//    AnggotaModel getAnggotaByUser(UserModel user);
    void addAnggota(AnggotaModel anggota);
    List<AnggotaModel> getAllAnggota();
}
