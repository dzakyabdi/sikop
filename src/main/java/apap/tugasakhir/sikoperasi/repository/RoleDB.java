package apap.tugasakhir.sikoperasi.repository;

import apap.tugasakhir.sikoperasi.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDB extends JpaRepository<RoleModel, Long> {
}
