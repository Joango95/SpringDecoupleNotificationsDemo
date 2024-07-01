package com.joango.springDetachmentDemo.event

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import com.joango.springDetachmentDemo.service.DetachedService
import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(1)
class DomainDataEventListener (
    val detachedService: DetachedService
){

    private val logger = KotlinLogging.logger {}

    init {
        logger.info { "Initializing event listener..." }
    }

    @EventListener
    fun listenDomainDataEvent(event: DomainDataEvent) {
        logger.info { "Listening event for domain data: " +
                "$event" }
        detachedService.processDomainData(event)
    }
}