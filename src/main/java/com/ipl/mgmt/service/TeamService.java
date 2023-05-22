package com.ipl.mgmt.service;

import com.ipl.mgmt.model.Team;
import com.ipl.mgmt.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The TeamService class provides operations to manage Team information.
 * It interacts with the TeamRepository to perform CRUD operations on the Team entity.
 */
@Slf4j
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    /**
     * Retrieves all teams.
     *
     * @return List of Team objects
     */
    public List<Team> getAllTeams() {
        log.info("Fetching all teams");
        return teamRepository.findAll();
    }

    /**
     * Retrieves a team by ID.
     *
     * @param teamId the ID of the team
     * @return Team object if found, null otherwise
     */
    public Team getTeamById(Integer teamId) {
        log.info("Fetching team by ID: {}", teamId);
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        return teamOptional.orElse(null);
    }

    /**
     * Saves a team.
     *
     * @param team the Team object to be saved
     * @return saved Team object
     */
    public Team saveTeam(Team team) {
        log.info("Saving team: {}", team);
        return teamRepository.save(team);
    }

    /**
     * Deletes a team by ID.
     *
     * @param teamId the ID of the team to be deleted
     * @throws IllegalArgumentException if team with the given ID doesn't exist
     */
    public void deleteTeam(Integer teamId) {
        log.info("Deleting team by ID: {}", teamId);
        if (teamRepository.existsById(teamId)) {
            teamRepository.deleteById(teamId);
        } else {
            throw new IllegalArgumentException("Team with ID " + teamId + " does not exist");
        }
    }
}
