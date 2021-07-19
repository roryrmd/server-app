package mcc53.com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringProjectApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void counterTest() {
        Counter counter1 = new Counter();
        Counter counter2 = applicationContext.getBean(Counter.class);
        Counter counter3 = applicationContext.getBean(Counter.class);

        counter1.counter();
        counter2.counter();
        counter3.counter();

        System.out.println(counter1);
        System.out.println(counter2);
        System.out.println(counter3);
    }

}
