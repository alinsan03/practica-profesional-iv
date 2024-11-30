package bo.edu.usfa.gasolina.habragasolina.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String date_last_login;

    @Column(nullable = false)
    private int id_gas_station;

    // @ManyToOne
    // @JoinColumn(name = "id_gas_station", referencedColumnName = "id", nullable = false)
    // private GasStation gasStation;

    public Long getId() {
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

    public String getDate_last_login() {
        return date_last_login;
    }
    public void setId(Long id) {
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


    public void setDate_last_login(String date_last_login) {
        this.date_last_login = date_last_login;
    }

    public int getId_gas_station() {
        return id_gas_station;
    }

    public void setId_gas_station(int id_gas_station) {
        this.id_gas_station = id_gas_station;
    }

}
