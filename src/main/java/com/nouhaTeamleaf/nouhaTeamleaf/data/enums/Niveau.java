package com.nouhaTeamleaf.nouhaTeamleaf.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Niveau {
    L1(0),
    L2(1),
    L3(2),
    M1(3),
    M2(4);
    private final long indexEnumEtat;

}
