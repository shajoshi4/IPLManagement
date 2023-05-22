package com.ipl.mgmt.controller;

import com.ipl.mgmt.model.Player;
import com.ipl.mgmt.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The PlayerController class is a REST controller that handles requests related to Player operations.
 * It provides endpoints to retrieve, create, update, and delete Player information.
 */
@Slf4j
@RestController
@RequestMapping("/v1/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    /**
     * Endpoint to retrieve all players.
     *
     * @return ResponseEntity with the list of Player objects
     */
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        log.info("Retrieving all players");
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    /**
     * Endpoint to retrieve a player by its ID.
     *
     * @param playerId the ID of the player
     * @return ResponseEntity with the Player object if found, or ResponseEntity with not found status if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Integer playerId) {
        log.info("Retrieving player by ID: {}", playerId);
        Player player = playerService.getPlayerById(playerId);
        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint to create a new player.
     *
     * @param player the Player object to be created
     * @return ResponseEntity with the created Player object and status code 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        log.info("Creating a new player");
        Player savedPlayer = playerService.savePlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
    }

    /**
     * Endpoint to update a player by its ID.
     *
     * @param playerId the ID of the player
     * @param player   the Player object with updated information
     * @return ResponseEntity with the updated Player object
     */
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable("id") Integer playerId, @RequestBody Player player) {
        log.info("Updating player with ID: {}", playerId);
        player.setPlayerId(playerId);
        Player updatedPlayer = playerService.savePlayer(player);
        return ResponseEntity.ok(updatedPlayer);
    }

    /**
     * Endpoint to delete a player by its ID.
     *
     * @param playerId the ID of the player to be deleted
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable("id") Integer playerId) {
        log.info("Deleting player with ID: {}", playerId);
        playerService.deletePlayer(playerId);
        return ResponseEntity.noContent().build();
    }
}
