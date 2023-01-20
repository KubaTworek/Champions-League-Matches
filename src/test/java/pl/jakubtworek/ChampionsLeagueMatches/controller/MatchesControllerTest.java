package pl.jakubtworek.ChampionsLeagueMatches.controller;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
    @Mock
    private MatchesService matchesService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        matchesService = mock(MatchesService.class);
    }

    @Test
    void shouldReturnMostProbableResults() throws Exception {
        // given
        List<Event> events = new ArrayList<>();
        events.add(new Event());
        events.add(new Event());

        // when
        when(matchesService.getMostProbableResults(anyInt())).thenReturn(events);

        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/matches/2"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
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
}
