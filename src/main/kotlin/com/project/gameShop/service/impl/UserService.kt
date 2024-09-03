package com.project.gameShop.service.impl

import com.project.gameShop.entity.Users
import com.project.gameShop.repository.UserRepository
import com.project.gameShop.service.IUserService
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
): UserDetailsService, IUserService {

    override fun newUser(user: Users){
        userRepository.save(user)
    }

    override fun loadUserByUsername(login: String): Users? {
        return userRepository.findByLogin(login)
    }

}