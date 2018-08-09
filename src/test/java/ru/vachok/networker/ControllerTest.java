package ru.vachok.networker;


import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class ControllerTest {

   private MockMvc mockMvc;

   public void indexSchouldRetHTMLPage() throws Exception {
      mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Welcome ")));
   }

   public void apiControllerShouldReturnVisits() throws Exception {
      mockMvc.perform(get("/api/visits"))
            .andExpect(jsonPath("$.*.description", iterableWithSize(1)));
   }
}
