package com.project.gameShop.dto.response

import com.project.gameShop.entity.Game

data class GameView(

    val nameGame: String,
    val price: Int,
    val category: String,
    val gender: String

){

    constructor(game: Game): this(
        nameGame = game.nameGame,
        price = game.price,
        category = game.category,
        gender = game.gender
    )

}
