package com.byta.aop.aop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication {
	static final Logger logger=LoggerFactory.getLogger(AopApplication.class);
	public static void main(String[] args) {
		
		//System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^ MAIN METHOD^^^^^^^^^^^^^^^^^^^^^^^^");
		SpringApplication.run(AopApplication.class, args);
		logger.debug("DEBUG^^^^^^^^^^^^^^^^^^^^^^^^^^^^ MAIN METHOD^^^^^^^^^^^^^^^^^^^^^^^^");
		logger.info("INFO^^^^^^^^^^^^^^^^^^^^^^^^^^^^ MAIN METHOD^^^^^^^^^^^^^^^^^^^^^^^^");
		//.............logger level checking........................................
		
	}

}

