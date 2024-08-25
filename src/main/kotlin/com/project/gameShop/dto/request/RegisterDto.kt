package com.project.gameShop.dto.request

import com.project.gameShop.entity.User
import com.project.gameShop.enummeration.Roles
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

data class RegisterDto(

    val username: String,
    var password: String,
    val roles: Roles

){

    fun user(): User {

        password = BCryptPasswordEncoder().encode(password)

        return User(
            username = this.username,
            password = this.password,
            roles = this.roles
        )

    }

}
