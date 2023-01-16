package pl.jakubtworek.ChampionsLeagueMatches.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import pl.jakubtworek.ChampionsLeagueMatches.model.Event;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Repository
public class MatchesDAOImpl implements MatchesDAO {
    @Override
    public List<Event> findAll() throws IOException {
        ClassPathResource staticDataResource = new ClassPathResource("BE_data.json");
        String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

        ObjectMapper obj = new ObjectMapper();
        Map<String, Object> map = new JSONObject(staticDataString).toMap();
        List<Event> events = new ArrayList<>();

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String data = obj.writeValueAsString(value);
            Event[] eventsArr = obj.readValue(data, Event[].class);
            events.addAll(Arrays.asList(eventsArr));
        }

        return events;
    }
}
