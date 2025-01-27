package com.fwtcompany.desafio_uol.repository;

import com.fwtcompany.desafio_uol.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
