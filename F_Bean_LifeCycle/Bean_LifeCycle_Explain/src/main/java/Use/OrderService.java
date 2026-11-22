package Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService
{
    final private PaymentService paymentService;
    @Autowired
    OrderService( PaymentService paymentService)
    {

        this.paymentService = paymentService;
    }
    public void placeorder()
    {
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
