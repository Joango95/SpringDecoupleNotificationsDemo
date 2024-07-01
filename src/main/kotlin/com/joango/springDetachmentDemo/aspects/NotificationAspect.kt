package com.joango.springDetachmentDemo.aspects

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import com.joango.springDetachmentDemo.services.NotificationHandlerService
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Component
@Aspect
class NotificationAspect (
    val notificationHandlerService: NotificationHandlerService
) {
    @After("execution(* com.joango.springDetachmentDemo.services.SomeDomainDataService.someCaseAHappens(..))")
    private fun someCaseAHappens(joinPoint: JoinPoint) {
        joinPoint.args
            .filterIsInstance<DomainDataEvent>()
            .forEach {
                notificationHandlerService.processDomainData(it)
            }
    }

    @After("execution(* com.joango.springDetachmentDemo.services.SomeDomainDataService.someCaseBHappens(..))")
    private fun someCaseBHappens(joinPoint: JoinPoint) {
        joinPoint.args
            .filterIsInstance<DomainDataEvent>()
            .forEach {
                notificationHandlerService.somethingHappenedOnCaseBThatNeedsSpecialLogic(it)
            }
    }
}