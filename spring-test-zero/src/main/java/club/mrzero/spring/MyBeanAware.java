package club.mrzero.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author LinWeiYu
 * @date 2021/6/23 14:39
 */
public class MyBeanAware implements BeanFactoryAware {
	private BeanFactory beanFactory;

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	public void testAware() {
		//通过hello这个bean id从beanFactory获取实例
		HelloBean hello = (HelloBean) beanFactory.getBean("hello");
		hello.say();
	}
}
