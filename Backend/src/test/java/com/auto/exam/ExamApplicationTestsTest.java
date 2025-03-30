// filepath: src/test/java/com/auto/exam/ExamApplicationTestsTest.java
package com.auto.exam;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;



@SpringBootTest
class ExamApplicationTestsTest {

	@Test
	void testContextLoads() {
		ExamApplicationTests applicationTests = new ExamApplicationTests();
		assertNotNull(applicationTests, "Application context should load and create an instance of ExamApplicationTests");
	}
}
