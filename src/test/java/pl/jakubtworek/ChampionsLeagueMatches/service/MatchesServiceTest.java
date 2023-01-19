package pl.jakubtworek.ChampionsLeagueMatches.service;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import pl.jakubtworek.ChampionsLeagueMatches.dao.MatchesDAO;

import static org.mockito.Mockito.mock;

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
}
