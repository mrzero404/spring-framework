package club.mrzero.spring;

import club.mrzero.spring.aop.TestBean;
import club.mrzero.spring.context.TestEvent;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author LinWeiYu
 * @date 2021/6/8 17:04
 */
public class AopTest {
	@Test
	public void MyTestBeanTest() {
		ApplicationContext bf = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestBean bean = (TestBean)bf.getBean("test");
		bean.test();
	}

}
