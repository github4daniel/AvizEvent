package com.avizva.frameworks.events.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import com.avizva.frameworks.events.annotation.AvizEvent;
import com.avizva.frameworks.events.publisher.AvizEventPublisher;

@Aspect
@Component
public class EventAspect {

	@Autowired
	private ApplicationContext applicationContext;

	@Around("@annotation(com.avizva.frameworks.events.annotation.AvizEvent)")
	public <T extends ApplicationEvent> void extractAndPublishMessage(ProceedingJoinPoint joinPoint) throws Throwable {

		var ms = (MethodSignature) joinPoint.getSignature();
		var method = ms.getMethod();
		var e = method.getAnnotation(AvizEvent.class);
		var eventName = e.name();
		var beanName = e.implBean();
		var obj = joinPoint.proceed();
		var eventPublisher = applicationContext.getBean(beanName, AvizEventPublisher.class);
		T t = eventPublisher.constructEvent(eventName, obj);
		eventPublisher.publish(t);

	}
}
