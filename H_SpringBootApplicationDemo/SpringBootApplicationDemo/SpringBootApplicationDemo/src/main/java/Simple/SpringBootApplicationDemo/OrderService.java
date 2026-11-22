package Simple.SpringBootApplicationDemo;

import org.springframework.stereotype.Component;

@Component
public class OrderService
{
    private PaymentService paymentService;
    OrderService(PaymentService paymentService)
    {
        this.paymentService=paymentService;
    }
    public void orderService()
    {
        paymentService.pay();
        System.out.println("order placed");
    }
}
