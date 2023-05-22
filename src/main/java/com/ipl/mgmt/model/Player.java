package com.ipl.mgmt.model;

import java.time.Year;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer playerId;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private Year iplDebut;
	
	@Column(nullable = false)
    private int totalMatchesPlayed;
	
	@Column
    private String specialization;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "batsman_info_id")
    private BatsmanInfo batsmanInfo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bowler_info_id")
    private BowlerInfo bowlerInfo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "captain_info_id")
    private CaptainInfo captainInfo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fielder_info_id")
    private FielderInfo fielderInfo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wicket_info_id")
    private WicketKeeperInfo wicketKeeperInfo;

}
