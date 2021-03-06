package com.boot.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.study.service.TestService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BootTest {

	@Autowired
	private TestService testService;

	@Test
	public void hello() {
		System.out.println("hello");
		testService.hello();
	}
}
