package com.reginaldo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.reginaldo.academia.AcademiaApplication;

@SpringBootTest(classes = AcademiaApplication.class)
@ActiveProfiles("test")
class AcademiaApplicationTests {

	@Test
	void contextLoads() {}

}
