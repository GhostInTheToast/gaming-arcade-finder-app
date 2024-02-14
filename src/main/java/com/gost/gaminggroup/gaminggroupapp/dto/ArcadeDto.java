package com.gost.gaminggroup.gaminggroupapp.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

// Dto object (data transfer object) for transferring less info. Made ahead of time just in case.
@Data
@Builder
public class ArcadeDto {
    private long id;
    private String name;
    private String photoUrl;
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
