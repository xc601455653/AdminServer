package xyz.wsyzz.candy;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import xyz.wsyzz.candy.util.FreeMarkerUtils;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xucan on 2022/4/11.
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        ExcelReader reader = ExcelUtil.getReader("C:\\Users\\xucan\\Desktop\\发电制氢加氢焊接数据库.xls");
        List<Map<String,Object>> readAll = reader.readAll();
        Map<Object, List<Map<String, Object>>> collect = readAll.stream().filter(item -> {
            return item.get("管线号") != null;
        }).collect(Collectors.groupingBy(item -> item.get("管线号")));
        FileReader cellReader = new FileReader("C:\\Users\\xucan\\Desktop\\单元格模板.txt");
        String template = cellReader.readString();
        FileReader fileReader = new FileReader("C:\\Users\\xucan\\Desktop\\焊接记录模板.xml");
        String result = fileReader.readString();
        for (Map.Entry<Object, List<Map<String, Object>>> objectListEntry : collect.entrySet()) {

            List<Map<String, Object>> v = objectListEntry.getValue();
            Object key = objectListEntry.getKey();
            System.out.println("文件生成中：========="+ key.toString());
            StringBuffer buffer = new StringBuffer();
            Map<String, String> data = new HashMap<>();
            v.forEach(item -> {
                try {
                    item.put("外径壁厚",item.get("外径*壁厚"));
                    buffer.append(FreeMarkerUtils.strToStr(template, item));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            data.put("data",buffer.toString());
            String finalStr = FreeMarkerUtils.strToStr(result, data);
            FileWriter writer = new FileWriter("C:\\Users\\xucan\\Desktop\\焊接\\焊接记录-"+key.toString()+".doc");
            writer.write(finalStr);
        }
    }
}
