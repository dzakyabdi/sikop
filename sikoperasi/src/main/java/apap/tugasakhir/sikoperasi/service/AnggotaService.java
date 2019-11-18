package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
//import apap.tugasakhir.sikoperasi.model.UserModel;

public interface AnggotaService {
    AnggotaModel getAnggotaByNia(String nia);
    AnggotaModel getAnggotaById(Long id);
//    AnggotaModel getAnggotaByUser(UserModel user);
    void addAnggota(AnggotaModel anggota);
}
