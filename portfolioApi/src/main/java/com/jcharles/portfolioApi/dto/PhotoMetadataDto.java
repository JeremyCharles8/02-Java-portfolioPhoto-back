package com.jcharles.portfolioApi.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PhotoMetadataDto {
  
  @NotNull
  @NotBlank
  private String fileName;

  @NotBlank
  @Size(max = 140)
  private String title;

  @NotBlank
  @Size(max = 300)
  private String caption;

  private Integer albumId;
}
