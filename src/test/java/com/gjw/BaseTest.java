package com.gjw;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({
//		"classpath:spring/spring-redis.xml",
		"classpath:spring/spring-dao.xml",
		"classpath:spring/spring-service.xml" })
public class BaseTest {

}