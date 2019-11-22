package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.rest.UserDetail;
import org.apache.catalina.User;
import reactor.core.publisher.Mono;

public interface UserRestService {
    Mono<UserDetail> postUser(UserDetail user);
    UserDetail postUserDetail(UserModel user, AnggotaModel anggota);
    String generateNomorInduk(AnggotaModel anggota, UserModel user);
    UserDetail postUserAnggotaToSiSivitas(UserDetail userDetail);
}
