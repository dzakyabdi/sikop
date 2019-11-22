package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
//import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.repository.AnggotaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnggotaServiceImpl implements AnggotaService {
    @Autowired
    private AnggotaDB anggotaDb;

    @Override
    public AnggotaModel getAnggotaByNia(String nia) {
        AnggotaModel anggota = anggotaDb.findByNia(nia);
        return anggota;
    }

    @Override
    public AnggotaModel getAnggotaById(Long id) {
        return anggotaDb.findById(id).get();
    }

    @Override
    public void addAnggota(AnggotaModel anggota) {
        anggotaDb.save(anggota);
    }
    
    @Override
    public List<AnggotaModel> getAllAnggota(){
    	return anggotaDb.findAll();
    }

    //    @Override
//    public AnggotaModel getAnggotaByUser(UserModel user) {
//        AnggotaModel anggota = anggotaDB.findByUser(user);
//        return anggota;
//    }
}
