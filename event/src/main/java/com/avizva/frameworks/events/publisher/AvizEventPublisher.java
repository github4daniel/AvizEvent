package com.avizva.frameworks.events.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public abstract class AvizEventPublisher {

	@Autowired
	private ApplicationEventPublisher publisher;

	public abstract <T extends ApplicationEvent> T constructEvent(String eventName, Object obj);

	public <T extends ApplicationEvent> void publish(T t) {
		publisher.publishEvent(t);
	}
}
