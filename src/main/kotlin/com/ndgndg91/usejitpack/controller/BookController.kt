package com.ndgndg91.usejitpack.controller

import com.ndgndg91.usejitpack.controller.dto.request.AddBookRequest
import com.ndgndg91.usejitpack.controller.dto.response.AddBookResponse
import extensions.doAndReturnWhenNotNull
import extensions.doWhenNotNull
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController {
    private val logger = LoggerFactory.getLogger(BookController::class.java)

    @PostMapping("/apis/books")
    fun books(@RequestBody body: AddBookRequest): ResponseEntity<AddBookResponse> {
        body.title.doWhenNotNull { logger.info("book title is {}", it) }
        return ResponseEntity.ok(AddBookResponse(body.title.doAndReturnWhenNotNull { "ndgndg91 $it" }?: "none"))
    }
}