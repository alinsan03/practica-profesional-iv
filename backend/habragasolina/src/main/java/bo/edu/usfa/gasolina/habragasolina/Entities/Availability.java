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
@Table(name = "availabilities")
public class Availability {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_availabilities")
    private Integer id;
    
    @Column(name = "id_gas_station")
    @JoinColumn(name = "id_gas_station", referencedColumnName = "id_gas_station", nullable = false)
    private Integer gasStationId;

    @Column(name = "id_type")
    @JoinColumn(name = "id_type", referencedColumnName = "id_type", nullable = false)
    private Integer typeId;

    @Column(name = "id_status")
    @JoinColumn(name = "id_status", referencedColumnName = "id_status", nullable = false)
    private Integer statusId;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime date_updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGasStationId() {
        return gasStationId;
    }

    public void setGasStationId(Integer gasStationId) {
        this.gasStationId = gasStationId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public LocalDateTime getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(LocalDateTime date_updated) {
        this.date_updated = date_updated;
    }

}
