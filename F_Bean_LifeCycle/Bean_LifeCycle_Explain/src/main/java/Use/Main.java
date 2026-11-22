package Use;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
   public static void main(String[] args)
   {
        ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(Setting.class);
//        OrderService order=context.getBean(OrderService.class);
//        order.placeorder();
       CartService cart=context.getBean(CartService.class);
       System.out.println(cart.getValue(1));
       context.close();
   }
}
