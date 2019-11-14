package innlevering.enteties;

public class StationInformation {
    private long lastUpdated;
    private Data data;

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private Station[] stations;

        public Station[] getStations() {
            return stations;
        }

        public void setStations(Station[] stations) {
            this.stations = stations;
        }

        public static class Station {
            private Long stationID;
            private String name;
            private String address;
            private double lat;
            private double lon;
            private long capacity;

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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLon() {
                return lon;
            }

            public void setLon(double lon) {
                this.lon = lon;
            }

            public long getCapacity() {
                return capacity;
            }

            public void setCapacity(long capacity) {
                this.capacity = capacity;
            }
        }
    }
}
