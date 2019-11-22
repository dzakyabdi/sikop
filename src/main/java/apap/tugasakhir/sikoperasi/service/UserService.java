package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.UserModel;

public interface UserService {
    UserModel getUserById(String id);
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    UserModel getUser();
    Boolean passwordValidChecker(UserModel user, String passwordd);
    UserModel changePassword(UserModel user, String password);
    Boolean passwordRegexChecker(String password);
}
