package Use;

public class OrderService
{
    private final PaymentService paymentService;
    OrderService(PaymentService paymentService)
    {
        this.paymentService=paymentService;
    }
    public void OrderPlaced()
    {
        paymentService.payment();
        System.out.println("Order Place");
    }
}
