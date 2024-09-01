package com.project.gameShop.dto.request

import com.project.gameShop.entity.Users
import com.project.gameShop.enummeration.Roles
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

data class RegisterDto(

    @field:NotBlank val login: String,
    @field:NotBlank var passWord: String,
    @field:NotNull  val roles: Roles

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
