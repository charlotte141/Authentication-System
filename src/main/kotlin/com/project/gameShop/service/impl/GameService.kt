package com.project.gameShop.service.impl

import com.project.gameShop.entity.Game
import com.project.gameShop.repository.GameRepository
import com.project.gameShop.service.IGameService
import org.springframework.stereotype.Service

@Service
class GameService(
    private val repositor: GameRepository
): IGameService {

    override fun buy(game: Game): String{
        repositor.save(game)
        return "New Game -$"
    }

    override fun findByID(id: Long): Game = repositor.findById(id).orElseThrow {
        throw RuntimeException("game id not found")
    }

    override fun all(): List<Game> = repositor.findAll()

    override fun sell(game: Game): String{
        repositor.delete(game)
        return "Game sell $"
    }

}