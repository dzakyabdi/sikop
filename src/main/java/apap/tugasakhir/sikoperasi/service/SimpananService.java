package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.SimpananModel;

import java.util.List;

public interface SimpananService {
    void addSimpanan(SimpananModel simpanan);
    List<SimpananModel> getAllSimpananByAnggota(AnggotaModel anggota);
    int sumSimpanan(AnggotaModel anggota);
}
