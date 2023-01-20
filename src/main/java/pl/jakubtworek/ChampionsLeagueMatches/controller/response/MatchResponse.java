package pl.jakubtworek.ChampionsLeagueMatches.controller.response;

import lombok.*;

@Builder
@Data
public class MatchResponse {
    private String startDate;
    private String competitors;
    private String venue;
    private String highestProbableResult;
}
