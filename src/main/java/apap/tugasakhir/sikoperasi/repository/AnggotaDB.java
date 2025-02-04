package apap.tugasakhir.sikoperasi.repository;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
//import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnggotaDB extends JpaRepository<AnggotaModel, Long> {
    AnggotaModel findByNia(String nia);
    Optional<AnggotaModel> findById(Long id);
    Optional<AnggotaModel> findByUser(UserModel user);

}
