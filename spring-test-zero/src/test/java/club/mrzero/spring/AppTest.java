package club.mrzero.spring;

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
public class AppTest {
	@Test
	public void MyTestBeanTest() {
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("spring-config.xml"));
		BeanFactory bf2 = new XmlBeanFactory( new ClassPathResource("spring-config.xml"));
		MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
		MyTestBean myTestBean2 = (MyTestBean) bf2.getBean("myTestBean");
		System.out.println(myTestBean.getName());
		myTestBean.setName("test");
		System.out.println(myTestBean2.getName());
	}

	@Test
	public void populateBeanTest() {
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("spring-config.xml"));
		PopulateBeanTest populateBeanTest = (PopulateBeanTest) bf.getBean("populateBeanTest");
		System.out.println(populateBeanTest.getName());
	}

	/**
	 * 我们先了解一下Aware方法的使用。
	 * Spring中提供了一些Aware接口，比如BeanFactoryAware,ApplicationContextAware,ResourceLoaderAware,ServletContextAware等，
	 * 实现这些Aware接口的bean在被初始化后，可以取得一些相对应的资源，
	 * 例如实现BeanFactoryAware的bean在初始化之后，Spring容器将会注入BeanFactory实例，
	 * 而实现ApplicationContextAware的bean，在bean被初始化后，将会被注入ApplicationContext实例等。
	 */
	@Test
	public void myBeanAwareTest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyBeanAware test = (MyBeanAware)ctx.getBean("myBeanAware");
		test.testAware();
	}

	@Test
	public void MyAopTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestEvent event = new TestEvent("hello" ,"msg") ;
		context.publishEvent(event);
	}
}
