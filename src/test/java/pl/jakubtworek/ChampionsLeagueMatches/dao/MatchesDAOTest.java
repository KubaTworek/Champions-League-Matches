package pl.jakubtworek.ChampionsLeagueMatches.dao;

import org.junit.jupiter.api.BeforeEach;

class MatchesDAOTest {

    private MatchesDAO matchesDAO;

    @BeforeEach
    void setup() {
        matchesDAO = new MatchesDAOImpl();
    }
}
