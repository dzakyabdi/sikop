package apap.tugasakhir.sikoperasi.repository;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.SimpananModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SimpananDB extends JpaRepository<SimpananModel, Long> {
    List<SimpananModel> findAllByAnggotaPenyetor(AnggotaModel anggotaPenyetor);

    @Query(value = "SELECT sum(m.jumlah) FROM SimpananModel m WHERE m.anggotaPenyetor = ?1")
    Integer sumSimpanan(AnggotaModel anggota);
    Optional<SimpananModel> findById(Long id);
    List<SimpananModel> findAll();
}
