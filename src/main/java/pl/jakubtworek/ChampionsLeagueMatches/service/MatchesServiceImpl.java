package pl.jakubtworek.ChampionsLeagueMatches.service;

import org.springframework.stereotype.Service;
import pl.jakubtworek.ChampionsLeagueMatches.dao.MatchesDAO;
import pl.jakubtworek.ChampionsLeagueMatches.model.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MatchesServiceImpl implements MatchesService {
    private final MatchesDAO matchesDAO;

    public MatchesServiceImpl(MatchesDAO matchesDAO) {
        this.matchesDAO = matchesDAO;
    }

    @Override
    public List<Event> getMostProbableResults(int numberOfMatches) throws IOException {

        return matchesDAO.findAll().stream()
                .sorted(Comparator.comparingDouble(Event::findHighestPossibility).reversed())
                .limit(numberOfMatches)
                .toList();
    }

    @Override
    public List<String> getTeamsByCompetition(String competition) throws IOException {

        return matchesDAO.findAll()
                .stream()
                .filter(m -> Objects.equals(m.getCompetition_name(), competition))
                .flatMap(e -> e.getCompetitors().stream())
                .map(Competitor::getName).distinct().collect(Collectors.toList());
    }
}
