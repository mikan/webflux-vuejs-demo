package com.github.mikan.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@SpringBootApplication
class App

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}

@Component
class IndexHandler {
    @Value("classpath:/static/index.html")
    private lateinit var indexHtml: Resource

    @Bean
    fun indexRoutes(): RouterFunction<ServerResponse> {
        val handler = HandlerFunction { get(it) }
        return RouterFunctions.route(RequestPredicates.GET("/"), handler)
                .andRoute(RequestPredicates.GET("/page"), handler)
                .andRoute(RequestPredicates.GET("/page/{sub1}"), handler)
                .andRoute(RequestPredicates.GET("/page/{sub1}/{sub2}"), handler)
    }

    fun get(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().contentType(MediaType.TEXT_HTML).syncBody(indexHtml)
    }
}
