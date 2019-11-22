package apap.tugasakhir.sikoperasi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "jenis_simpanan")
public class JenisSimpananModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 200)
    @Column(name="nama", nullable = false)
    private String nama;

    @OneToMany(mappedBy = "jenisSimpanan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SimpananModel> listSimpanan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<SimpananModel> getListSimpanan() {
        return listSimpanan;
    }

    public void setListSimpanan(List<SimpananModel> listSimpanan) {
        this.listSimpanan = listSimpanan;
    }
}
