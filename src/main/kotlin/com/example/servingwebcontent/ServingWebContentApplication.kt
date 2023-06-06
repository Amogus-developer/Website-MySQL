package com.example.servingwebcontent

import com.example.servingwebcontent.`udp-request`.SourceEngineClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ServingWebContentApplication {

	@Bean
	fun getSourceEngineClient() = SourceEngineClient()
}

fun main(args: Array<String>) {
	runApplication<ServingWebContentApplication>(*args)
}
