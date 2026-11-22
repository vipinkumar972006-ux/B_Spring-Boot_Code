package use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // es class ka Har baar new object create hoga.
//@Scope("singleton") // es class ka siraf ek baar object banega.
public class OrderService
{
    final private PaymentService paymentService;
    @Autowired
    OrderService(PaymentService paymentService)
    {
        this.paymentService=paymentService;
    }
    public void placeorder()
    {
        paymentService.paymentservice();
        System.out.println("Order Placed");
    }
}
