package pl.jakubtworek.ChampionsLeagueMatches.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pl.jakubtworek.ChampionsLeagueMatches.model.Event;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping
public class MatchesController {
    @GetMapping("/mocked-api")
    public ResponseEntity<List<Event>> getRadarData() throws IOException {
        ClassPathResource staticDataResource = new ClassPathResource("BE_data.json");
        String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

        ObjectMapper obj = new ObjectMapper();

        Map<String, Object> map = new JSONObject(staticDataString).toMap();
        List<Event> events = new ArrayList<>();

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String z = obj.writeValueAsString(value);
            Event[] x = obj.readValue(z, Event[].class);
            events.addAll(Arrays.asList(x));
        }

        return new ResponseEntity<>(
                events,
                HttpStatus.OK
        );
    }

}
