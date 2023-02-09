package pl.jakubtworek.ChampionsLeagueMatches.service;

import pl.jakubtworek.ChampionsLeagueMatches.model.*;

import java.io.IOException;
import java.util.*;

public interface MatchesService {
    List<Event> getMostProbableResults(int numberOfMatches) throws IOException;

    List<String> getTeamsByCompetition(String competition) throws IOException;
}
