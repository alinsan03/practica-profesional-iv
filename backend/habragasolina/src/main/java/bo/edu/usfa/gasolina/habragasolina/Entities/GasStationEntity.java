package bo.edu.usfa.gasolina.habragasolina.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "gas_stations")
public class GasStationEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_gas_station;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String location;

    public Long getId_gas_station() {
        return id_gas_station;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setId_gas_station(Long id_gas_station) {
        this.id_gas_station = id_gas_station;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

