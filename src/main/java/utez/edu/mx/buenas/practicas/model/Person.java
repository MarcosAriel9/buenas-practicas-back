package utez.edu.mx.buenas.practicas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido_pat", nullable = false)
    private String apellidoPat;
    @Column(name = "apellido_mat", nullable = false)
    private String apellidoMat;

    @Column(name = "numero_telefono", nullable = false)
    private String numeroDeTelefono;

    @Column (name = "fecha_nac")
    private Date fechaNac;

    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

    public Person() {
    }



    public Person(long id, String nombre, String apellidoPat, String apellidoMat, String numeroDeTelefono, User user,Date fechaNac) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.numeroDeTelefono = numeroDeTelefono;
        this.user = user;
        this.fechaNac = fechaNac;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
}