package com.boot.study;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.study.dao.TestDao;
import com.boot.study.model.TTest;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisTest {

	@Autowired
	private TestDao testDao;

	@Test
	public void selectAll() {
		List<TTest> list = testDao.selectAll();
		System.out.println(list);
	}

	@Test
	public void getById() {
		TTest test = testDao.getById(1L);
		System.out.println(test);
	}

	@Test
	public void query() {
		TTest test = testDao.query(1L, "HD");
		System.out.println(test);
	}

	@Test
	public void delete() {
		int i = testDao.delete(1L);
		System.out.println(i);
	}

	@Test
	public void save() {
		TTest test = new TTest();
		test.setName("张三");
		int i = testDao.save(test);
		System.out.println(i);
		System.out.println(test);
	}

	@Test
	public void update() {
		TTest test = new TTest();
		test.setName("张三10");
		test.setId(10L);
		int i = testDao.update(test);
		System.out.println(i);
	}
}
