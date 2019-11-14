package innlevering.entities;

public class Station {
    private Long stationID;
    private String name;
    private long numBikesAvailable;
    private long numDocksAvailable;

    public Long getStationID() {
        return stationID;
    }

    public void setStationID(Long stationID) {
        this.stationID = stationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumBikesAvailable() {
        return numBikesAvailable;
    }

    public void setNumBikesAvailable(long numBikesAvailable) {
        this.numBikesAvailable = numBikesAvailable;
    }

    public long getNumDocksAvailable() {
        return numDocksAvailable;
    }

    public void setNumDocksAvailable(long numDocksAvailable) {
        this.numDocksAvailable = numDocksAvailable;
    }
}
