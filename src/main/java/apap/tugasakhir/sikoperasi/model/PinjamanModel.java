package apap.tugasakhir.sikoperasi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pinjaman")
public class PinjamanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name= "tanggal_pengajuan", nullable = false)
	private Date tanggalPengajuan;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name= "tanggal_disetujui")
	private Date tanggalDisetujui;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name= "tanggal_pengembalian")
	private Date tanggalPengembalian;
	
	@NotNull
	@Column(name= "jumlah_pinjaman", nullable = false)
	private Integer jumlahPinjaman;
	
	@Column(name= "jumlah_pengembalian")
	private Integer jumlahPengembalian;
	
	@NotNull
	@Column(name= "status", nullable = false)
	private Integer status;
	

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_anggota", referencedColumnName= "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private AnggotaModel anggota;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getTanggalPengajuan() {
		return tanggalPengajuan;
	}


	public void setTanggalPengajuan(Date tanggalPengajuan) {
		this.tanggalPengajuan = tanggalPengajuan;
	}


	public Date getTanggalDisetujui() {
		return tanggalDisetujui;
	}


	public void setTanggalDisetujui(Date tanggalDisetujui) {
		this.tanggalDisetujui = tanggalDisetujui;
	}


	public Date getTanggalPengembalian() {
		return tanggalPengembalian;
	}


	public void setTanggalPengembalian(Date tanggalPengembalian) {
		this.tanggalPengembalian = tanggalPengembalian;
	}


	public Integer getJumlahPinjaman() {
		return jumlahPinjaman;
	}


	public void setJumlahPinjaman(Integer jumlahPinjaman) {
		this.jumlahPinjaman = jumlahPinjaman;
	}


	public Integer getJumlahPengembalian() {
		return jumlahPengembalian;
	}


	public void setJumlahPengembalian(Integer jumlahPengembalian) {
		this.jumlahPengembalian = jumlahPengembalian;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}

	public AnggotaModel getAnggota() {
		return anggota;
	}


	public void setAnggota(AnggotaModel anggota) {
		this.anggota = anggota;
	}
	
}
