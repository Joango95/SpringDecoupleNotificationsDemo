package com.joango.springDetachmentDemo

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import com.joango.springDetachmentDemo.events.DomainDataEventPublisher
import com.joango.springDetachmentDemo.services.DomainDataEventHandler
import com.joango.springDetachmentDemo.services.SomeDomainDataService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class SpringDetachmentDemoApplicationTests {

	@Autowired
	lateinit var publishSomeDomainDataEvent: DomainDataEventPublisher

	@Autowired
	lateinit var domainDataEventHandler: DomainDataEventHandler

	@Autowired
	lateinit var someDomainDataService: SomeDomainDataService

	@Test
	fun contextLoads() {}

	@Test
	fun testAspectDataPropagation() {
		val myNewDomainDataEvent = DomainDataEvent("oneValue", 12345)

		someDomainDataService.someCaseAHappens(myNewDomainDataEvent)
		someDomainDataService.someCaseBHappens(myNewDomainDataEvent)
		someDomainDataService.someCaseCHappens(myNewDomainDataEvent)
		someDomainDataService.someCaseDHappens(myNewDomainDataEvent)
		someDomainDataService.someCaseEHappens(myNewDomainDataEvent)

		assertEquals(5, domainDataEventHandler.getEventsProcessedSize())
		assert(domainDataEventHandler.getEventsProcessedList().contains(myNewDomainDataEvent))
		domainDataEventHandler.clearEventsProcessed()
	}

	@Test
	fun testEventListener() {
		val myNewDomainDataEvent = DomainDataEvent("twoValue", 987654)

		publishSomeDomainDataEvent.publishSomeDomainDataEvent(myNewDomainDataEvent)

		/*assertEquals(1, notificationHandlerService.getEventsProcessedSize())
		assert(notificationHandlerService.getEventsProcessedList().contains(myNewDomainDataEvent))*/
	}
}
