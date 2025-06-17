package com.jcharles.portfolioApi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlbumDto {
  
  @NotNull
  @NotBlank
  @Size(max = 100)
  private String name;
}
