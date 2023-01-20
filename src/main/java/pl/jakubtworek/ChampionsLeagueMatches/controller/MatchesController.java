package pl.jakubtworek.ChampionsLeagueMatches.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pl.jakubtworek.ChampionsLeagueMatches.controller.response.MatchResponse;
import pl.jakubtworek.ChampionsLeagueMatches.model.*;
import pl.jakubtworek.ChampionsLeagueMatches.service.MatchesService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class MatchesController {
    private final MatchesService matchesService;

    public MatchesController(MatchesService matchesService) {
        this.matchesService = matchesService;
    }

    @GetMapping("/matches/{numberOfMatches}")
    public ResponseEntity<List<MatchResponse>> getMostProbableResults(@PathVariable int numberOfMatches) throws IOException {
        List<MatchResponse> matches = matchesService.getMostProbableResults(numberOfMatches)
                .stream()
                .map(Event::toResponse)
                .collect(Collectors.toList());

        return new ResponseEntity<>(
                matches,
                HttpStatus.OK
        );
    }

    @GetMapping("/teams/{competition}")
    public ResponseEntity<List<String>> getTeamsByCompetition(@PathVariable String competition) throws IOException {
        String competitionName = extractWhiteSpacesFromName(competition);

        List<String> teams = matchesService.getTeamsByCompetition(competitionName)
                .stream()
                .map(Competitor::getName)
                .collect(Collectors.toList());

        return new ResponseEntity<>(
                teams,
                HttpStatus.OK
        );
    }

    private String extractWhiteSpacesFromName(String name){
        String[] parts = name.split("%20");
        StringBuilder sb = new StringBuilder();

        for (String part : parts) {
            sb.append(part).append(" ");
        }
        sb.deleteCharAt(sb.toString().length() - 1);

        return sb.toString();
    }
}
