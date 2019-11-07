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

    @OneToMany(mappedBy = "simpanan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SimpananModel> simpananModelList;
}
