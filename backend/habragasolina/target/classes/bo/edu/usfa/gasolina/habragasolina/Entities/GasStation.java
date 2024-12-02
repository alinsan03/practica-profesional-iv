package bo.edu.usfa.gasolina.habragasolina.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GasStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @column(name = "id_gas_station")
    private Integer id;
    private String name;
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
