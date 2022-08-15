package com.hgz.optim.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.*;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/13 14:49
 */
public class FreeMarkerUtils {

    /**
     * 使用FreeMarker自动生成Word文档
     *
     * @param object   生成Word文档所需要的数据
     * @param fileName 生成Word文档的全路径名称
     */
    public static void generateWord(Object object, String fileName) throws Exception {
        // 设置FreeMarker的版本和编码格式
        Configuration configuration = new Configuration(new Version("2.3.28"));
        configuration.setDefaultEncoding("UTF-8");

        // 设置FreeMarker生成Word文档所需要的模板的路径
        configuration.setDirectoryForTemplateLoading(new File("E:\\模板\\"));
        // 设置FreeMarker生成Word文档所需要的模板
        Template t = configuration.getTemplate("word.ftl", "UTF-8");
        // 创建一个Word文档的输出流
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName)), "UTF-8"));
        //FreeMarker使用Word模板和数据生成Word文档
        t.process(object, out);
        out.flush();
        out.close();
    }
}
