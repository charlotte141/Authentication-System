package com.project.gameShop.controller

import com.project.gameShop.dto.request.AuthenticationDto
import com.project.gameShop.dto.request.RegisterDto
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
    private val userService: UserService
){

    lateinit var authenticationManager: AuthenticationManager

    @PostMapping("/login")
    fun handlerAuth(@RequestBody @Valid data: AuthenticationDto): ResponseEntity<Authentication>{
        val dataUserPasseword = UsernamePasswordAuthenticationToken(data.username, data.password)
        val auth = authenticationManager.authenticate(dataUserPasseword)

        return ResponseEntity.status(HttpStatus.OK).build()
    }

    @PostMapping("/Register")
    fun register(@RequestBody @Valid data: RegisterDto): ResponseEntity<Authentication>{

        val userdetails = userService.loadUserByUsername(data.username)
        if (userdetails != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }

        userService.newUser(data.user())
        return ResponseEntity.status(HttpStatus.CREATED).build()

    }

}