package com.ipl.mgmt.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.mgmt.model.IPLManagement;
import com.ipl.mgmt.model.Match;
import com.ipl.mgmt.model.Player;
import com.ipl.mgmt.model.Team;
import com.ipl.mgmt.repository.IPLManagementRepository;
import com.ipl.mgmt.repository.MatchRepository;
import com.ipl.mgmt.repository.PlayerRepository;
import com.ipl.mgmt.repository.TeamRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * The IPLManagementService class provides operations to manage IPL Management information.
 * It interacts with the IPLManagementRepository, PlayerRepository, TeamRepository, and MatchRepository
 * to perform CRUD operations on the IPLManagement, Player, Team, and Match entities.
 */
@Slf4j
@Service
@Transactional
public class IPLManagementService {

    @Autowired
    private IPLManagementRepository iplManagementRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    
    
    /**
     * Saves IPL Management information by creating players, teams, and matches.
     * This is a sample method to populate the IPL Management information with realistic data.
     * It can be called to initialize the data.
     */
    public void saveIplManagementInfo() {
        log.info("Saving IPL Management information");

        // Create player objects
        Player player1 = new Player();
        Player player2 = new Player();
        player1 = playerRepository.save(player1);
        player2 = playerRepository.save(player2);

        // Create team objects
        Team team1 = new Team();
        team1.setPlayers(Arrays.asList(player1));
        Team team2 = new Team();
        team2.setPlayers(Arrays.asList(player2));
        team1 = teamRepository.save(team1);
        team2 = teamRepository.save(team2);

        // Create match object
        Match match = new Match();
        match.setTeam1(team1);
        match.setTeam2(team2);
        match = matchRepository.save(match);

        // Create IPL management object
        IPLManagement iplManagement = new IPLManagement();
        iplManagement.setMatches(Arrays.asList(match));

        iplManagementRepository.save(iplManagement);
    }

    
    
    /**
     * Retrieves all IPL Management information.
     *
     * @return List of IPLManagement objects
     */
    public List<IPLManagement> getAllIPLManagementInfo() {
        log.info("Fetching all IPL Management information");
        return iplManagementRepository.findAll();
    }

    
    
    /**
     * Retrieves IPL Management information by ID.
     *
     * @param id the ID of the IPL Management
     * @return IPLManagement object
     * @throws IllegalArgumentException if IPLManagement with the given ID doesn't exist
     */
    public IPLManagement getIPLManagementInfoById(Long id) {
        log.info("Fetching IPL Management information with ID: {}", id);
        return iplManagementRepository.findById(id).orElse(null);
    }
    
    

    /**
     * Saves IPL Management information.
     *
     * @param iplManagement the IPLManagement object to be saved
     * @return saved IPLManagement object
     */
    public IPLManagement saveIPLManagementInfo(IPLManagement iplManagement) {
        log.info("Saving IPL Management information: {}", iplManagement);
        return iplManagementRepository.save(iplManagement);
    }
    
    

    /**
     * Deletes IPL Management information by ID.
     *
     * @param id the ID of the IPL Management to be deleted
     * @throws IllegalArgumentException if IPLManagement with the given ID doesn't exist
     */
    public void deleteIPLManagementInfo(Long id) {
        log.info("Deleting IPL Management information with ID: {}", id);
        if (iplManagementRepository.existsById(id)) {
            iplManagementRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("IPL Management with ID " + id + " does not exist");
        }
    }

    
    
}
