package innlevering;

import innlevering.enteties.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StationController {

    StationService stationService;

    @Autowired
    public StationController(StationService sykkelService) {
        this.stationService = sykkelService;
    }

    @GetMapping("/")
    public List<Station> hentAlle() {
        return stationService.hentAlle();
    }

    @GetMapping("/fulle")
    public List<Station> hentFulle() {
        return stationService.hentAlle().stream().filter(station -> station.getNumDocksAvailable() == 0L).collect(Collectors.toList());
    }

    @GetMapping("/tomme")
    public List<Station> hentTomme() {
        return stationService.hentAlle().stream().filter(station -> station.getNumBikesAvailable() == 0L).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public Station hentMedId(@PathVariable Long id) {
        Station station = stationService.hentAlle().stream().filter(s -> s.getStationID().equals(id)).findFirst().orElse(null);

        if(station == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fant ingen station med id " + id);
        }

        return station;
    }
}
