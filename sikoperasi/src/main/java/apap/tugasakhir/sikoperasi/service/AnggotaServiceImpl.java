package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.repository.AnggotaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AnggotaServiceImpl implements AnggotaService {
    @Autowired
    private AnggotaDB anggotaDB;

    @Override
    public AnggotaModel getAnggotaByNia(String nia) {
        AnggotaModel anggota = anggotaDB.findByNia(nia);
        return anggota;
    }

//    @Override
//    public AnggotaModel getAnggotaByUser(UserModel user) {
//        AnggotaModel anggota = anggotaDB.findByUser(user);
//        return anggota;
//    }
}
