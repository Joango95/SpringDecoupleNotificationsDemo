package com.joango.springDetachmentDemo

import com.joango.springDetachmentDemo.domain.DomainDataEvent
import com.joango.springDetachmentDemo.event.DomainDataEventPublisher
import com.joango.springDetachmentDemo.service.DetachedService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class SpringDetachmentDemoApplicationTests {

	@Autowired
	lateinit var domainDataEventPublisher: DomainDataEventPublisher

	@Autowired
	lateinit var detachedService: DetachedService

	@Test
	fun contextLoads() {
	}

	@Test
	fun testEventListener() {
		val myNewDomainDataEvent = DomainDataEvent("oneValue", 12345)

		domainDataEventPublisher.publishSomeDomainDataEvent(myNewDomainDataEvent)

		assertEquals(1, detachedService.eventsProcessed.size)
		assert(detachedService.eventsProcessed.contains(myNewDomainDataEvent))
	}

}
