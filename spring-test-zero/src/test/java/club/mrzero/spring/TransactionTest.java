package club.mrzero.spring;

import club.mrzero.spring.transaction.AccountService;
import club.mrzero.spring.transaction.MyTransaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
    @Test
    public void test() {
        MyTransaction myTransaction = new MyTransaction();
        myTransaction.save();
    }

	@Test
	public void test1() {
		// 基于tx标签的声明式事物
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		AccountService studentService = ctx.getBean("accountService", AccountService.class);
		studentService.save();
	}
}