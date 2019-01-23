/*
* Copyright 2002-2016 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.byta.aop.aop.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * TODO Provide a detailed description here
 * 
 * @author MayaSanjeev ,
 */
@Component
@Aspect
public class AspectLogging {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	


	/**
	 * Pointcut that matches all repositories, services and Web REST endpoints.
	 */
	@Pointcut("within(@org.springframework.stereotype.Repository *)"
			+ " || within(@org.springframework.stereotype.Service *)"
			+ " || within(@org.springframework.web.bind.annotation.RestController *)")
	public void springBeanPointcut() {
		// Method is empty as this is just a Pointcut, the implementations are
		// in the advices.
	}

	@Pointcut("within(com.byta.aop.aop.sample..*)"+
	" || within(com.byta.aop.aop.test..*)")
	public void applicationPackagePointcut() {

	} 

	@Around("applicationPackagePointcut() && springBeanPointcut() ")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		// advice to execute the before entering to the method
		if (log.isInfoEnabled()) {
			
			log.info("*****************************Enter: {}.{}() with argument[s] = {}",
					joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
					Arrays.toString(joinPoint.getArgs()));
		}
		// advice to execute the after exiting to the method
		try {
			Object result = joinPoint.proceed();

			if (log.isInfoEnabled()) {
				log.info("********************Exit: {}.{}() with result = {}",
						joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), result);
			}

			return result;

		} catch (IllegalArgumentException e) {
			log.error("******************Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
					joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

			throw e;

		}

	}

}
