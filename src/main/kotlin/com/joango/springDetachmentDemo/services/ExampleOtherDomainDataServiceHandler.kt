package com.joango.springDetachmentDemo.services

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class ExampleOtherDomainDataServiceHandler {

    private final val logger = KotlinLogging.logger {}

    @EventListener
    fun otherDomainEventServiceFunctionWhenDomainEventHappens(event: DomainDataEvent) {
        logger.info { "Other domain event service $event" }
    }
}