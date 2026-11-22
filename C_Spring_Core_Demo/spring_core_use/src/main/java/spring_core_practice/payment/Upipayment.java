package spring_core_practice.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("upiPayment")
public class Upipayment implements PaymentService
{
    @Override
    public void pay()
    {
        System.out.println("Payment by UPI");
    }
}
