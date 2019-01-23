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
package com.byta.aop.aop.sample;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.byta.aop.aop.aspects.AspectResource;

/**
 * TODO Provide a detailed description here 
 * @author MayaSanjeev
 * , 
 */
@RestController 
public class SampleResource {
	//class logging with aop
	@GetMapping("/sample")
	public String getDetails(){
		
	return "******************hello sample*******************"	;
	}
	@PostMapping("/postsample")
	public String postDetails(@RequestBody String data){
		
	return data	;
	}
}
