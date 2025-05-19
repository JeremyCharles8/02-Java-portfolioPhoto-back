package com.jcharles.portfolioApi.integration.controlleur;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.jcharles.portfolioApi.controller.PhotoController;
import com.jcharles.portfolioApi.service.PhotoService;

@WebMvcTest(controllers = PhotoController.class)
public class PhotoCotrollerTest {
  
  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private PhotoService photoService;

  @Test
  public void testGetAllPhotos()throws Exception {
    mockMvc.perform(get("/photos"))
      .andExpect(status().isOk());
  }
}
