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
package com.byta.aop.aop.aspects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * TODO Provide a detailed description here
 * 
 * @author MayaSanjeev ,
 */
@RestController
public class AspectResource {

	// class logging with logback which listen to logback configuration file

	private final Logger logger = LoggerFactory.getLogger(AspectResource.class);

	
	
	@GetMapping("/hello")
	public String getDetails() {
		
		//logger.debug("******************debug inline hello aspect*******************");

		//logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>info inline aspect..............");
        
		logger.error(".........................error..............................");

		return "******************hello aspect*******************   " ;
	}

	@PostMapping("/hellosample")
	public String postDetails(@RequestBody String data) {
		// logger.debug("******************hello post*******************",data);
		return data;
	}
}
