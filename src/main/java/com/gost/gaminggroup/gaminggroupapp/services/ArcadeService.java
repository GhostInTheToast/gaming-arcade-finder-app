package com.gost.gaminggroup.gaminggroupapp.services;

import com.gost.gaminggroup.gaminggroupapp.dto.ArcadeDto;
import com.gost.gaminggroup.gaminggroupapp.models.Arcade;
import java.util.List;

public interface ArcadeService {
    List<ArcadeDto> findAllArcades();

    Arcade saveArcade(Arcade arcade);

    ArcadeDto findArcadeById(Long arcadeId);

    void updateArcade(ArcadeDto arcade);
}


