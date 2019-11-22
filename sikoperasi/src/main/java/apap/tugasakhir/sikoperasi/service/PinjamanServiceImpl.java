package apap.tugasakhir.sikoperasi.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import apap.tugasakhir.sikoperasi.repository.PinjamanDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PinjamanServiceImpl implements PinjamanService{

    @Autowired
    private PinjamanDB pinjamanDb;

    @Override
    public List<PinjamanModel> getPinjamanList(){
        return pinjamanDb.findAllByOrderByIdAsc();
    }

    @Override
    public PinjamanModel getPinjamanByAnggota(AnggotaModel anggota){
        return pinjamanDb.findByAnggota(anggota);
    }

    @Override
    public Optional<PinjamanModel> getPinjamanById(Long id){
        return pinjamanDb.findById(id);
    }

    @Override
    public List<PinjamanModel> getAllPinjamanByStatus(int status) {
        List<PinjamanModel> listPinjamanPengurus = pinjamanDb.findAllByStatus(status);
        return listPinjamanPengurus;
    }

    @Override
    public List<PinjamanModel> getAllPinjamanByStatusAndAnggota(int status, AnggotaModel anggota) {
        List<PinjamanModel> listPinjamanAnggota = pinjamanDb.findAllByStatusAndAnggota(status, anggota);
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
        if (pinjamanDb.sumPinjaman(anggota) == null){
            return 0;
        }
        return pinjamanDb.sumPinjaman(anggota);
    }

    @Override
    public PinjamanModel updatePinjaman(PinjamanModel newPinjaman){
        PinjamanModel targetPinjaman = pinjamanDb.findById(newPinjaman.getId()).get();
            targetPinjaman.setJumlahPengembalian(newPinjaman.getJumlahPengembalian());
            targetPinjaman.setStatus(newPinjaman.getStatus());
            if (targetPinjaman.getStatus() == 1){
                Date date = new Date(System.currentTimeMillis());
                Calendar curr = Calendar.getInstance();
                curr.setTime(date);
                curr.add(Calendar.YEAR,1 );
                targetPinjaman.setTanggalDisetujui(date);
                targetPinjaman.setTanggalPengembalian(curr.getTime());
                System.out.println(curr);
                System.out.println(date);
            }else if(newPinjaman.getJumlahPengembalian() >= newPinjaman.getJumlahPinjaman()){
                targetPinjaman.setStatus(2);
            }return pinjamanDb.save(newPinjaman);
    }
}
