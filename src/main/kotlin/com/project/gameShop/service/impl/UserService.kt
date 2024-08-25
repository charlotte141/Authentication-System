package com.project.gameShop.service.impl

import com.project.gameShop.entity.User
import com.project.gameShop.repository.UserRepository
import com.project.gameShop.service.IUserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
): UserDetailsService, IUserService {

    override fun newUser(user: User){
        userRepository.save(user)
    }

    override fun loadUserByUsername(username: String): UserDetails? {
        return userRepository.findByUsername(username)
    }

}