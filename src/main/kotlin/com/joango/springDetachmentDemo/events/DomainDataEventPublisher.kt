package com.joango.springDetachmentDemo.events

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import mu.KotlinLogging
import org.springframework.context.annotation.DependsOn

@Service
@DependsOn("DomainDataEventListener")
class DomainDataEventPublisher(
    private val eventPublisher: ApplicationEventPublisher
) {

    private final val logger = KotlinLogging.logger {}

    init {
        logger.info { "Initializing event publisher..." }
    }

    fun publishSomeDomainDataEvent(domainDataEvent: DomainDataEvent) {
        logger.info { "Publishing event with domain data" }
        eventPublisher.publishEvent(domainDataEvent)
    }
}