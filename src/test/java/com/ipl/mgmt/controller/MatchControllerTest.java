package com.ipl.mgmt.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ipl.mgmt.model.Match;
import com.ipl.mgmt.service.MatchService;


@ExtendWith(MockitoExtension.class)
public class MatchControllerTest {

    @Mock
    private MatchService matchService;

    @InjectMocks
    private MatchController matchController;

    private List<Match> dummyMatches;

        
    @Test
    public void testGetAllMatches() {
        when(matchService.getAllMatches()).thenReturn(dummyMatches);

        ResponseEntity<List<Match>> response = matchController.getAllMatches();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dummyMatches, response.getBody());
    }

    @Test
    public void testGetMatchById_ExistingMatch() {
        Long matchId = 1L;
        Match match = new Match(matchId, null, null, "Match 1", null, matchId, 0, null, null);
        when(matchService.getMatchById(matchId)).thenReturn(match);

        ResponseEntity<Match> response = matchController.getMatchById(matchId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(match, response.getBody());
    }

    @Test
    public void testGetMatchById_NonExistingMatch() {
        Long matchId = 3L;
        when(matchService.getMatchById(matchId)).thenReturn(null);

        ResponseEntity<Match> response = matchController.getMatchById(matchId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testCreateMatch() {
        Match match = new Match(3L, null, null, "Match 3", null, null, 0, null, null);
        when(matchService.saveMatch(match)).thenReturn(match);

        ResponseEntity<Match> response = matchController.createMatch(match);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(match, response.getBody());
    }


    @Test
    public void testDeleteMatch_ExistingMatch() {
        Long matchId = 1L;

        ResponseEntity<Void> response = matchController.deleteMatch(matchId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(matchService, times(1)).deleteMatch(matchId);
    }


}
