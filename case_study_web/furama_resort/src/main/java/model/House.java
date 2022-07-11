package model;

public class House extends Facility{
    private String standardRoom;
    private String otherDescription;
    private int numberFloor;

    public House() {
    }

    public House(int id, String name, int area, double cost, int maxPeople, int rentTypeId, int facilityTypeId, String standardRoom, String otherDescription, int numberFloor) {
        super(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId);
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
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

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return "House{" + super.toString() +
                "standardRoom='" + standardRoom + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", numberFloor=" + numberFloor +
                '}';
    }
}
