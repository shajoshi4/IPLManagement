package com.ipl.mgmt.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
@Table(name = "IPL_MANAGEMENT")
public class IPLManagement {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String season;
    
    @Column
    private String hostCountry;
    
    @ElementCollection
    @CollectionTable(name = "ipl_sponsors")
    @Column(name = "sponsor")
    private List<String> sponsors;
    
//    @OneToMany(mappedBy = "iplManagement", cascade = CascadeType.ALL)
//    @JoinColumn(name = "ipl_management_id")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ipl_management_id")
    private List<Match> matches;

}
