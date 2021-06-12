package club.mrzero.spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author LinWeiYu
 * @date 2021/6/8 17:04
 */
public class AppTest {
	@Test
	public void MyTestBeanTest() {
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("spring-config.xml"));
		MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
		System.out.println(myTestBean.getName());
	}
}
