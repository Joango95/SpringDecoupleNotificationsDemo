package com.joango.springDetachmentDemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
@EnableAspectJAutoProxy
class SpringDetachmentDemoApplication

fun main(args: Array<String>) {
	runApplication<SpringDetachmentDemoApplication>(*args)
}
