package com.fwtcompany.desafio_uol.service;

import com.fwtcompany.desafio_uol.infra.CodenameHandler;
import com.fwtcompany.desafio_uol.model.GroupType;
import com.fwtcompany.desafio_uol.model.Player;
import com.fwtcompany.desafio_uol.model.dto.PlayerDto;
import com.fwtcompany.desafio_uol.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final CodenameHandler codenameHandler;

    public PlayerService(PlayerRepository playerRepository, CodenameHandler codenameHandler) {
        this.playerRepository = playerRepository;
        this.codenameHandler = codenameHandler;
    }

    public Player createPlayer(PlayerDto dto) {
        Player player = Player.builder().name(dto.name()).email(dto.email()).phoneNumber(dto.phoneNumber()).groupType(dto.groupType()).codename(getCodename(dto.groupType())).build();

        playerRepository.save(player);
        return player;
    }

    public String getCodename(GroupType groupType) {
        return codenameHandler.findCodename(groupType);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
