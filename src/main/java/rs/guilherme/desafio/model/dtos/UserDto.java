package rs.guilherme.desafio.model.dtos;

import rs.guilherme.desafio.model.enums.HeroGroup;

public record UserDto
(
    String name,
    String email,
    String phoneNumber,
    HeroGroup heroGroup
) {}
