package com.ipl.mgmt.controller;

import com.ipl.mgmt.model.Match;
import com.ipl.mgmt.service.MatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The MatchController class is a REST controller that handles requests related to Match operations.
 * It provides endpoints to create, retrieve, update, and delete Match information.
 */
@Slf4j
@RestController
@RequestMapping("/v1/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    /**
     * Endpoint to retrieve all matches.
     *
     * @return List of Match objects
     */
    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        log.info("Retrieving all matches");
        List<Match> matches = matchService.getAllMatches();
        return ResponseEntity.ok(matches);
    }

    /**
     * Endpoint to retrieve a match by its ID.
     *
     * @param matchId the ID of the match
     * @return Match object
     */
    @GetMapping("/{matchId}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long matchId) {
        log.info("Retrieving match by ID: {}", matchId);
        Match match = matchService.getMatchById(matchId);
        if (match != null) {
            return ResponseEntity.ok(match);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint to create a match.
     *
     * @param match the Match object to be created
     * @return created Match object
     */
    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        log.info("Creating a new match");
        Match savedMatch = matchService.saveMatch(match);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMatch);
    }

    /**
     * Endpoint to update a match by its ID.
     *
     * @param matchId the ID of the match
     * @param match   the Match object with updated information
     * @return updated Match object
     */
    @PutMapping("/{matchId}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long matchId, @RequestBody Match match) {
        log.info("Updating match with ID: {}", matchId);
        Match existingMatch = matchService.getMatchById(matchId);
        if (existingMatch != null) {
            match.setMatchId(matchId);
            Match updatedMatch = matchService.saveMatch(match);
            return ResponseEntity.ok(updatedMatch);
        } else {
            log.warn("Match not found with ID: {}", matchId);
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Endpoint to delete a match by its ID.
     *
     * @param matchId the ID of the match to be deleted
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{matchId}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long matchId) {
        log.info("Deleting match with ID: {}", matchId);
        try {
        matchService.deleteMatch(matchId);
        return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            log.warn("Failed to delete match with ID: {}", matchId, e);
            return ResponseEntity.notFound().build();
        }
    }
}
