package com.project.gameShop.controller

import com.project.gameShop.dto.request.AuthenticationDto
import com.project.gameShop.dto.response.LoginView
import com.project.gameShop.dto.request.RegisterDto
import com.project.gameShop.service.impl.TokenService
import com.project.gameShop.service.impl.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationResource(
    private val userService: UserService,
    private val tokenService: TokenService
){

    @PostMapping("/login")
    fun handlerAuth(@RequestBody @Valid data: AuthenticationDto): ResponseEntity<LoginView>?{
        val user = userService.loadUserByUsername(data.login)

        if (user != null){
            val token = tokenService.generationToken(user)
            return ResponseEntity.status(HttpStatus.OK).body(LoginView(token, data.login))
        }

        return null
    }

    @PostMapping("/Register")
    fun register(@RequestBody @Valid data: RegisterDto): ResponseEntity<String>{

        val user = userService.loadUserByUsername(data.login)
        if (user != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user existente")
        }

        userService.newUser(data.user())
        return ResponseEntity.status(HttpStatus.CREATED).body("new user create")

    }

}