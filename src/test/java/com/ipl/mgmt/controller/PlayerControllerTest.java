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
import com.ipl.mgmt.service.MatchService;
import com.ipl.mgmt.service.PlayerService;


@ExtendWith(MockitoExtension.class)
public class PlayerControllerTest {
	
    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    private List<Player> dummyPlayers;
    
    @Test
    public void testGetAllPlayers() {
        when(playerService.getAllPlayers()).thenReturn(dummyPlayers);

        ResponseEntity<List<Player>> response = playerController.getAllPlayers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dummyPlayers, response.getBody());
    }

    @Test
    public void testGetPlayerById_ExistingPlayer() {
        Integer playerId = 1;
        Player player = new Player(playerId, "Player 1", playerId, null, null, playerId, null, null, null, null, null, null);
        when(playerService.getPlayerById(playerId)).thenReturn(player);

        ResponseEntity<Player> response = playerController.getPlayerById(playerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(player, response.getBody());
    }

    
    @Test
    public void testAddPlayer() {
        Player player = new Player(3, "Player 3", 0, null, null, 0, null, null, null, null, null, null);
        when(playerService.savePlayer(player)).thenReturn(player);

        ResponseEntity<Player> response = playerController.addPlayer(player);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(player, response.getBody());
    }
   

    @Test
    public void testDeletePlayer_ExistingPlayer() {
        Integer playerId = 1;

        ResponseEntity<Void> response = playerController.deletePlayer(playerId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(playerService, times(1)).deletePlayer(playerId);
    }

    @Test
    public void testDeletePlayer_NonExistingPlayer() {
        Integer playerId = 3;

        ResponseEntity<Void> response = playerController.deletePlayer(playerId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(playerService, times(1)).deletePlayer(playerId);
    }


}
