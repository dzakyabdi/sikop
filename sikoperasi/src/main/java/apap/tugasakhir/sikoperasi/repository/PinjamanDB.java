package apap.tugasakhir.sikoperasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tugasakhir.sikoperasi.model.PinjamanModel;

@Repository
public interface PinjamanDB extends JpaRepository<PinjamanModel, Long> {

}
