package use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService 
{   
    //======================Circular Dependency Resolved==================.
    @Autowired
    private PaymentService paymentService;
    public void placeorder()                            // Flow
    {                                                   // 1.Payment.
        paymentService.pay();                           // 2.orderdetails.
        orderdetails();                                 // 3.order placed.
        System.out.println("Order placed");
    }
    public void orderdetails()
    {
        System.out.println("order details");
    }
}
