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

    public String findCompetitors() {
        String[] competitors = new String[4];
        for (Competitor competitor : this.competitors) {
            if (Objects.equals(competitor.getQualifier(), "home")) {
                competitors[0] = competitor.getName();
                competitors[1] = competitor.getCountry();
            } else {
                competitors[2] = competitor.getName();
                competitors[3] = competitor.getCountry();
            }
        }
        return competitors[0] + " (" + competitors[1] + ") vs. " + competitors[2] + " (" + competitors[3] + ")";
    }

    public MatchResponse toResponse() {
        String date = start_date
                .substring(0, start_date.length() - 6)
                .replace('T', ' ');
        String competitors = this.findCompetitors();
        String venueName = venue.getName();
        String highestProbableResult = this.findNameOfHighestPossibility() + " (" + this.findHighestPossibility() + ")";

        return MatchResponse.builder()
                .startDate(date)
                .competitors(competitors)
                .venue(venueName)
                .highestProbableResult(highestProbableResult)
                .build();
    }
}
