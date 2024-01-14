package com.ndgndg91.usejitpack.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(BookController::class)
class BookControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    @DisplayName("books_title_non_null")
    fun books_title_non_null() {
        // given

        // when - then
        mockMvc.perform(MockMvcRequestBuilders.post("/apis/books")
            .contentType(MediaType.APPLICATION_JSON)
            //language=json
            .content("{\n  \"title\": \"spring master 2024\"\n}")
        ).andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("ndgndg91 spring master 2024"))
    }

    @Test
    @DisplayName("books_title_null")
    fun books_title_null() {
        // given

        // when - then
        mockMvc.perform(MockMvcRequestBuilders.post("/apis/books")
            .contentType(MediaType.APPLICATION_JSON)
            //language=json
            .content("{\n  \"title\": null\n}")
        ).andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("none"))
    }
}