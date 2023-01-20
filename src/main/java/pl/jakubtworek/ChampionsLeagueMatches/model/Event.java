package pl.jakubtworek.ChampionsLeagueMatches.model;

import lombok.Data;
import pl.jakubtworek.ChampionsLeagueMatches.controller.response.MatchResponse;

import java.util.*;
import java.util.stream.Stream;

@Data
public class Event {
    private String sport_name;
    private Venue venue;
    private List<Competitor> competitors;
    private double probability_away_team_winner;
    private String competition_name;
    private String season_name;
    private String competition_id;
    private double probability_home_team_winner;
    private double probability_draw;
    private String sport_event_id;
    private String start_date;

    public double findHighestPossibility() {
        return Stream.of(probability_draw, probability_away_team_winner, probability_home_team_winner).max(Comparator.comparingDouble(p -> p)).get();
    }

    public String findNameOfHighestPossibility() {
        double highestProbability = this.findHighestPossibility();

        if (highestProbability == probability_home_team_winner) {
            return "HOME_TEAM_WIN";
        } else if (highestProbability == probability_away_team_winner) {
            return "AWAY_TEAM_WIN";
        } else {
            return "DRAW";
        }
    }

    public MatchResponse toResponse() {
        double highestProbableResult = this.findHighestPossibility();
        String nameOfHighestProbableResult = this.findNameOfHighestPossibility();
        // TODO: add check which team is away and home
        // TODO: add date format

        return MatchResponse.builder()
                .date(start_date)
                .competition(competition_name)
                .homeName(competitors.get(0).getName())
                .homeCountry(competitors.get(0).getCountry())
                .awayName(competitors.get(1).getName())
                .awayCountry(competitors.get(1).getCountry())
                .venueName(venue.getName())
                .highestProbableResult(nameOfHighestProbableResult + " (" + highestProbableResult + ")")
                .build();
    }
}
