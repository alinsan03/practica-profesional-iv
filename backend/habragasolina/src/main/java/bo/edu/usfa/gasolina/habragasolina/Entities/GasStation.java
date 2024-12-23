package bo.edu.usfa.gasolina.habragasolina.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;
import jakarta.persistence.Column;

@Entity
@Table(name = "gas_stations")
public class GasStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gas_station")
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "El nombre de la estación de gasolinería no puede ser nulo. Por favor intente nuevamente.")
    @Size(min = 3, max = 100, message = "El nombre debe contener entre 3 y 100 caracteres.")
    private String name;

    @Column(nullable = false)
    @Size(max=255, message="La ubicación no debe exceder los 255 caracteres.")
    private String location;

    @OneToMany
    @JoinColumn(name="id_gas_station")
    private Set<Availability> availabilities;


    public Integer getId() {
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

    public Set<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(Set<Availability> availabilities) {
        this.availabilities = availabilities;
    }
    
}
