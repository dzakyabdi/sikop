package apap.tugasakhir.sikoperasi.repository;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinjamanDB extends JpaRepository<PinjamanModel, Long> {
    List<PinjamanModel> findAllByStatus(int status);
    List<PinjamanModel> findAllByStatusAndAnggota(int status, AnggotaModel anggota);
    @Query(value = "SELECT SUM(m.jumlahPinjaman) FROM PinjamanModel m")
    int sumPinjaman();
}
