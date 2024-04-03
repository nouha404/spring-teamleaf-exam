package com.nouhaTeamleaf.nouhaTeamleaf.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Specialiter {
    INFORMATIQUE(0),
    MATHS(1),
    PHYSIQUE(2),
    ANGULAR(3),
    JAVA(4),
    MARKETING(5),
    PYTHON(6),
    GEOGRAPHIE(7),
    ECONOMIE(8),
    PHILOSOPHIE(9),
    SPORT(10),
    MUSIQUE(11);
    private final long indexEnumEtat;
}
