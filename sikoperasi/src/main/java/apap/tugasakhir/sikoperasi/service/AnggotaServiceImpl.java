package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.repository.AnggotaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnggotaServiceImpl implements AnggotaService{
    @Autowired
    private AnggotaDB anggotaDb;

    @Override
    public AnggotaModel getAnggotaById(Long id) {
        return anggotaDb.findById(id).get();
    }
}
