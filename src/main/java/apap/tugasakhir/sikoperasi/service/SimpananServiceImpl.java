package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.SimpananModel;
import apap.tugasakhir.sikoperasi.repository.SimpananDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SimpananServiceImpl implements SimpananService {
    @Autowired
    private SimpananDB simpananDB;

    @Override
    public void addSimpanan(SimpananModel simpanan) {
        simpananDB.save(simpanan);
    }

    @Override
    public List<SimpananModel> getAllSimpananByAnggota(AnggotaModel anggota) {
        List<SimpananModel> listSimpanan = simpananDB.findAllByAnggotaPenyetor(anggota);
        return listSimpanan;
    }

    @Override
    public int sumSimpanan(AnggotaModel anggota) {
        if (simpananDB.sumSimpanan(anggota) == null){
            return 0;
        }
        return simpananDB.sumSimpanan(anggota);
    }

    @Override
    public SimpananModel getSimpananById(Long id){
        return simpananDB.findById(id).get();
    }

    @Override
    public SimpananModel updateSimpanan(SimpananModel newSimpanan){
        SimpananModel targetSimpanan = simpananDB.findById(newSimpanan.getId()).get();
        try{
            targetSimpanan.setTanggal_setor(newSimpanan.getTanggal_setor());
            targetSimpanan.setJumlah(newSimpanan.getJumlah());
            targetSimpanan.setJenisSimpanan(newSimpanan.getJenisSimpanan());
            targetSimpanan.setAnggotaPenyetor(newSimpanan.getAnggotaPenyetor());
            return targetSimpanan;
        }catch (NullPointerException e){
            return null;
        }
    }

    @Override
    public List<SimpananModel> getAllSimpanan(){
        return simpananDB.findAll();
    }
}
