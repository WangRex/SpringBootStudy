package com.boot.study;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTest {

	RestTemplate restTemplate = new RestTemplate();

	@SuppressWarnings("rawtypes")
	@Test
	public void get() {
//		Map string = restTemplate.getForObject("http://localhost:8080/hello/map?name={name}&age={age}", Map.class,
//				"1234", 100);
//		System.out.println(string);

		Map string = restTemplate.postForObject("http://localhost:8080/hello/map", "555body", Map.class);
		System.out.println(string);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void exchange() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("token", "0000000");
		HttpEntity<String> httpEntity = new HttpEntity<String>("nihao body", headers);
		ResponseEntity<Map> mEntity = restTemplate.exchange("http://localhost:8080/hello/map", HttpMethod.POST,
				httpEntity, Map.class);
		System.out.println(mEntity);
		System.out.println(mEntity.getBody());
	}
}
