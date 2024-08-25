package com.project.gameShop.repository

import com.project.gameShop.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long>{

    fun findByUsername(username: String): UserDetails?

}