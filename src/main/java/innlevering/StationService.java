package innlevering;

import innlevering.enteties.Station;
import innlevering.enteties.StationInformation;
import innlevering.enteties.StationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

@Service
public class StationService {
    private OslobysykkelConsumer oslobysykkel;

    @Autowired
    public StationService(OslobysykkelConsumer oslobysykkel) {
        this.oslobysykkel = oslobysykkel;
    }

    public List<Station> hentAlle() {
        StationInformation.Data.Station[] stationInformation = oslobysykkel.getStationInformation().getData().getStations();
        StationStatus.Data.Station[] stationStatus = oslobysykkel.getStationStatus().getData().getStations();

        Set<Long> ids = new HashSet<>();
        ids.addAll(hentStationId(stationStatus, StationStatus.Data.Station::getStationID));
        ids.addAll(hentStationId(stationInformation, StationInformation.Data.Station::getStationID));

        Map<Long, StationStatus.Data.Station> statusMap = lagStationMap(stationStatus, StationStatus.Data.Station::getStationID);
        Map<Long, StationInformation.Data.Station> informationMap = lagStationMap(stationInformation, StationInformation.Data.Station::getStationID);

        List<Station> stations = new ArrayList<>();

        for (Long stationId: ids) {
            Station station = new Station();
            station.setStationID(stationId);

            station.setName( informationMap.get(stationId).getName());
            station.setNumBikesAvailable(statusMap.get(stationId).getNumBikesAvailable());
            station.setNumDocksAvailable(statusMap.get(stationId).getNumDocksAvailable());

            stations.add(station);
        }

        return stations;
    }

    private <T> Map<Long, T> lagStationMap(T[] station, Function<T, Long> function) {
        Map<Long, T> stationStatusMap = new HashMap<>();

        for(int i = 0; i < station.length; i++) {
            stationStatusMap.put(function.apply(station[i]), station[i]);
        }

        return stationStatusMap;
    }

    private <T> Set<Long> hentStationId(T[] station, Function<T, Long> function) {
        Set<Long> stationIds = new HashSet<>();

        for(int i = 0; i < station.length; i++) {
            stationIds.add(function.apply(station[i]));
        }

        return stationIds;
    }
}
