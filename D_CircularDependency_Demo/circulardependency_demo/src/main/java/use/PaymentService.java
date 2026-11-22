package use;

import org.springframework.stereotype.Component;

@Component
public class PaymentService 
{
    //======================Circular Dependency Resolved==================.
    // @Autowired
    // private OrderService orderService;
    public void pay()
    {
        System.out.println("Payment Done..");
        // orderService.orderdetails();
    }
}
