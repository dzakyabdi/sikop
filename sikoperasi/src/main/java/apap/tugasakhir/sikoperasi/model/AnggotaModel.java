package apap.tugasakhir.sikoperasi.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="anggota")
public class AnggotaModel implements Serializable {
    private Long id;
    private String nia;
    private String nama;
    private String ktp;
    private String tempat_lahir;
    private Date
}
