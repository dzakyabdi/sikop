package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.PinjamanModel;

import java.util.List;

public interface PinjamanService {
    List<PinjamanModel> getAllPinjamanPengurus(int status);
    List<PinjamanModel> getAllPinjamanAnggota(int status, AnggotaModel anggota);
}
