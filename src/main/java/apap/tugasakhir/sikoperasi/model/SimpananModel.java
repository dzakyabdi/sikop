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
    @JoinColumn(name = "idJenisSimpanan", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JenisSimpananModel jenisSimpanan;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idAnggotaPenyetor", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AnggotaModel anggotaPenyetor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idAnggotaPenerima", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AnggotaModel anggotaPenerima;

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

    public JenisSimpananModel getJenisSimpanan() {
        return jenisSimpanan;
    }

    public void setJenisSimpanan(JenisSimpananModel jenisSimpanan) {
        this.jenisSimpanan = jenisSimpanan;
    }

    public AnggotaModel getAnggotaPenyetor() {
        return anggotaPenyetor;
    }

    public void setAnggotaPenyetor(AnggotaModel anggotaPenyetor) {
        this.anggotaPenyetor = anggotaPenyetor;
    }

    public AnggotaModel getAnggotaPenerima() {
        return anggotaPenerima;
    }

    public void setAnggotaPenerima(AnggotaModel anggotaPenerima) {
        this.anggotaPenerima = anggotaPenerima;
    }
}
