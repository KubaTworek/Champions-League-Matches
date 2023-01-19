package pl.jakubtworek.ChampionsLeagueMatches.controller;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.jakubtworek.ChampionsLeagueMatches.model.Event;
import pl.jakubtworek.ChampionsLeagueMatches.service.MatchesService;

import java.util.*;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class MatchesControllerTest {
    @Mock
    private MatchesService matchesService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        matchesService = mock(MatchesService.class);
    }

}
