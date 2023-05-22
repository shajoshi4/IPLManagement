package com.ipl.mgmt.service;

import com.ipl.mgmt.model.Player;
import com.ipl.mgmt.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * The PlayerService class provides operations to manage Player information.
 * It interacts with the PlayerRepository to perform CRUD operations on the Player entity.
 */
@Slf4j
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    
    /**
     * Retrieves all players.
     *
     * @return List of Player objects
     */
    public List<Player> getAllPlayers() {
        log.info("Fetching all players");
        return playerRepository.findAll();
    }

    
    
    /**
     * Retrieves a player by ID.
     *
     * @param playerId the ID of the player
     * @return Player object
     */
    public Player getPlayerById(Integer playerId) {
        log.info("Fetching player with ID: {}", playerId);
        return playerRepository.findById(playerId).orElse(null);
    }

    
    
    /**
     * Saves a player.
     *
     * @param player the Player object to be saved
     * @return saved Player object
     */
    public Player savePlayer(Player player) {
        log.info("Saving player: {}", player);
        return playerRepository.save(player);
    }

    
    
    /**
     * Deletes a player by ID.
     *
     * @param playerId the ID of the player to be deleted
     */
    public void deletePlayer(Integer playerId) {
        log.info("Deleting player with ID: {}", playerId);
        playerRepository.deleteById(playerId);
    }
}
