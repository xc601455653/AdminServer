package xyz.wsyzz.candy;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServerApplicationTests {

	@Value("${server.port}")
	String port;
	@Autowired
    Environment environment;
	@Test
	public void contextLoads() {
        System.out.println(port + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Arrays.asList(environment.getActiveProfiles()).forEach(System.out::print);
    }
}
