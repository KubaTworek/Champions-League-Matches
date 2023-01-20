package pl.jakubtworek.ChampionsLeagueMatches.model;

import lombok.Data;

@Data
public class Competitor {
    private String country;
    private String country_code;
    private String gender;
    private String qualifier;
    private String name;
    private String id;
    private String abbreviation;
}
