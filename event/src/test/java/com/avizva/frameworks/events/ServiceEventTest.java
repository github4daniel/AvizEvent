package com.avizva.frameworks.events;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.avizva.contact.logic.service.CrsUserService;
import com.avizva.frameworks.config.TestConfig;

@EnableAutoConfiguration
@SpringBootTest(classes = TestConfig.class)
public class ServiceEventTest {
	@Autowired
	private CrsUserService service;

	@Test
	public void avizEventSuccess() {
		service.updateCrsUserStatus();
		assertNotNull(service, "service cannot be null");
	}
}
	