package apap.tugasakhir.sikoperasi.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RuanganNamaDetail {
    @JsonProperty("id")
    private Integer id;
    private String nama;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
