package com.joango.springDetachmentDemo.service

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class DetachedService {
    private final val logger = KotlinLogging.logger {}

    var eventsProcessed = mutableListOf<DomainDataEvent>()

    fun processDomainData(domainDataEvent: DomainDataEvent) {
        logger.info { "Processing domain data on detached service" }
        eventsProcessed.add(domainDataEvent)
    }

}