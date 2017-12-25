package com.stalary;

import com.stalary.domain.Girl;
import com.stalary.repository.GirlRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {

	@Resource
	private GirlRepository girlRepository;

	@Test
	public void contextLoads() {
//		Girl girl = girlRepository.findOne(1);
//		System.out.println(girl.toString());
	}


}
