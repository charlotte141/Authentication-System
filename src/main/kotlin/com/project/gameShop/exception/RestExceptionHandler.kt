package com.project.gameShop.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handler(ex: Exception): ResponseEntity<ExceptionDetails> = ResponseEntity.status(HttpStatus.CONFLICT).body(
        ExceptionDetails(
            title = "Bad Request",
            timestamp = LocalDateTime.now(),
            status = HttpStatus.CONFLICT.value(),
            exception = javaClass.toString(),
            details = mutableMapOf(ex.message.toString() to ex.cause.toString())
        )
    )
}