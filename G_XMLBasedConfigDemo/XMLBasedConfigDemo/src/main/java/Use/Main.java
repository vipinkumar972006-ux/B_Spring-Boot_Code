package Use;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String[]args)
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
        //1.OrderService order=context.getBean("orderService",OrderService.class);
        OrderService order=context.getBean(OrderService.class);
        order.OrderPlaced();
    }
}
