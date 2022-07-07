package model.facility;

public class FacilityType {
    private int facility_type_id;
    private String facility_type_name;

    public FacilityType() {
    }

    public FacilityType(int facility_type_id, String facility_type_name) {
        this.facility_type_id = facility_type_id;
        this.facility_type_name = facility_type_name;
    }

    public int getFacility_type_id() {
        return facility_type_id;
    }

    public void setFacility_type_id(int facility_type_id) {
        this.facility_type_id = facility_type_id;
    }

    public String getFacility_type_name() {
        return facility_type_name;
    }

    public void setFacility_type_name(String facility_type_name) {
        this.facility_type_name = facility_type_name;
    }
}
