package apap.tugasakhir.sikoperasi.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeminjamanDetail {
    @JsonProperty("idRuang")
    private Long idRuang;

    @JsonProperty("waktuMulai")
    private String waktuMulai;

    @JsonProperty("waktuSelesai")
    private String waktuSelesai;

    @JsonProperty("tanngalMulai")
    private Date tanggalMulai;

    @JsonProperty("tanngalSelesai")
    private Date tanggalSelesai;

    @JsonProperty("tujuan")
    private String  tujuan;

    @JsonProperty("jumlahPeserta")
    private Integer jumlahPeserta;

    @JsonProperty("keterangan")
    private String keterangan;

    @JsonProperty("nomorSurat")
    private Integer nomorSurat;

    @JsonProperty("uuid_user_peminjam")
    private String uuidUserPeminjam;

    public Long getIdRuang() {
        return idRuang;
    }

    public void setIdRuang(Long idRuang) {
        this.idRuang = idRuang;
    }

    public String getWaktuMulai() {
        return waktuMulai;
    }

    public void setWaktuMulai(String waktuMulai) {
        this.waktuMulai = waktuMulai;
    }

    public String getWaktuSelesai() {
        return waktuSelesai;
    }

    public void setWaktuSelesai(String waktuSelesai) {
        this.waktuSelesai = waktuSelesai;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public Integer getJumlahPeserta() {
        return jumlahPeserta;
    }

    public void setJumlahPeserta(Integer jumlahPeserta) {
        this.jumlahPeserta = jumlahPeserta;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Integer getNomorSurat() {
        return nomorSurat;
    }

    public void setNomorSurat(Integer nomorSurat) {
        this.nomorSurat = nomorSurat;
    }

    public String getUuidUserPeminjam() {
        return uuidUserPeminjam;
    }

    public void setUuidUserPeminjam(String uuidUserPeminjam) {
        this.uuidUserPeminjam = uuidUserPeminjam;
    }
}
