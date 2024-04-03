package com.nouhaTeamleaf.nouhaTeamleaf.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeSession {
    EN_LIGNE(0),
    PRESENTIEL(1);
    private final long indexEnumEtat;
}
