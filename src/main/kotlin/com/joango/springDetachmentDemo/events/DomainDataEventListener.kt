package com.joango.springDetachmentDemo.events

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import com.joango.springDetachmentDemo.services.NotificationHandlerService
import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component("DomainDataEventListener")
class DomainDataEventListener (
    val notificationHandlerService: NotificationHandlerService
){

    private val logger = KotlinLogging.logger {}

    init {
        logger.info { "Initializing event listener..." }
    }

    @EventListener
    fun listenDomainDataEvent(event: DomainDataEvent) {
        logger.info { "Listening event for domain data: " +
                "$event" }
        notificationHandlerService.processDomainData(event)
    }
}