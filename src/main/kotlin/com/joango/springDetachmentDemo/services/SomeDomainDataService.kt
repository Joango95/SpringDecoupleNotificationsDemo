package com.joango.springDetachmentDemo.services

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import com.joango.springDetachmentDemo.events.DomainDataEventPublisher
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class SomeDomainDataService (
    val domainDataEventPublisher: DomainDataEventPublisher
) {
    private final val logger = KotlinLogging.logger {}

    fun someCaseAHappens(domainDataEvent: DomainDataEvent) {
        logger.info { "Something happened and case A is called" +
                " with domain data event" }
    }

    fun someCaseBHappens(domainDataEvent: DomainDataEvent) {
        logger.info { "Something happened and case B is called " +
                "with domain data event" }
        domainDataEventPublisher.publishSomeDomainDataEvent(domainDataEvent)
    }
}