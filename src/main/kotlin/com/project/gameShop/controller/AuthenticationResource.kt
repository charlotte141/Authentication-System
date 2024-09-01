package com.project.gameShop.controller

import com.project.gameShop.dto.request.AuthenticationDto
import com.project.gameShop.dto.response.LoginView
import com.project.gameShop.dto.request.RegisterDto
import com.project.gameShop.entity.Users
import com.project.gameShop.service.impl.TokenService
import com.project.gameShop.service.impl.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationResource(
    private val userService: UserService,
    private val tokenService: TokenService,
    private val authenticationManager: AuthenticationManager
){

    @PostMapping("/login")
    fun handlerAuth(@RequestBody @Valid data: AuthenticationDto): ResponseEntity<LoginView>{
        val dataUserPasseword = UsernamePasswordAuthenticationToken(data.login, data.passWord)
        val auth = authenticationManager.authenticate(dataUserPasseword)
        val token = tokenService.generationToken(auth.principal as Users)

        return ResponseEntity.status(HttpStatus.OK).body(LoginView(token))
    }

    @PostMapping("/Register")
    fun register(@RequestBody @Valid data: RegisterDto): ResponseEntity<Authentication>{

        val userdetails = userService.loadUserByUsername(data.login)
        if (userdetails != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }

        userService.newUser(data.user())
        return ResponseEntity.status(HttpStatus.CREATED).build()

    }

}