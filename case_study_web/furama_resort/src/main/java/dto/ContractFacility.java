package dto;

public class ContractFacility {
    private int contractId;
    private String startDate;
    private String endDate;
    private double deposit;
    private int employeeId;
    private int customerId;
    private int facilityId;

    private int contractDetailId;
    private int quantity;

    private int attachFacilityId;
    private String name;
    private double cost;
    private String unit;
    private String status;

    public ContractFacility() {
    }

    public ContractFacility(int contractId, String startDate, String endDate, double deposit, int employeeId, int customerId, int facilityId, int contractDetailId, int quantity, int attachFacilityId, String name, double cost, String unit, String status) {
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.facilityId = facilityId;
        this.contractDetailId = contractDetailId;
        this.quantity = quantity;
        this.attachFacilityId = attachFacilityId;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(int attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContractFacility{" +
                "contractId=" + contractId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", deposit=" + deposit +
                ", employeeId=" + employeeId +
                ", customerId=" + customerId +
                ", facilityId=" + facilityId +
                ", contractDetailId=" + contractDetailId +
                ", quantity=" + quantity +
                ", attachFacilityId=" + attachFacilityId +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", unit='" + unit + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
