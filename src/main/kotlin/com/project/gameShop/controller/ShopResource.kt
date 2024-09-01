package com.project.gameShop.controller

import com.project.gameShop.dto.request.GameDto
import com.project.gameShop.dto.response.GameView
import com.project.gameShop.entity.Game
import com.project.gameShop.service.impl.GameService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
@RequestMapping("Api/ShopGame")
class ShopResource(
    private val service: GameService
) {

    @PostMapping("/new-game")
    fun buyGame(@RequestBody @Valid game: GameDto): ResponseEntity<String>{
        val text = service.buy(game.game())
        return ResponseEntity.status(HttpStatus.OK).body(text)
    }

    @GetMapping("/catalogy")
    fun allGame(): ResponseEntity<List<GameView>>{
        val games = service.all()
        return ResponseEntity.status(HttpStatus.OK).body(
            games.stream().map {
                game: Game -> GameView(game)
            }.collect(Collectors.toList())
        )
    }

    @GetMapping("/findBy-codigo")
    fun consultByID(@RequestParam id: Long): ResponseEntity<GameView>{
        val game = service.findByID(id)
        return ResponseEntity.status(HttpStatus.OK).body(GameView(game))
    }

    @DeleteMapping("/sell-game/{id}")
    fun sellGame(@PathVariable id: Long): ResponseEntity<String>{
        val game = service.findByID(id)
        val text = service.sell(game)
        return ResponseEntity.status(HttpStatus.OK).body(text)
    }

}