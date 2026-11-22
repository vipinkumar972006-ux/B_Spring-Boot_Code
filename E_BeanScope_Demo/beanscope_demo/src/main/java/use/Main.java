package use;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main(String[] args) 
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(Setting.class);
        // prototype -> Har baar new object create hoga.
        OrderService order1=context.getBean(OrderService.class);
        order1.placeorder();

//        OrderService order2=context.getBean(OrderService.class);
//        order2.placeorder();
    }
}