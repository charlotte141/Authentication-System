package com.project.gameShop.entity

import com.project.gameShop.enummeration.Roles
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
data class Users (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false) val login: String,
    @Column(nullable = false) val passWord: String,
    @Column(nullable = false) val roles: Roles

): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return if(this.roles == Roles.ADMIN) mutableListOf(SimpleGrantedAuthority("ROLE_ADMIN"), SimpleGrantedAuthority("ROLE_USER"))
        else mutableListOf(SimpleGrantedAuthority("ROLE_USER"))
    }

    override fun getPassword(): String {
        return passWord
    }

    override fun getUsername(): String {
        return login
    }

}
