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
		val myNewDomainDataEventOne = DomainDataEvent("ValueOne", 1)
		val myNewDomainDataEventTwo = DomainDataEvent("ValueTwo", 2)
		val myNewDomainDataEventThree = DomainDataEvent("ValueThree", 3)
		val myNewDomainDataEventFour = DomainDataEvent("ValueFour", 4)
		val myNewDomainDataEventFive = DomainDataEvent("ValueFive", 5)

		someDomainDataService.someCaseAHappens(myNewDomainDataEventOne)
		someDomainDataService.someCaseBHappens(myNewDomainDataEventTwo)
		someDomainDataService.someCaseCHappens(myNewDomainDataEventThree)
		someDomainDataService.someCaseDHappens(myNewDomainDataEventFour)
		someDomainDataService.someCaseEHappens(myNewDomainDataEventFive)

		assertEquals(5, domainDataEventHandler.getEventsProcessedSize())

		assert(domainDataEventHandler.getEventsProcessedList().contains(myNewDomainDataEventOne))
		assert(domainDataEventHandler.getEventsProcessedList().contains(myNewDomainDataEventTwo))
		assert(domainDataEventHandler.getEventsProcessedList().contains(myNewDomainDataEventThree))
		assert(domainDataEventHandler.getEventsProcessedList().contains(myNewDomainDataEventFour))
		assert(domainDataEventHandler.getEventsProcessedList().contains(myNewDomainDataEventFive))

		domainDataEventHandler.clearEventsProcessed()
	}

	@Test
	fun testEventListener() {
		val myNewDomainDataEvent = DomainDataEvent("twoValue", 987654)

		publishSomeDomainDataEvent.publishSomeDomainDataEvent(myNewDomainDataEvent)
	}
}
