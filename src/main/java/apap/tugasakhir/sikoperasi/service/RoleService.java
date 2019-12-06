package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.RoleModel;

import java.util.List;

public interface RoleService {
    List<RoleModel> findAll();
    public RoleModel getRoleById(Long id);
}
