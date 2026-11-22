package spring_core_practice;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main 
{
    public static void main(String[] args) 
    {
      AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);//Spring ka godown.

       OrderService order=context.getBean(OrderService.class);//Bean lakar do . or maine use order object variable me store kar liya hai.
       order.placeOrder();
       User user=context.getBean(User.class);
       System.out.println(user.getname());
    }
}