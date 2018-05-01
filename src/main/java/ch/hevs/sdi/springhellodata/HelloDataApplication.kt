package ch.hevs.sdi.springhellodata

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class HelloDataApplication

fun main(args: Array<String>) {
    SpringApplication.run(HelloDataApplication::class.java, *args)
}
