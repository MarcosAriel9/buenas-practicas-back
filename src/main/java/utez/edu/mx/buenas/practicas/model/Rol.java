package utez.edu.mx.buenas.practicas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "rol")
    @JsonIgnore
    private List<User> userList;

    public Rol(long id, String descripcion, List<User> userList) {
        this.id = id;
        this.descripcion = descripcion;
        this.userList = userList;
    }

    public Rol() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String puesto) {
        this.descripcion = descripcion;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
