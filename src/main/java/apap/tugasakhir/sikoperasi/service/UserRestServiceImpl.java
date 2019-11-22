package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.repository.UserDB;
import apap.tugasakhir.sikoperasi.rest.GuruDetail;
import apap.tugasakhir.sikoperasi.rest.Setting;
import apap.tugasakhir.sikoperasi.rest.PegawaiDetail;
import apap.tugasakhir.sikoperasi.rest.SiswaDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Random;

@Service
public class UserRestServiceImpl implements UserRestService{
    private final WebClient webClient;

    @Autowired
    private UserDB userDB;

    public UserRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.userUrl).build();
    }

    @Override
    public Mono<PegawaiDetail> postUser(PegawaiDetail user) {
        return this.webClient.post().uri("/employees")
                .syncBody(user)
                .retrieve()
                .bodyToMono(PegawaiDetail.class);
    }

    @Override
    public PegawaiDetail postUserPegawaiToSiSivitas(PegawaiDetail pegawai) {
        return this.webClient
                .post()
                .uri("/employees")
                .syncBody(pegawai)
                .retrieve()
                .bodyToMono(PegawaiDetail.class)
                .block();
    }

    @Override
    public GuruDetail postUserGuruToSiSivitas(GuruDetail guru) {
        return this.webClient
                .post()
                .uri("/teachers")
                .syncBody(guru)
                .retrieve()
                .bodyToMono(GuruDetail.class)
                .block();
    }

    @Override
    public SiswaDetail postUserSiswaToSiSivitas(SiswaDetail siswa) {
        return this.webClient
                .post()
                .uri("/students")
                .syncBody(siswa)
                .retrieve()
                .bodyToMono(SiswaDetail.class)
                .block();
    }


    @Override
    public PegawaiDetail postPegawaiDetail(UserModel user, AnggotaModel anggota) {
        PegawaiDetail postUser = new PegawaiDetail();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        postUser.setIdUser(user.getId());
        postUser.setNip(generateNomorInduk(anggota,user));
        postUser.setNama(anggota.getNama());
        postUser.setTempatLahir(anggota.getTempat_lahir());
        postUser.setTanggalLahir(formatter.format(anggota.getTanggal_lahir()));
        postUser.setAlamat(anggota.getAlamat());
        postUser.setTelepon(anggota.getNomor_telepon());

        return postUser;
    }

    @Override
    public GuruDetail postGuruDetail(UserModel user, AnggotaModel anggota) {
        GuruDetail postUser = new GuruDetail();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        postUser.setIdUser(user.getId());
        postUser.setNig(generateNomorInduk(anggota,user));
        postUser.setNama(anggota.getNama());
        postUser.setTempatLahir(anggota.getTempat_lahir());
        postUser.setTanggalLahir(formatter.format(anggota.getTanggal_lahir()));
        postUser.setAlamat(anggota.getAlamat());
        postUser.setTelepon(anggota.getNomor_telepon());

        return postUser;
    }

    @Override
    public SiswaDetail postSiswaDetail(UserModel user, AnggotaModel anggota) {
        SiswaDetail postUser = new SiswaDetail();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        postUser.setIdUser(user.getId());
        postUser.setNis(generateNomorInduk(anggota,user));
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

        System.out.println(nomorInduk);

        return nomorInduk;
    }
}
