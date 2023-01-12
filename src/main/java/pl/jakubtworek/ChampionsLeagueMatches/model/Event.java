package pl.jakubtworek.ChampionsLeagueMatches.model;

import java.util.List;

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

    public String getSport_name() {
        return sport_name;
    }

    public void setSport_name(String sport_name) {
        this.sport_name = sport_name;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    public double getProbability_away_team_winner() {
        return probability_away_team_winner;
    }

    public void setProbability_away_team_winner(double probability_away_team_winner) {
        this.probability_away_team_winner = probability_away_team_winner;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public String getCompetition_id() {
        return competition_id;
    }

    public void setCompetition_id(String competition_id) {
        this.competition_id = competition_id;
    }

    public double getProbability_home_team_winner() {
        return probability_home_team_winner;
    }

    public void setProbability_home_team_winner(double probability_home_team_winner) {
        this.probability_home_team_winner = probability_home_team_winner;
    }

    public double getProbability_draw() {
        return probability_draw;
    }

    public void setProbability_draw(double probability_draw) {
        this.probability_draw = probability_draw;
    }

    public String getSport_event_id() {
        return sport_event_id;
    }

    public void setSport_event_id(String sport_event_id) {
        this.sport_event_id = sport_event_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "sport_name='" + sport_name + '\'' +
                ", venue=" + venue +
                ", competitors=" + competitors +
                ", probability_away_team_winner=" + probability_away_team_winner +
                ", competition_name='" + competition_name + '\'' +
                ", season_name='" + season_name + '\'' +
                ", competition_id='" + competition_id + '\'' +
                ", probability_home_team_winner=" + probability_home_team_winner +
                ", probability_draw=" + probability_draw +
                ", sport_event_id='" + sport_event_id + '\'' +
                ", start_date='" + start_date + '\'' +
                '}';
    }
}
