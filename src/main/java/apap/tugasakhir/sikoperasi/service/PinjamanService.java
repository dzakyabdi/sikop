package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.PinjamanModel;

import java.util.List;
import java.util.Optional;

public interface PinjamanService {
    List<PinjamanModel> getPinjamanList();

    List<PinjamanModel> getPinjamanListByAnggota(AnggotaModel anggota);

    PinjamanModel getPinjamanByAnggota(AnggotaModel anggota);

    Optional<PinjamanModel> getPinjamanById(Long id);

    List<PinjamanModel> getAllPinjamanByStatusAndAnggota(int status, AnggotaModel anggota);

    int getStatusPinjaman(String status);

    int sumPinjaman(AnggotaModel anggota);

    List<PinjamanModel> getAllPinjamanByStatus(int status);

    void addPinjaman(PinjamanModel pinjaman);

    PinjamanModel updatePinjaman(PinjamanModel newPinjaman);

}
