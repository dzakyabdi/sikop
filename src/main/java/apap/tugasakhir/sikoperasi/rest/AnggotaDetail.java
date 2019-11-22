package apap.tugasakhir.sikoperasi.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnggotaDetail {
    private Long id;

    private String uuid;

    private String nama;

    private String nia;

    private boolean is_pengurus;

    private Long total_simpanan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNia() {
        return nia;
    }

    public void setNia(String nia) {
        this.nia = nia;
    }

    public boolean isIs_pengurus() {
        return is_pengurus;
    }

    public void setIs_pengurus(boolean is_pengurus) {
        this.is_pengurus = is_pengurus;
    }

    public Long getTotal_simpanan() {
        return total_simpanan;
    }

    public void setTotal_simpanan(Long total_simpanan) {
        this.total_simpanan = total_simpanan;
    }
}
