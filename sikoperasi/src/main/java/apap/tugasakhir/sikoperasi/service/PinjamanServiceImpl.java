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
public class PinjamanServiceImpl implements PinjamanService{

    @Autowired
    private PinjamanDB pinjamanDB;

    @Override
    public List<PinjamanModel> getPinjamanList(){
        return pinjamanDB.findAllByOrderByIdAsc();
    }

    @Override
    public PinjamanModel getPinjamanByAnggota(AnggotaModel anggota){
        return pinjamanDB.findByAnggota(anggota);
    }

    @Override
    public PinjamanModel getPinjamanById(Long id){return pinjamanDB.findById(id).get();}
}
