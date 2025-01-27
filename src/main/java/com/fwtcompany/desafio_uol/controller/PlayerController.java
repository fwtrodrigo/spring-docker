package com.fwtcompany.desafio_uol.controller;

import com.fwtcompany.desafio_uol.model.Player;
import com.fwtcompany.desafio_uol.model.dto.PlayerDto;
import com.fwtcompany.desafio_uol.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerDto dto) {
        Player player = service.createPlayer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(player);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = service.getAllPlayers();
        return ResponseEntity.ok(players);
    }

}
