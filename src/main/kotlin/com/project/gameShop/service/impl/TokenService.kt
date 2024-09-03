package com.project.gameShop.service.impl

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.project.gameShop.entity.Users
import org.flywaydb.core.internal.license.FlywayJWTValidationException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.sql.Date

@Service
class TokenService{

    @Value("\${api.security.token.secret}")
    lateinit var secret: String

    fun generationToken(user: Users): String {
        try{
            val algorithm = Algorithm.HMAC256(secret)
            val token = JWT.create()
                .withIssuer("auth-api")
                .withSubject(user.login)
                .withExpiresAt(Date(System.currentTimeMillis() + 3600 * 2000))
                .sign(algorithm)
            return token
        }catch(excption: JWTCreationException){
            throw RuntimeException("Error white generation token, ${excption.message}")
        }
    }

    fun validationToken(token: String): String {
        try{
            val algorithm = Algorithm.HMAC256(secret)
            return JWT.require(algorithm)
                        .withIssuer("auth-api")
                        .build()
                        .verify(token)
                        .subject
        }catch(excption: FlywayJWTValidationException){
            throw RuntimeException("Error white generation token, ${excption.message}")
        }
    }
}