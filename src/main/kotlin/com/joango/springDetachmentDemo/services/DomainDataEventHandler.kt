package com.joango.springDetachmentDemo.services

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class DomainDataEventHandler {
    private final val logger = KotlinLogging.logger {}

    private var eventsProcessed = mutableListOf<DomainDataEvent>()

    fun processDomainData(domainDataEvent: DomainDataEvent) {
        logger.info { "Processing domain data on detached service: " +
                "${domainDataEvent.firstProperty}, ${domainDataEvent.secondProperty}"
        }
        eventsProcessed.add(domainDataEvent)
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