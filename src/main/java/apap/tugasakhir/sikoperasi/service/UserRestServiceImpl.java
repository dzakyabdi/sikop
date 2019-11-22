package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.repository.UserDB;
import apap.tugasakhir.sikoperasi.rest.Setting;
import apap.tugasakhir.sikoperasi.rest.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Random;

public class UserRestServiceImpl implements UserRestService{
    private final WebClient webClient;

    @Autowired
    private UserDB userDB;

    public UserRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.userUrl).build();
    }

    @Override
    public Mono<UserDetail> postUser(UserDetail user) {
        return this.webClient.post().uri("/employees")
                .syncBody(user)
                .retrieve()
                .bodyToMono(UserDetail.class);
    }

    @Override
    public UserDetail postUserAnggotaToSiSivitas(UserDetail userDetail) {
        return this.webClient
                .post()
                .uri("/employees")
                .syncBody(userDetail)
                .retrieve()
                .bodyToMono(UserDetail.class)
                .block();
    }


    @Override
    public UserDetail postUserDetail(UserModel user, AnggotaModel anggota) {
        UserDetail postUser = new UserDetail();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        postUser.setUuid(user.getId());
        postUser.setNip(generateNomorInduk(anggota,user));
        postUser.setNama(anggota.getNama());
        postUser.setTempatLahir(anggota.getTempat_lahir());
        postUser.setTanggalLahir(formatter.format(anggota.getTanggal_lahir()));
        postUser.setAlamat(anggota.getAlamat());
        postUser.setTelepon(anggota.getNomor_telepon());

        return postUser;
    }

    @Override
    public String generateNomorInduk(AnggotaModel anggota, UserModel user) {
        String nomorInduk = user.getRole().getNama().substring(0,1);

        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        nomorInduk += formatter.format(anggota.getTanggal_lahir());

        Random random = new Random();

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < 2; i++) {
            nomorInduk += alphabet.charAt(random.nextInt(alphabet.length()));
        }

        for(int i = 0; i < 3; i++) {
            int x = random.nextInt(10);
            nomorInduk += String.valueOf(x);
        }

        nomorInduk += user.getId();

        return nomorInduk;
    }
}
