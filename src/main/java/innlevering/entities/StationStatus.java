package innlevering.entities;

public class StationStatus {
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
            private long isInstalled;
            private long isRenting;
            private long numBikesAvailable;
            private long numDocksAvailable;
            private long lastReported;
            private long isReturning;
            private Long stationID;

            public Long getStationID() {
                return stationID;
            }

            public void setStationID(Long stationID) {
                this.stationID = stationID;
            }

            public long getIsInstalled() {
                return isInstalled;
            }

            public void setIsInstalled(long isInstalled) {
                this.isInstalled = isInstalled;
            }

            public long getIsRenting() {
                return isRenting;
            }

            public void setIsRenting(long isRenting) {
                this.isRenting = isRenting;
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

            public long getLastReported() {
                return lastReported;
            }

            public void setLastReported(long lastReported) {
                this.lastReported = lastReported;
            }

            public long getIsReturning() {
                return isReturning;
            }

            public void setIsReturning(long isReturning) {
                this.isReturning = isReturning;
            }
        }
    }
}
