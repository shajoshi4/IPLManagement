package com.ipl.mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipl.mgmt.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
