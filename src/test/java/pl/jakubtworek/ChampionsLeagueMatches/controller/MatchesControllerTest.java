package pl.jakubtworek.ChampionsLeagueMatches.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.jakubtworek.ChampionsLeagueMatches.model.*;
import pl.jakubtworek.ChampionsLeagueMatches.service.MatchesService;

import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MatchesControllerTest {
    @MockBean
    private MatchesService matchesService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldReturnMostProbableResults() throws Exception {
        // given
        List<Event> events = createEvents();

        // when
        when(matchesService.getMostProbableResults(anyInt())).thenReturn(events);

        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/matches/2"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].startDate").value("2023-01-20 17:00:00"))
                .andExpect(jsonPath("$[0].competitors").value("Legia Warszawa (Poland) vs. Lech Poznan (Poland)"))
                .andExpect(jsonPath("$[0].venue").value("Stadion Narodowy"))
                .andExpect(jsonPath("$[0].highestProbableResult").value("DRAW (60.0)"))
                .andExpect(jsonPath("$[1].startDate").value("2023-01-21 17:00:00"))
                .andExpect(jsonPath("$[1].competitors").value("Arka Gdynia (Poland) vs. Lechia Gdansk (Poland)"))
                .andExpect(jsonPath("$[1].venue").value("Stadion Narodowy"))
                .andExpect(jsonPath("$[1].highestProbableResult").value("HOME_TEAM_WIN (50.0)"));
    }

    @Test
    void shouldReturnTeams() throws Exception {
        // given
        List<Competitor> matches = new ArrayList<>();
        matches.add(new Competitor());
        matches.add(new Competitor());
        matches.get(0).setName("Real Madryt");
        matches.get(1).setName("FC Barcelona");

        // when
        when(matchesService.getTeamsByCompetition(anyString())).thenReturn(matches);

        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/teams/UEFA Champions League"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    private List<Event> createEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new Event());
        events.add(new Event());
        events.get(0).setStart_date("2023-01-20T17:00:00+00:00");
        events.get(0).setVenue(new Venue());
        events.get(0).getVenue().setName("Stadion Narodowy");
        events.get(0).setProbability_draw(60.00);
        events.get(0).setProbability_home_team_winner(30.00);
        events.get(0).setProbability_away_team_winner(10.00);
        events.get(0).setCompetitors(new ArrayList<>());
        events.get(0).getCompetitors().add(new Competitor());
        events.get(0).getCompetitors().add(new Competitor());
        events.get(0).getCompetitors().get(0).setName("Legia Warszawa");
        events.get(0).getCompetitors().get(0).setCountry("Poland");
        events.get(0).getCompetitors().get(0).setQualifier("home");
        events.get(0).getCompetitors().get(1).setName("Lech Poznan");
        events.get(0).getCompetitors().get(1).setCountry("Poland");
        events.get(0).getCompetitors().get(1).setQualifier("away");

        events.get(1).setStart_date("2023-01-21T17:00:00+00:00");
        events.get(1).setVenue(new Venue());
        events.get(1).getVenue().setName("Stadion Narodowy");
        events.get(1).setProbability_draw(20.00);
        events.get(1).setProbability_home_team_winner(50.00);
        events.get(1).setProbability_away_team_winner(30.00);
        events.get(1).setCompetitors(new ArrayList<>());
        events.get(1).getCompetitors().add(new Competitor());
        events.get(1).getCompetitors().add(new Competitor());
        events.get(1).getCompetitors().get(0).setName("Arka Gdynia");
        events.get(1).getCompetitors().get(0).setCountry("Poland");
        events.get(1).getCompetitors().get(0).setQualifier("home");
        events.get(1).getCompetitors().get(1).setName("Lechia Gdansk");
        events.get(1).getCompetitors().get(1).setCountry("Poland");
        events.get(1).getCompetitors().get(1).setQualifier("away");

        return events;
    }
}
