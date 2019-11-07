package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public UserModel getUser() {
        Authentication rawDataUser = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = userDB.findByUsername(rawDataUser.getName());
        return user;
    }

    @Override
    public Boolean passwordValidChecker(UserModel user, String oldPass) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (passwordEncoder.matches(oldPass, user.getPassword())){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserModel changePassword(UserModel user, String newPass) {
        UserModel targetUser = userDB.findByUsername(user.getUsername());
        targetUser.setPassword(encrypt(newPass));
        userDB.save(targetUser);
        return targetUser;
    }

    @Override
    public Boolean passwordRegexChecker(String password) {
        String pattern  = "(?=.*\\d)(?=.*[a-zA-Z]).{8,}";
        System.out.println(password.matches(pattern));
        return password.matches(pattern);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }
}
