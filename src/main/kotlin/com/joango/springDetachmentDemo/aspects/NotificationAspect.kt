package com.joango.springDetachmentDemo.aspects

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import com.joango.springDetachmentDemo.services.DomainDataEventHandler
import mu.KotlinLogging
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Component
@Aspect
class NotificationAspect (
    val domainDataEventHandler: DomainDataEventHandler
) {

    private final val logger = KotlinLogging.logger {}

    @After("execution(* *someCase*(..))")
    private fun someCaseAHappens(joinPoint: JoinPoint) {
        logger.info { "Aspect executed for ${joinPoint.signature}" }
        joinPoint.args
            .filterIsInstance<DomainDataEvent>()
            .forEach {
                domainDataEventHandler.processDomainData(it)
            }
    }
}