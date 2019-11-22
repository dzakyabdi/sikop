package apap.tugasakhir.sikoperasi.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RuanganDetail {
    @JsonProperty("id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
