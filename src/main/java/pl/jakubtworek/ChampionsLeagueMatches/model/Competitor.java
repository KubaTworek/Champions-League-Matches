package pl.jakubtworek.ChampionsLeagueMatches.model;

public class Competitor {
    private String country;
    private String country_code;
    private String gender;
    private String qualifier;
    private String name;
    private String id;
    private String abbreviation;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "country='" + country + '\'' +
                ", country_code='" + country_code + '\'' +
                ", gender='" + gender + '\'' +
                ", qualifier='" + qualifier + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
}
