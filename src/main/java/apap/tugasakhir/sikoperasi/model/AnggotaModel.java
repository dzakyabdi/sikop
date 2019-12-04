package apap.tugasakhir.sikoperasi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="anggota")
public class AnggotaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nia", nullable = false)
    private String nia;

    @NotNull
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "ktp", nullable = false)
    private String ktp;

    @NotNull
    @Column(name = "tempat_lahir", nullable = false)
    private String tempat_lahir;

    @NotNull
    @Column(name = "tanggal_lahir", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date tanggal_lahir;

    @NotNull
    @Column(name = "alamat", nullable = false)
    private String alamat;

    @NotNull
    @Column(name = "nomor_telepon", nullable = false)
    private String nomor_telepon;

    @NotNull
    @Column(name = "is_pengurus", nullable = false)
    private boolean is_pengurus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuid_user", referencedColumnName = "id", nullable = false)
    private UserModel user;

    @OneToMany(mappedBy = "anggota", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PinjamanModel> listPinjaman;

    @OneToMany(mappedBy = "anggotaPenyetor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SimpananModel> listSimpananPenyetor;

    @OneToMany(mappedBy = "anggotaPenerima", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SimpananModel> listSimpananPenerima;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNia() {
        return nia;
    }

    public void setNia(String nia) {
        this.nia = nia;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomor_telepon() {
        return nomor_telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }

    public boolean getIs_pengurus() {
        return is_pengurus;
    }

    public void setIs_pengurus(boolean is_pengurus) {
        this.is_pengurus = is_pengurus;
    }

    public List<PinjamanModel> getListPinjaman() {
        return listPinjaman;
    }

    public void setListPinjaman(List<PinjamanModel> listPinjaman) {
        this.listPinjaman = listPinjaman;
    }

    public List<SimpananModel> getListSimpananPenyetor() {
        return listSimpananPenyetor;
    }

    public void setListSimpananPenyetor(List<SimpananModel> listSimpananPenyetor) {
        this.listSimpananPenyetor = listSimpananPenyetor;
    }

    public List<SimpananModel> getListSimpananPenerima() {
        return listSimpananPenerima;
    }

    public void setListSimpananPenerima(List<SimpananModel> listSimpananPenerima) {
        this.listSimpananPenerima = listSimpananPenerima;
    }
}
