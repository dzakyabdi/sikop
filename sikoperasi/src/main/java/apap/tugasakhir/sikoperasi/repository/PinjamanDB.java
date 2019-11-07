package apap.tugasakhir.sikoperasi.repository;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.PinjamanModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PinjamanDB extends JpaRepository<PinjamanModel, Long> {
    List<PinjamanModel> findAllByStatus(int status);
    List<PinjamanModel> findAllByStatusAAndAndAnggota(int status, AnggotaModel anggota);
}
