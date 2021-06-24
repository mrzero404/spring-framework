package club.mrzero.spring.context;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class TestListener implements ApplicationListener<TestEvent> {
    public void onApplicationEvent (TestEvent event ) {
        if (event instanceof TestEvent ) { 
            TestEvent testEvent = (TestEvent) event ;
			System.out.println("taking the message is : " + testEvent.msg);
        }
    }
}