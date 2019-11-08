package apap.tugasakhir.sikoperasi.repository;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.SimpananModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimpananDB extends JpaRepository<SimpananModel, Long> {
    List<SimpananModel> findAllByAnggotaPenyetor(AnggotaModel anggotaPenyetor);

    @Query(value = "SELECT sum(m.jumlah) FROM SimpananModel m")
    int sumSimpanan();
}
