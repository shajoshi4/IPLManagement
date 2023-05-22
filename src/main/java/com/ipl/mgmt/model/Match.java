package com.ipl.mgmt.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matchId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team1_id")
    private Team team1;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team2_id")
    private Team team2;
    
    @Column
    private String venue;
    
    @Column
    private LocalDateTime matchDateTime;
    
    @Column
    private Long totalTicketsSold;
    
    @Column
    private int totalOvers;

    @Column
    private String winnerTeam;
    
    @Column
    private String manOfTheMatch;

}
