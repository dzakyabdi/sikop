package apap.tugasakhir.sikoperasi.repository;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface PinjamanDB extends JpaRepository<PinjamanModel, Long> {
    List<PinjamanModel> findAllByOrderByIdAsc();

    PinjamanModel findByAnggota(AnggotaModel anggota);

    Optional<PinjamanModel> findById(Long id);

    List<PinjamanModel> findAllByStatus(int status);

    List<PinjamanModel> findAllByStatusAndAnggota(int status, AnggotaModel anggota);

    @Query(value = "SELECT SUM(m.jumlahPinjaman) FROM PinjamanModel m WHERE m.anggota = ?1")
    Integer sumPinjaman(AnggotaModel anggota);

}
