package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.repository.PinjamanDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PinjamanServiceImpl implements PinjamanService {
    @Autowired
    private PinjamanDB pinjamanDB;

    @Override
    public List<PinjamanModel> getAllPinjamanPengurus(int status) {
        List<PinjamanModel> listPinjamanPengurus = pinjamanDB.findAllByStatus(status);
        return listPinjamanPengurus;
    }

    @Override
    public List<PinjamanModel> getAllPinjamanAnggota(int status, AnggotaModel anggota) {
        List<PinjamanModel> listPinjamanAnggota = pinjamanDB.findAllByStatusAAndAndAnggota(status, anggota);
        return listPinjamanAnggota;
    }
}
