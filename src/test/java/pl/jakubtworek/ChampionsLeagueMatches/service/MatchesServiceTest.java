package pl.jakubtworek.ChampionsLeagueMatches.service;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import pl.jakubtworek.ChampionsLeagueMatches.dao.MatchesDAO;
import pl.jakubtworek.ChampionsLeagueMatches.model.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MatchesServiceTest {
    @Mock
    private MatchesDAO matchesDAO;

    private MatchesService matchesService;

    @BeforeEach
    void setup() {
        matchesDAO = mock(MatchesDAO.class);

        matchesService = new MatchesServiceImpl(
                matchesDAO
        );
    }

    @Test
    void shouldReturnMostProbableResultsLimitedForSpecificAmount() throws Exception {
        // given
        List<Event> events = createEventsWithPossibilities();

        // when
        when(matchesDAO.findAll()).thenReturn(events);

        List<Event> eventsReturned = matchesService.getMostProbableResults(2);

        // then
        assertEquals(2, eventsReturned.size());
        assertEquals(90.03, eventsReturned.get(0).getProbability_draw());
        assertEquals(65.23, eventsReturned.get(1).getProbability_draw());
    }

    @Test
    void shouldReturnTeamsAlphabeticallyForSpecificCompetitionDistinctly() throws Exception {
        // given
        List<Event> events = createEventsWithCompetitionNameAndCompetitors();

        // when
        when(matchesDAO.findAll()).thenReturn(events);

        List<Competitor> competitors = matchesService.getTeamsByCompetition("UEFA Champions League");

        // then
        assertEquals(3, competitors.size());
        assertEquals("Chelsea FC", competitors.get(0).getName());
        assertEquals("FC Barcelona", competitors.get(1).getName());
        assertEquals("Real Madryt", competitors.get(2).getName());
    }

    private List<Event> createEventsWithPossibilities() {
        List<Event> events = new ArrayList<>();
        events.add(new Event());
        events.add(new Event());
        events.add(new Event());
        events.get(0).setProbability_draw(20.24);
        events.get(1).setProbability_draw(65.23);
        events.get(2).setProbability_draw(90.03);

        return events;
    }

    private List<Event> createEventsWithCompetitionNameAndCompetitors() {
        List<Event> events = new ArrayList<>();
        events.add(new Event());
        events.add(new Event());
        events.add(new Event());
        events.get(0).setCompetition_name("UEFA Champions League");
        events.get(1).setCompetition_name("UEFA Champions League");
        events.get(2).setCompetition_name("Ekstraklasa");
        events.get(0).setCompetitors(new ArrayList<>());
        events.get(0).getCompetitors().add(new Competitor());
        events.get(0).getCompetitors().add(new Competitor());
        events.get(0).getCompetitors().get(0).setName("Chelsea FC");
        events.get(0).getCompetitors().get(1).setName("FC Barcelona");
        events.get(1).setCompetitors(new ArrayList<>());
        events.get(1).getCompetitors().add(new Competitor());
        events.get(1).getCompetitors().add(new Competitor());
        events.get(1).getCompetitors().get(0).setName("Real Madryt");
        events.get(1).getCompetitors().get(1).setName("FC Barcelona");
        events.get(2).setCompetitors(new ArrayList<>());
        events.get(2).getCompetitors().add(new Competitor());
        events.get(2).getCompetitors().add(new Competitor());
        events.get(2).getCompetitors().get(0).setName("Legia Warszawa");
        events.get(2).getCompetitors().get(1).setName("Lech Poznan");

        return events;
    }
}
