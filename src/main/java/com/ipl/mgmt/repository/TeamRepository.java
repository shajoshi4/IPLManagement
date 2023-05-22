package com.ipl.mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipl.mgmt.model.Player;
import com.ipl.mgmt.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{

}
