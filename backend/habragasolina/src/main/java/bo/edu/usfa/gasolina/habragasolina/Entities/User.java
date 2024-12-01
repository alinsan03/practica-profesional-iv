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

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
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
