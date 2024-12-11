package bo.edu.usfa.gasolina.habragasolina.Request;

public class AvailabilityRequest {
    private Integer idFuelType;
        private Integer idStatus;

        public Integer getIdFuelType() {
            return idFuelType;
        }

        public void setIdFuelType(Integer idFuelType) {
            this.idFuelType = idFuelType;
        }

        public Integer getIdStatus() {
            return idStatus;
        }

        public void setIdStatus(Integer idStatus) {
            this.idStatus = idStatus;
        }
}
