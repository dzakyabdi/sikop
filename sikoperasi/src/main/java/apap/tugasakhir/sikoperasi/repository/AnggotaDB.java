package apap.tugasakhir.sikoperasi.repository;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnggotaDB extends JpaRepository<AnggotaModel, Long> {
    Optional<AnggotaModel> findById(Long id);
}
