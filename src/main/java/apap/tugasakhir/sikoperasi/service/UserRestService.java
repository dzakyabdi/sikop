package apap.tugasakhir.sikoperasi.service;

import apap.tugasakhir.sikoperasi.model.AnggotaModel;
import apap.tugasakhir.sikoperasi.model.UserModel;
import apap.tugasakhir.sikoperasi.rest.GuruDetail;
import apap.tugasakhir.sikoperasi.rest.PegawaiDetail;
import apap.tugasakhir.sikoperasi.rest.SiswaDetail;
import reactor.core.publisher.Mono;

public interface UserRestService {
    Mono<PegawaiDetail> postUser(PegawaiDetail user);
    PegawaiDetail postPegawaiDetail(UserModel user, AnggotaModel anggota);
    GuruDetail postGuruDetail(UserModel user, AnggotaModel anggota);
    SiswaDetail postSiswaDetail(UserModel user, AnggotaModel anggota);

    String generateNomorInduk(AnggotaModel anggota, UserModel user);
    PegawaiDetail postUserPegawaiToSiSivitas(PegawaiDetail pegawai);
    GuruDetail postUserGuruToSiSivitas(GuruDetail guru);
    SiswaDetail postUserSiswaToSiSivitas(SiswaDetail siswa);
}
