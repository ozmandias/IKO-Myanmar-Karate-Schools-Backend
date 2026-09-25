package com.james.IKO_Myanmar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class IkoMyanmarKarateSchoolsApplication {

	public static void main(String args[]) {
        SpringApplication.run(IkoMyanmarKarateSchoolsApplication.class, args);
	}

}