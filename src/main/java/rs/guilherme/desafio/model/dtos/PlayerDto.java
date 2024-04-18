package rs.guilherme.desafio.model.dtos;

import rs.guilherme.desafio.model.enums.HeroGroup;

public record PlayerDto
(
    String name,
    String email,
    String phoneNumber,
    HeroGroup heroGroup
) {}
