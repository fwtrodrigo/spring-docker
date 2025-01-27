package com.fwtcompany.desafio_uol.model.dto;

import com.fwtcompany.desafio_uol.model.GroupType;

public record PlayerDto(String name, String email, String phoneNumber, GroupType groupType) {
}
