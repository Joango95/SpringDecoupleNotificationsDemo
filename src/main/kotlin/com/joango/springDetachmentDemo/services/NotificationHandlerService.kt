package com.joango.springDetachmentDemo.services

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class NotificationHandlerService {
    private final val logger = KotlinLogging.logger {}

    private var eventsProcessed = mutableListOf<DomainDataEvent>()

    fun processDomainData(domainDataEvent: DomainDataEvent) {
        logger.info { "Processing domain data on detached service" }
        eventsProcessed.add(domainDataEvent)
    }

    fun somethingHappenedOnCaseBThatNeedsSpecialLogic(domainDataEvent: DomainDataEvent) {
        logger.info { "Event got propagated through aspect $domainDataEvent" }
    }

    fun clearEventsProcessed() {
        eventsProcessed.clear()
    }

    fun getEventsProcessedSize(): Int {
        return eventsProcessed.size
    }

    fun getEventsProcessedList(): List<DomainDataEvent> {
        return eventsProcessed
    }

}