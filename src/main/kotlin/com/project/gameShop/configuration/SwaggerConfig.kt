package com.project.gameShop.configuration

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig {

    @Bean
    fun openApi(): GroupedOpenApi?{
        return GroupedOpenApi.builder()
            .group("Springgameshopsystem-public")
            .pathsToMatch("/Shop/**")
            .build()
    }

}