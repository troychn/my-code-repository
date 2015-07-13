package com.edu.common.utils;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lc on 2015/6/3.
 */
public class CreateMybatisMapper {

    {
        try {
            String file = getClass().getResource("/config/log4j.properties")
                    .getFile();
            PropertyConfigurator.configure(file);
        } catch (Exception ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }

    @Test
    public void testMybatisMapper() {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            String file = getClass().getResource("/mybatis/generatorConfig.xml")
                    .getFile();
            System.out.println(file);
            File configFile = new File(file);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
