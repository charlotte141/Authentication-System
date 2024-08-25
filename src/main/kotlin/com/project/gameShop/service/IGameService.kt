package com.project.gameShop.service

import com.project.gameShop.entity.Game

interface IGameService {

    fun buy(game: Game): String

    fun findByID(id: Long): Game

    fun all(): List<Game>

    fun sell(game: Game): String

}