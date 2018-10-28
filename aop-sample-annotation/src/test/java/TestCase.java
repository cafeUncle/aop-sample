import com.yangyao.controllers.DemoController;
import com.yangyao.services.IHelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestCase {

    @Autowired
    IHelloService helloService;

    @Autowired
    DemoController demoController;

    @Test
    public void test1() {
        System.out.println(helloService);
    }

    @Test
    public void test2() {
        System.out.println(demoController);
    }
}
