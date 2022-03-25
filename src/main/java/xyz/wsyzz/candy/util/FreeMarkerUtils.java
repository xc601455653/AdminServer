package xyz.wsyzz.candy.util;

import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
/**
 * Created by xucan on 2022/3/25.
 */
public class FreeMarkerUtils {

    private static Configuration config;
    private static final Version VERSION = new Version("2.3.23");
    private static final String FILE_ROOT = "tmp/";

    public static Configuration defaultConfiguration() {
        if (config == null) {
            synchronized (FreeMarkerUtils.class) {
                config = new Configuration(VERSION);
                config.setNumberFormat("0.####");
                config.setDateFormat("yyyy-MM-dd");
                config.setTimeFormat("HH:mm:ss");
                config.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
                config.setBooleanFormat("true,false");
                config.setWhitespaceStripping(true);
                config.setClassicCompatible(true);
//              File file = new File(Resource.getResourcePath(FILE_ROOT));
//              config.setDirectoryForTemplateLoading(file);
            }
        }
        return config;
    }

    public static void strToWriter(String tmp, Object model, Writer writer) throws Exception {
        new Template("null", new StringReader(tmp), config).process(model, writer);
    }

    public static void fileToWriter(String tmp, Object model, Writer writer) throws Exception {
        config.getTemplate(tmp).process(model, writer);
    }

    public static String strToStr(String tmp, Object model) throws Exception {
        StringWriter out = new StringWriter();
        strToWriter(tmp, model, out);
        return out.toString();
    }

    public static String fileToStr(String tmp, Object model) throws Exception {
        StringWriter out = new StringWriter();
        config.getTemplate(tmp).process(model, out);
        return out.toString();
    }

    public static void fileToFile(String tmp, File file, Object model) throws Exception {
        FileWriter writer = new FileWriter(file);
        fileToWriter(tmp, model, writer);
    }

    public static void fileToFile(String tmp, String file, Object model) throws Exception {
        fileToFile(tmp, new File(file), model);
    }

    public static void readerToWrite(Reader reader, Writer out, String tmpName, Map<String, Object> params)
            throws Exception {
        new Template(tmpName, reader, config).process(params, out);
    }
}
