package com.joango.springDetachmentDemo.services

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class ExampleExternalNotificationService {

    private final val logger = KotlinLogging.logger {}

    @EventListener
    fun externalNotificationServiceFunctionWhenDomainEventHappens(event: DomainDataEvent) {
        logger.info { "External notification service $event " }
    }
}