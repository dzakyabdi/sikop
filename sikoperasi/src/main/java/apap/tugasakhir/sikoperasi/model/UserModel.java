package apap.tugasakhir.sikoperasi.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String uuid;

    @NotNull
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

//    @OneToOne(mappedBy = "user")
//    private AnggotaModel anggota;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_role", referencedColumnName = "id")
//    private RoleModel role;

//    public AnggotaModel getAnggota() {
//        return anggota;
//    }
//
//    public void setAnggota(AnggotaModel anggota) {
//        this.anggota = anggota;
//    }
//
//    public RoleModel getRole() {
//        return role;
//    }
//
//    public void setRole(RoleModel role) {
//        this.role = role;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
