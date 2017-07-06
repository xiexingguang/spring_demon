import com.spencer.ioc.*;
import com.spencer.ioc.UserServiceInterface;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 沾雨 on 2017/7/5 上午12:46
 */

public class Test {

    private ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext(new String[] {"spring_ioc.xml"});
        System.out.println("init ApplicationContext " + applicationContext);
    }

    @org.junit.Test
    public void testSetBean() {
        com.spencer.ioc.UserServiceInterface userServiceInterface = applicationContext.getBean(UserServiceInterface.class);
        System.out.println(userServiceInterface);
        userServiceInterface.add();
    }


}
