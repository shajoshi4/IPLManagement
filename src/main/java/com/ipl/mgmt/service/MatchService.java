package com.ipl.mgmt.service;

import com.ipl.mgmt.model.Match;
import com.ipl.mgmt.repository.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * The MatchService class provides operations to manage Match information.
 * It interacts with the MatchRepository to perform CRUD operations on the Match entity.
 */
@Slf4j
@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    /**
     * Retrieves all matches.
     *
     * @return List of Match objects
     */
    public List<Match> getAllMatches() {
        log.info("Fetching all matches");
        return matchRepository.findAll();
    }


    /**
     * Retrieves a match by ID.
     *
     * @param matchId the ID of the match
     * @return Match object
     * @throws IllegalArgumentException if match with the given ID doesn't exist
     */
    public Match getMatchById(Long matchId) {
        log.info("Fetching match with ID: {}", matchId);
        Optional<Match> matchOptional = matchRepository.findById(matchId);
        return matchOptional.orElse(null);
    }


    /**
     * Saves a match.
     *
     * @param match the Match object to be saved
     * @return saved Match object
     */
    public Match saveMatch(Match match) {
        log.info("Saving match: {}", match);
        return matchRepository.save(match);
    }


    /**
     * Deletes a match by ID.
     *
     * @param matchId the ID of the match to be deleted
     * @throws IllegalArgumentException if match with the given ID doesn't exist
     */
    public void deleteMatch(Long matchId) {
        log.info("Deleting match with ID: {}", matchId);
        if (matchRepository.existsById(matchId)) {
            matchRepository.deleteById(matchId);
        } else {
            throw new IllegalArgumentException("Match with ID " + matchId + " does not exist");
        }
    }
}
