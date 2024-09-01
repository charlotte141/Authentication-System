package com.project.gameShop.dto.request

import jakarta.validation.constraints.NotBlank

data class AuthenticationDto(

    @field:NotBlank val login: String,
    @field:NotBlank val passWord: String

)
