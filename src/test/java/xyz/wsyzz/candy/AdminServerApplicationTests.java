package xyz.wsyzz.candy;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import sun.applet.Main;

import java.util.Arrays;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServerApplicationTests {
	public static void main(String[] args) {
		String text = "3";
		String s = Optional.ofNullable(text).map((e) ->e).orElseGet(() -> "2");
		System.out.println(s);
	}
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
