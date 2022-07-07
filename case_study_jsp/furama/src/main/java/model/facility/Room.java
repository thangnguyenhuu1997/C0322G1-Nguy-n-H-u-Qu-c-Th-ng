package model.facility;

public class Room extends Facility {
    private String facility_free;

    public Room() {
    }

    public Room(int facility_id, String facility_name, int facility_area, double facility_cost, int facility_max_people, int rent_type_id, int facility_type_id, String facility_free) {
        super(facility_id, facility_name, facility_area, facility_cost, facility_max_people, rent_type_id, facility_type_id);
        this.facility_free = facility_free;
    }

    public String getFacility_free() {
        return facility_free;
    }

    public void setFacility_free(String facility_free) {
        this.facility_free = facility_free;
    }
}
