package com.project.gameShop.dto.request

import com.project.gameShop.entity.Users
import com.project.gameShop.enummeration.Roles
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

data class RegisterDto(

    val login: String,
    var passWord: String,
    val roles: Roles

){

    fun user(): Users {

        passWord = BCryptPasswordEncoder().encode(passWord)

        return Users(
            login = this.login,
            passWord = this.passWord,
            roles = this.roles
        )

    }

}
