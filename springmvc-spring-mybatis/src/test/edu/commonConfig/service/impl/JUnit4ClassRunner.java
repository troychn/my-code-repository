package edu.commonConfig.service.impl;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

/**
 * Created by lc on 2015/5/25.
 */
public class JUnit4ClassRunner extends SpringJUnit4ClassRunner {

    /**
     * 在启动Junit测试时，spring就会加载log4j了。而且保持了灵活性。
     * PS：Junit加载spring的runner（SpringJUnit4ClassRunner）要优先于spring加载log4j，因此采用普通方法，
     *  无法实现spring先加载log4j后被Junit 加载。所以我们需要新建JUnit4ClassRunner类，
     *  修改SpringJUnit4ClassRunner加载log4j的策略。这样加载log4j就会优先于加载spring了。
     */
    static {
        try {
            Log4jConfigurer.initLogging("classpath:config/log4j.properties");
        } catch (Exception ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }
    /**
     * Constructs a new {@code SpringJUnit4ClassRunner} and initializes a
     * {@link TestContextManager} to provide Spring testing functionality to
     * standard JUnit tests.
     *
     * @param clazz the test class to be run
     * @see #createTestContextManager(Class)
     */
    public JUnit4ClassRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }
}
