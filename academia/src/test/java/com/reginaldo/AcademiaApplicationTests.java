package com.reginaldo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.reginaldo.academia.AcademiaApplication;

@SpringBootTest(classes = AcademiaApplication.class, properties = {"spring.datasource.url=jdbc:h2:mem:testdb", "spring.datasource.driver-class-name=org.h2.Driver"})
class AcademiaApplicationTests {

	@Test
	void contextLoads() {}

}
