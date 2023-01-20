package pl.jakubtworek.ChampionsLeagueMatches.model;

import lombok.Data;

@Data
public class Venue {
    private String map_coordinates;
    private String country_code;
    private String city_name;
    private String name;
    private String country_name;
    private String id;
    private int capacity;
}
