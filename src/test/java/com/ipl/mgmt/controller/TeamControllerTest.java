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
import com.ipl.mgmt.model.Player;
import com.ipl.mgmt.model.Team;
import com.ipl.mgmt.service.MatchService;
import com.ipl.mgmt.service.PlayerService;
import com.ipl.mgmt.service.TeamService;


@ExtendWith(MockitoExtension.class)
public class TeamControllerTest {

    @Mock
    private TeamService teamService;

    @InjectMocks
    private TeamController teamController;

    private List<Team> dummyTeams;
    
    @Test
    public void testGetAllTeams() {
        when(teamService.getAllTeams()).thenReturn(dummyTeams);

        ResponseEntity<List<Team>> response = teamController.getAllTeams();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dummyTeams, response.getBody());
    }

    @Test
    public void testGetTeamById_ExistingTeam() {
        Integer teamId = 1;
        Team team = new Team(teamId, "Team 1", teamId, null, null, null, teamId, teamId, teamId, teamId);
        when(teamService.getTeamById(teamId)).thenReturn(team);

        ResponseEntity<Team> response = teamController.getTeamById(teamId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(team, response.getBody());
    }

    @Test
    public void testGetTeamById_NonExistingTeam() {
        Integer teamId = 3;
        when(teamService.getTeamById(teamId)).thenReturn(null);

        ResponseEntity<Team> response = teamController.getTeamById(teamId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testAddTeam() {
        Team team = new Team(3, "Team 3", 0, null, null, null, 0, 0, 0, 0);
        when(teamService.saveTeam(team)).thenReturn(team);

        ResponseEntity<Team> response = teamController.addTeam(team);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(team, response.getBody());
    }



    @Test
    public void testDeleteTeam_ExistingTeam() {
        Integer teamId = 1;

        ResponseEntity<Void> response = teamController.deleteTeam(teamId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(teamService, times(1)).deleteTeam(teamId);
    }

    @Test
    public void testDeleteTeam_NonExistingTeam() {
        Integer teamId = 3;

        ResponseEntity<Void> response = teamController.deleteTeam(teamId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(teamService, times(1)).deleteTeam(teamId);
    }


}
