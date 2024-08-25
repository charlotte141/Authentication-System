package com.project.gameShop.dto.request

import com.project.gameShop.entity.Game
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class GameDto(

    @field:NotBlank val nameGame: String,
    @field:NotNull val price: Int,
    @field:NotBlank val category: String,
    @field:NotBlank val gender: String

){

    fun game(): Game = Game(
        nameGame = this.nameGame,
        price = this.price,
        category = this.category,
        gender = this.gender
    )

}
