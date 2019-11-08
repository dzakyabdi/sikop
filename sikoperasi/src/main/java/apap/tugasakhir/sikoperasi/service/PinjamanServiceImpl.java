package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.repository.PinjamanDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PinjamanServiceImpl implements PinjamanService {
    @Autowired
    private PinjamanDB pinjamanDB;

    @Override
    public List<PinjamanModel> getAllPinjamanByStatus(int status) {
        List<PinjamanModel> listPinjamanPengurus = pinjamanDB.findAllByStatus(status);
        return listPinjamanPengurus;
    }

    @Override
    public List<PinjamanModel> getAllPinjamanByStatusAndAnggota(int status, AnggotaModel anggota) {
        List<PinjamanModel> listPinjamanAnggota = pinjamanDB.findAllByStatusAndAnggota(status, anggota);
        return listPinjamanAnggota;
    }

    @Override
    public int getStatusPinjaman(String status) {
        List<String> listStatus = new ArrayList<>(List.of("Menunggu persetujuan",
                                                    "Ditolak",
                                                    "Disetujui",
                                                    "Sudah diambil",
                                                    "Sudah dikembalikan",
                                                    "Overdue"));
        int statusCode = listStatus.indexOf(status);
        return statusCode;
    }

    @Override
    public int sumPinjaman(AnggotaModel anggota) {
        if (pinjamanDB.sumPinjaman(anggota) == null){
            return 0;
        }
        return pinjamanDB.sumPinjaman(anggota);
    }
}
