package com.nouhaTeamleaf.nouhaTeamleaf.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EtatSession {
    VALIDER(0),
    INVALIDER(1);
    private final long indexEnumEtat;
}
