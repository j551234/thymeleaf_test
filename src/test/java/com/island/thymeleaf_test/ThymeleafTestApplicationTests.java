package com.island.thymeleaf_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class ThymeleafTestApplicationTts {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void contextLoads() {
    }

    @Test
    public void getHello() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }

    @Test
    void sayHi() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(print()).
                andExpect(content().string("hihi"));
    }

}
