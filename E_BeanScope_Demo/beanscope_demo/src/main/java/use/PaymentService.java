package use;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // Es ka jav use ho tav creat karna .
public class PaymentService
{
    public void paymentservice()
    {
        System.out.println("Payment DONE...");
    }
}
