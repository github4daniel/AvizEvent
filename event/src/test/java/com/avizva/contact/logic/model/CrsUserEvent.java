package com.avizva.contact.logic.model;

import org.springframework.context.ApplicationEvent;

public class CrsUserEvent extends ApplicationEvent {
	private String eventName;

	public CrsUserEvent(Object source) {
		super(source);
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
}
