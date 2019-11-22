package apap.tugasakhir.sikoperasi.rest;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PinjamanDetail {
	@JsonProperty("idAnggota")
	private String idAnggota;
	
	@JsonProperty("tanggalPengajuan")
	private Date tanggalPengajuan;
	
	@JsonProperty("jumlahPinjaman")
	private Integer jumlahPinjaman;

	public String getIdAnggota() {
		return idAnggota;
	}

	public void setIdAnggota(String idAnggota) {
		this.idAnggota = idAnggota;
	}

	public Date getTanggalPengajuan() {
		return tanggalPengajuan;
	}

	public void setTanggalPengajuan(Date tanggalPengajuan) {
		this.tanggalPengajuan = tanggalPengajuan;
	}

	public Integer getJumlahPinjaman() {
		return jumlahPinjaman;
	}

	public void setJumlahPinjaman(Integer jumlahPinjaman) {
		this.jumlahPinjaman = jumlahPinjaman;
	}

}
