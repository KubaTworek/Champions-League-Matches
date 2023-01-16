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
        List<Event> matches = matchesDAO.findAll().stream()
                .sorted(Comparator.comparingDouble(Event::findHighestPossibility))
                .collect(Collectors.toList());
        Collections.reverse(matches);

        return matches.stream().limit(numberOfMatches).collect(Collectors.toList());
    }

    @Override
    public List<Competitor> getTeamsByCompetition(String competition) throws IOException {
        List<Event> matches = matchesDAO.findAll()
                .stream()
                .filter(m -> Objects.equals(m.getCompetition_name(), competition))
                .toList();
        List<Competitor> teams = new ArrayList<>();

        for (Event event : matches) {
            teams.addAll(event.getCompetitors());
        }

        return teams.stream()
                .sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName()))
                .collect(Collectors.toList());
    }
}
