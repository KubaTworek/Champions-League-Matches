package pl.jakubtworek.ChampionsLeagueMatches.controller.response;

import lombok.*;

@Builder
@Data
public class MatchResponse {
    private String date;
    private String competition;
    private String homeName;
    private String homeCountry;
    private String awayName;
    private String awayCountry;
    private String venueName;
    private String highestProbableResult;
}
