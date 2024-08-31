package com.project.gameShop.repository

import com.project.gameShop.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<Users, Long>{

    fun findByLogin(login: String): UserDetails?

}