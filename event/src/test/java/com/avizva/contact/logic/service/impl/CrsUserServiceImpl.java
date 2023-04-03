package com.avizva.contact.logic.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.avizva.contact.logic.service.CrsUserService;
import com.avizva.frameworks.events.annotation.AvizEvent;

@Component
public class CrsUserServiceImpl implements CrsUserService {

	private static final List<Long> MEHTHOD_DUMMY_RETURN = Arrays.asList(1L, 2L);

	@Override
	@AvizEvent(name = "CRS_USER_SERVICE", implBean = "CrsEventPublisher")
	public List<Long> updateCrsUserStatus() {
		return MEHTHOD_DUMMY_RETURN;
	}
}
