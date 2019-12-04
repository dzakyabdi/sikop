package apap.tugasakhir.sikoperasi.repository;

import apap.tugasakhir.sikoperasi.model.JenisSimpananModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JenisSimpananDB extends JpaRepository<JenisSimpananModel, Long> {
    JenisSimpananModel findByNama(String Nama);
}
