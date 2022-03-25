package xyz.wsyzz.candy;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.wsyzz.candy.util.FreeMarkerUtils;

import java.io.*;
import java.util.*;

import static jdk.nashorn.internal.objects.Global.undefined;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServerApplicationTests {
	public static void main(String[] args) throws Exception {
//		String template = "你好${姓名!'未知'}，今天是${date?string('yyyy-MM-dd')}"; //变量参考freemarker语法
//
//		Map m = new HashMap();
//
//		m.put("姓名", "管理员");
//
//		m.put("date", new Date());
//		String str = FreeMarkerUtils.strToStr(template, m);
//		System.out.println(str);
		ExcelReader reader = ExcelUtil.getReader("e:/111.xlsx");
		List<Map<String,Object>> readAll = reader.readAll();
		System.out.println(JSONUtil.toJsonStr(readAll));
//		String text = "3";
//		String s = Optional.ofNullable(text).map((e) ->e).orElseGet(() -> "2");
//		System.out.println(s);
	}
	@Value("${server.port}")
	String port;
	@Autowired
    Environment environment;
	@Test
	public void contextLoads() throws Exception{
//        System.out.println(port + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        Arrays.asList(environment.getActiveProfiles()).forEach(System.out::print);

//		InputStream inputStream = AdminServerApplicationTests.class.getResourceAsStream("/1.txt");
//		InputStreamReader streamReader = new InputStreamReader(inputStream);
//		BufferedReader bufferedReader = new BufferedReader(streamReader);
//		String s = bufferedReader.readLine();
//		System.out.println(s);
    }


	public static String freemarkerProcess(Map input, String templateStr) {
		StringTemplateLoader stringLoader = new StringTemplateLoader();
		String template = "content";
		stringLoader.putTemplate(template, templateStr);
		Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		cfg.setTemplateLoader(stringLoader);

		try {

			Template templateCon = cfg.getTemplate(template);

			StringWriter writer = new StringWriter();

			templateCon.process(input, writer);

			return writer.toString();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (TemplateException e) {

			e.printStackTrace();

		}

		return null;

	}

}
