package companies.Convoy.logistics;

public class Driver {

    private int driverId;
    private DriverCompetency driverCompetency;
    private String driveName;
    private ShiftType shiftType;

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public DriverCompetency getDriverCompetency() {
        return driverCompetency;
    }

    public void setDriverCompetency(DriverCompetency driverCompetency) {
        this.driverCompetency = driverCompetency;
    }

    public String getDriveName() {
        return driveName;
    }

    public void setDriveName(String driveName) {
        this.driveName = driveName;
    }

    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
    }
}
