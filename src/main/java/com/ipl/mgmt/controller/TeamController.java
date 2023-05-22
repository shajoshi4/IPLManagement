package com.ipl.mgmt.controller;

import com.ipl.mgmt.model.Team;
import com.ipl.mgmt.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The TeamController class is a REST controller that handles requests related to Team operations.
 * It provides endpoints to retrieve, create, update, and delete Team information.
 */
@Slf4j
@RestController
@RequestMapping("/v1/teams")
public class TeamController {

	
    @Autowired
    private TeamService teamService;

    /**
     * Endpoint to retrieve all teams.
     *
     * @return List of Team objects
     */
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        log.info("Retrieving all teams");
        List<Team> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    
    /**
     * Endpoint to retrieve a team by its ID.
     *
     * @param teamId the ID of the team
     * @return Team object
     */
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") Integer teamId) {
        log.info("Retrieving team with ID: {}", teamId);
        Team team = teamService.getTeamById(teamId);
        if (team != null) {
            return ResponseEntity.ok(team);
        } else {
            log.warn("Team not found with ID: {}", teamId);
            return ResponseEntity.notFound().build();
        }
    }

    
    /**
     * Endpoint to create a new team.
     *
     * @param team the Team object to be created
     * @return created Team object
     */
    @PostMapping
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        log.info("Creating a new team");
        Team createdTeam = teamService.saveTeam(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeam);
    }
    

    /**
     * Endpoint to update a team by its ID.
     *
     * @param teamId the ID of the team
     * @param team   the Team object with updated information
     * @return updated Team object
     */
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable("id") Integer teamId, @RequestBody Team team) {
        log.info("Updating team with ID: {}", teamId);
        team.setTeamId(teamId);
        Team updatedTeam = teamService.saveTeam(team);
        return ResponseEntity.ok(updatedTeam);
    }

    
    /**
     * Endpoint to delete a team by its ID.
     *
     * @param teamId the ID of the team to be deleted
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable("id") Integer teamId) {
        log.info("Deleting team with ID: {}", teamId);
        teamService.deleteTeam(teamId);
        return ResponseEntity.noContent().build();
    }
}
