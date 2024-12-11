package bo.edu.usfa.gasolina.habragasolina.Entities;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @NotNull(message = "El usuario no puede ser nulo.")
    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 50, message = "El nombre de usuario debe de estar entre 4 y 50 caracteres.")
    private String username;

    @NotNull(message = "La contraseña no puede ser nula. Por favor intente nuevamente.")
    @Column(nullable = false)
    @Size(min = 8, message = "La contraseña no debe ser menor a 8 caracteres.")
    private String password;

    @Column(nullable = true)
    @Size (min=3, max=100, message= ".")
    private String name;
    
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime date_last_login;

    @JoinColumn(name = "id_gas_station", referencedColumnName = "id_gas_station", nullable = false)
    private Integer id_gas_station;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate_last_login() {
        return date_last_login;
    }

    public void setDate_last_login(LocalDateTime date_last_login) {
        this.date_last_login = date_last_login;
    }

    public Integer getId_gas_station() {
        return id_gas_station;
    }

    public void setId_gas_station(Integer id_gas_station) {
        this.id_gas_station = id_gas_station;
    }
}
