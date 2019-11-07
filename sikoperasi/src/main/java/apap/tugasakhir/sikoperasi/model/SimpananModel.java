package apap.tugasakhir.sikoperasi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "simpanan")
public class SimpananModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="tanggal_setor", nullable = false)
    private Date tanggal_setor;

    @NotNull
    @Column(name="jumlah", nullable = false)
    private Integer jumlah;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_jenis_simpanan", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JenisSimpananModel id_jenis_simpanan;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_anggota_penyetor", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AnggotaModel id_anggota_penyetor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_anggota_penerima", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AnggotaModel id_anggota_penerima;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTanggal_setor() {
        return tanggal_setor;
    }

    public void setTanggal_setor(Date tanggal_setor) {
        this.tanggal_setor = tanggal_setor;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public JenisSimpananModel getId_jenis_simpanan() {
        return id_jenis_simpanan;
    }

    public void setId_jenis_simpanan(JenisSimpananModel id_jenis_simpanan) {
        this.id_jenis_simpanan = id_jenis_simpanan;
    }

    public AnggotaModel getId_anggota_penyetor() {
        return id_anggota_penyetor;
    }

    public void setId_anggota_penyetor(AnggotaModel id_anggota_penyetor) {
        this.id_anggota_penyetor = id_anggota_penyetor;
    }

    public AnggotaModel getId_anggota_penerima() {
        return id_anggota_penerima;
    }

    public void setId_anggota_penerima(AnggotaModel id_anggota_penerima) {
        this.id_anggota_penerima = id_anggota_penerima;
    }
}
