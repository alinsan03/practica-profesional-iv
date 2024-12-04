package bo.edu.usfa.gasolina.habragasolina.Entities;

import java.time.LocalDateTime;

public class GasStationAvailability {

    private String name;

    private String location;

    private Integer gasolina;

    private LocalDateTime dateGasolina;

    private Integer premium;

    private LocalDateTime datePremium;

    private Integer diesel;

    private LocalDateTime dateDiesel;

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

    public Integer getGasolina() {
        return gasolina;
    }

    public void setGasolina(Integer gasolina) {
        this.gasolina = gasolina;
    }

    public LocalDateTime getDateGasolina() {
        return dateGasolina;
    }

    public void setDateGasolina(LocalDateTime dateGasolina) {
        this.dateGasolina = dateGasolina;
    }

    public Integer getPremium() {
        return premium;
    }

    public void setPremium(Integer premium) {
        this.premium = premium;
    }

    public LocalDateTime getDatePremium() {
        return datePremium;
    }

    public void setDatePremium(LocalDateTime datePremium) {
        this.datePremium = datePremium;
    }

    public Integer getDiesel() {
        return diesel;
    }

    public void setDiesel(Integer diesel) {
        this.diesel = diesel;
    }

    public LocalDateTime getDateDiesel() {
        return dateDiesel;
    }

    public void setDateDiesel(LocalDateTime dateDiesel) {
        this.dateDiesel = dateDiesel;
    }
    

}
