package apap.tugasakhir.sikoperasi.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetail {
	@JsonProperty("idUser")
	private String idUser;

	@JsonProperty("nip")
	private String nip;
	
	@JsonProperty("nig")
	private String nig;
	
	@JsonProperty("nama")
	private String nama;
	
	@JsonProperty("tempatLahir")
	private String tempatLahir;
	
	@JsonProperty("tanggalLahir")
	private String tanggalLahir;
	
	@JsonProperty("alamat")
	private String alamat;
	
	@JsonProperty("telepon")
	private String telepon;

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNig() {
		return nig;
	}

	public void setNig(String nig) {
		this.nig = nig;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public String getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(String tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}
	
}
