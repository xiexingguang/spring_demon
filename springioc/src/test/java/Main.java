import com.spencer.ioc.UserServiceInterface;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by 沾雨 on 2017/7/5 上午10:19
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring_ioc.xml"});
        UserServiceInterface userServiceInterface = context.getBean(UserServiceInterface.class);
        System.out.println(userServiceInterface);
        userServiceInterface.add();


        //api方式获取
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        new XmlBeanDefinitionReader(genericApplicationContext).loadBeanDefinitions("spring_ioc.xml");
        genericApplicationContext.refresh();

        UserServiceInterface service = genericApplicationContext.getBean(UserServiceInterface.class);
        System.out.println("service =:" + service);

    }

}
