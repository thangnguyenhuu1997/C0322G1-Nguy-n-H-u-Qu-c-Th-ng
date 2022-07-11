package model;

public class Villa extends Facility{
    private String standardRoom;
    private String otherDescription;
    private double poolArea;
    private int numberFloor;

    public Villa() {
    }

    public Villa(int id, String name, int area, double cost, int maxPeople, int rentTypeId, int facilityTypeId, String standardRoom, String otherDescription, double poolArea, int numberFloor) {
        super(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId);
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                "standardRoom='" + standardRoom + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", poolArea=" + poolArea +
                ", numberFloor=" + numberFloor +
                '}';
    }
}
