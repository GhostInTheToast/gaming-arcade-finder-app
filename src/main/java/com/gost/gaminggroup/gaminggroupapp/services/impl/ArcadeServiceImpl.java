package com.gost.gaminggroup.gaminggroupapp.services.impl;

import com.gost.gaminggroup.gaminggroupapp.dto.ArcadeDto;
import com.gost.gaminggroup.gaminggroupapp.models.Arcade;
import com.gost.gaminggroup.gaminggroupapp.repository.ArcadeRepository;
import com.gost.gaminggroup.gaminggroupapp.services.ArcadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArcadeServiceImpl implements ArcadeService {
    private ArcadeRepository arcadeRepository;

    @Autowired
    public ArcadeServiceImpl(ArcadeRepository arcadeRepository) {
        this.arcadeRepository = arcadeRepository;
    }

    @Override
    public List<ArcadeDto> findAllArcades() {
        List<Arcade> arcades = arcadeRepository.findAll();
        return arcades.stream().map((arcade) -> mapToArcadeDto(arcade)).collect(Collectors.toList());
    }



    @Override
    public Arcade saveArcade(Arcade arcade) {
        return arcadeRepository.save(arcade);
    }

    @Override
    public ArcadeDto findArcadeById(Long arcadeId) {
        Arcade arcade = arcadeRepository.findById(arcadeId).get();
        return mapToArcadeDto(arcade);
    }

    @Override
    public void updateArcade(ArcadeDto arcadeDto) {
        Arcade arcade = mapToArcade(arcadeDto);
        arcadeRepository.save(arcade);
    }

    private Arcade mapToArcade(ArcadeDto arcade) {
        Arcade arcadeDto = Arcade.builder()
                .id(arcade.getId())
                .name(arcade.getName())
                .photoUrl(arcade.getPhotoUrl())
                .content(arcade.getContent())
                .createdOn(arcade.getCreatedOn())
                .updatedOn(arcade.getUpdatedOn())
                .build();
        return arcadeDto;
    }

    private ArcadeDto mapToArcadeDto(Arcade arcade) {
        ArcadeDto arcadeDto = ArcadeDto.builder()
                .id(arcade.getId())
                .name(arcade.getName())
                .photoUrl(arcade.getPhotoUrl())
                .content(arcade.getContent())
                .createdOn(arcade.getCreatedOn())
                .updatedOn(arcade.getUpdatedOn())
                .build();
        return arcadeDto;
    }

}
