package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.PinjamanModel;

import java.util.List;

public interface PinjamanService {
    List<PinjamanModel> getAllPinjamanByStatus(int status);
    List<PinjamanModel> getAllPinjamanByStatusAndAnggota(int status, AnggotaModel anggota);
    int getStatusPinjaman(String status);
    int sumPinjaman(AnggotaModel anggota);
}
