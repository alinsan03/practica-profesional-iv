package bo.edu.usfa.gasolina.habragasolina.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "availabilities")
public class Availability {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_availabilities")
    private Integer id;
    
    @JoinColumn(name = "id_gas_station", referencedColumnName = "id_gas_station", nullable = false)
    private Integer id_gas_station;

    @JoinColumn(name = "id_type", referencedColumnName = "id_type", nullable = false)
    private Integer id_type;

    @JoinColumn(name = "id_status", referencedColumnName = "id_status", nullable = false)
    private Integer id_status;

    @JoinColumn(name = "id_fuel_type", referencedColumnName = "id_fuel_type", nullable = false)
    private Integer id_fuel_type;

    @Column(nullable = false)
    private LocalDateTime date_updated;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getId_type() {
        return id_type;
    }

    public void setId_type(Integer id_type) {
        this.id_type = id_type;
    }

    public Integer getId_status() {
        return id_status;
    }

    public void setId_status(Integer id_status) {
        this.id_status = id_status;
    }

    public LocalDateTime getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(LocalDateTime date_updated) {
        this.date_updated = date_updated;
    }

    public Integer getId_gas_station() {
        return id_gas_station;
    }

    public void setId_gas_station(Integer id_gas_station) {
        this.id_gas_station = id_gas_station;
    }

    public Integer getId_fuel_type() {
        return id_fuel_type;
    }

    public void setId_fuel_type(Integer id_fuel_type) {
        this.id_fuel_type = id_fuel_type;
    }


}
