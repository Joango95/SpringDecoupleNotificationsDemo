package com.joango.springDetachmentDemo.services

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class ExamplePersistenceService {

    private final val logger = KotlinLogging.logger {}

    @EventListener
    fun persistenceFunctionWhenDomainEventHappens(event: DomainDataEvent) {
        logger.info { "Persistence service $event" }
    }
}