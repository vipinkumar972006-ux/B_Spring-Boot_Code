package spring_core_practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring_core_practice.payment.PaymentService;

@Component // es class ka object(refrenced variable ) tum handle karo yani main class handle karenge

public class OrderService // ye class PaymentService class par dependent hai.
{
    private final PaymentService payment; // dependency Inject throught field injection.

    //1.
    @Autowired // maine connection dono class ka kar diya hai.
    OrderService(@Qualifier("cardPayment") PaymentService payment)//ese liye maine dependency Inject kardi through constructor ke.
    {
        this.payment=payment;
    }  
     
    //2.
    // @Autowired
    // public void setPaymentService(PaymentService payment) //dependency Inject through setter method
    
    //     this.payment=payment;
    // }
    public void placeOrder()
    {   
        payment.pay();
        System.out.println("Order Placed");
    }
}
