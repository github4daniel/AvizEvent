package com.avizva.contact.logic.publisher;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import com.avizva.contact.logic.model.CrsUserEvent;
import com.avizva.frameworks.events.publisher.AvizEventPublisher;

@Component("CrsEventPublisher")
public class CrsUserEventPublisher extends AvizEventPublisher {
	@Override
	public CrsUserEvent constructEvent(String eventName, Object obj) {
		var e = new CrsUserEvent(obj);
		e.setEventName(eventName);
		return e;
	}
}
