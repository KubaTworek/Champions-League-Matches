package pl.jakubtworek.ChampionsLeagueMatches.dao;

import pl.jakubtworek.ChampionsLeagueMatches.model.Event;

import java.io.IOException;
import java.util.List;

public interface MatchesDAO {
    List<Event> findAll() throws IOException;
}
