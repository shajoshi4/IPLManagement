package com.ipl.mgmt.model;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teamId;
	
    @Column
    private String teamName;
    
    @Column
    private int numOfPlayers;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private List<Player> players;
    
    @Column
    private String coach;
    
    @Column
    private String homeVenue;
    
    @Column
    private int totalMatchesWon;
    
    @Column
    private int totalMatchesLost;
    
    @Column
    private int totalMatchesTied;
    
    @Column
    private int totalMatchesNoResult;
}
