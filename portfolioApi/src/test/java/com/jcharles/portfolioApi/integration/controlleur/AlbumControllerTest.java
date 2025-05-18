package com.jcharles.portfolioApi.integration.controlleur;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.jcharles.portfolioApi.controller.AlbumController;
import com.jcharles.portfolioApi.service.AlbumService;

@WebMvcTest(controllers = AlbumController.class)
public class AlbumControllerTest {
  
  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private AlbumService albumService;

  @Test
  public void getAllAlbums() throws Exception {
    mockMvc.perform(get("/albums"))
      .andExpect(status().isOk());
  }
}
