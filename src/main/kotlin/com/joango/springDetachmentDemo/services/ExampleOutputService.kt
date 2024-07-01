package com.joango.springDetachmentDemo.services

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class ExampleOutputService {

    private final val logger = KotlinLogging.logger {}

    @EventListener
    fun outputServiceFunctionWhenDomainEventHappens(event: DomainDataEvent) {
        logger.info { "Output service $event" }
    }
}