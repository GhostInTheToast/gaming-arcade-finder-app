package com.gost.gaminggroup.gaminggroupapp.services;

import com.gost.gaminggroup.gaminggroupapp.dto.ArcadeDto;

import java.util.List;

public interface ArcadeService {
    List<ArcadeDto> findAllArcades();
}
