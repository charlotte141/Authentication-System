package com.project.gameShop.configuration

import com.project.gameShop.service.impl.TokenService
import com.project.gameShop.service.impl.UserService
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
//import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
class Securityfilter(
    private val tokenService: TokenService,
    private val userService: UserService
) : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain){
        val token = recoveryToken(request)
        if(token != null){
            val userName = tokenService.validationToken(token)
            val user = userService.loadUserByUsername(userName)

            if(user != null){
                val authentication = UsernamePasswordAuthenticationToken(userName, null, user.authorities)
                SecurityContextHolder.getContext().authentication = authentication
            }
        }

        /*val authentication = SecurityContextHolder.getContext().authentication
        val isAdmin = authentication?.authorities?.contains(SimpleGrantedAuthority("ROLE_ADMIN")) ?: false
        if (request.requestURI.contains("/admin") && !isAdmin) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden")
            return
        }*/

        filterChain.doFilter(request, response)
    }

    fun recoveryToken(request: HttpServletRequest): String?{
        val authHeader = request.getHeader("Authorization")
        return authHeader?.replace("Bearer", "")?.trim()
    }
}