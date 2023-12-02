package com.example.ownapirest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;


@SpringBootTest
@AutoConfigureMockMvc
class restApiTest {

    @Autowired
    private MockMvc mvc;
    @Test
    void getCharacters()throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/getCharacters")
                        .with(httpBasic("usuario","1234"))
                .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getCharacterById() {
    }

    @Test
    void getLogs() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/getLogs")
                .with(httpBasic("usuario","1234"))
                .contentType(MediaType.APPLICATION_JSON));
    }
}