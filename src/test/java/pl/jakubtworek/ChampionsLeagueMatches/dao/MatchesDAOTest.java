package pl.jakubtworek.ChampionsLeagueMatches.dao;

import org.junit.jupiter.api.*;
import pl.jakubtworek.ChampionsLeagueMatches.model.Event;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchesDAOTest {

    private MatchesDAO matchesDAO;

    @BeforeEach
    void setup() {
        matchesDAO = new MatchesDAOImpl();
    }

    @Test
    void shouldReturnAllEvents() throws Exception {
        // when
        List<Event> eventsReturned = matchesDAO.findAll();

        // then
        assertEquals(73, eventsReturned.size());
    }
}
