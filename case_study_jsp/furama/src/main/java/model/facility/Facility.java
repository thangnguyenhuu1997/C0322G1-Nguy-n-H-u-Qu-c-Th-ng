package model.facility;

public class Facility {
    private int facility_id;
    private String facility_name;
    private int facility_area;
    private double facility_cost;
    private int facility_max_people;
    private int rent_type_id;
    private int facility_type_id;

    public Facility() {
    }

    public Facility(int facility_id, String facility_name, int facility_area, double facility_cost, int facility_max_people, int rent_type_id, int facility_type_id) {
        this.facility_id = facility_id;
        this.facility_name = facility_name;
        this.facility_area = facility_area;
        this.facility_cost = facility_cost;
        this.facility_max_people = facility_max_people;
        this.rent_type_id = rent_type_id;
        this.facility_type_id = facility_type_id;
    }

    public int getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }

    public int getFacility_area() {
        return facility_area;
    }

    public void setFacility_area(int facility_area) {
        this.facility_area = facility_area;
    }

    public double getFacility_cost() {
        return facility_cost;
    }

    public void setFacility_cost(double facility_cost) {
        this.facility_cost = facility_cost;
    }

    public int getFacility_max_people() {
        return facility_max_people;
    }

    public void setFacility_max_people(int facility_max_people) {
        this.facility_max_people = facility_max_people;
    }

    public int getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(int rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public int getFacility_type_id() {
        return facility_type_id;
    }

    public void setFacility_type_id(int facility_type_id) {
        this.facility_type_id = facility_type_id;
    }
}
