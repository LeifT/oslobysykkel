package innlevering;

import innlevering.entities.Gbfs;
import innlevering.entities.StationInformation;
import innlevering.entities.StationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OslobysykkelConsumer {
    RestTemplate restTemplate;

    @Value( "${oslobysykkel.url.feed}" )
    private String feedUrl;

    @Autowired
    public OslobysykkelConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Gbfs getFeeds() {
        return getRequest(feedUrl,  Gbfs.class);
    }

    public StationInformation getStationInformation() {
        Gbfs gbfs = getFeeds();

        for (Gbfs.Data.Nb.Feed feed: gbfs.getData().getNb().getFeeds()) {
            if(feed.getName().equals("station_information")) {
                return getRequest(feed.getUrl(), StationInformation.class);
            }
        }

        return null;
    }

    public StationStatus getStationStatus() {
        Gbfs gbfs = getFeeds();

        for (Gbfs.Data.Nb.Feed feed: gbfs.getData().getNb().getFeeds()) {
            if(feed.getName().equals("station_status")) {
                return getRequest(feed.getUrl(), StationStatus.class);
            }
        }

        return null;
    }

    private <T> T getRequest(String url, Class<T> c) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("client-name", "leif-innlevering");
        HttpEntity entity = new HttpEntity(headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, c).getBody();
    }
}
