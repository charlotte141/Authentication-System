package com.project.gameShop.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Getter
import lombok.Setter

@Entity
@Getter
@Setter
data class Game(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false) val nameGame: String,
    @Column(nullable = false) val price: Int,
    @Column(nullable = false) val category: String,
    @Column(nullable = false) val gender: String

)
