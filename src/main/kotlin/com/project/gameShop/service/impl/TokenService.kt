package com.project.gameShop.service.impl


import com.philjay.jwt.Algorithm
import com.philjay.jwt.JWT
import com.project.gameShop.entity.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TokenService() {

    @Value("api.security.token.secret")
    lateinit var secret: String

    fun generationToken(user: User): String{
        try{
            val algorithm = Algorithm.RS256.
            val token = JWT
        }catch(){

        }
    }

}