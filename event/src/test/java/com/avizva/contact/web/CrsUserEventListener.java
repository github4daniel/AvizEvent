package com.avizva.contact.web;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.avizva.contact.logic.model.CrsUserEvent;

@Component
public class CrsUserEventListener implements ApplicationListener<CrsUserEvent> {
	@Override
	public void onApplicationEvent(CrsUserEvent event) throws RuntimeException {
		if (!"CRS_USER_SERVICE".equals(event.getEventName())) {
			throw new RuntimeException("Listener must get correct message, otherwise runtime exception thrown");
		}
	}
}
