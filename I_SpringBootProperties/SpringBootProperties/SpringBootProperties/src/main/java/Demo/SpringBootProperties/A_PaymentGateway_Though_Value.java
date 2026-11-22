package Demo.SpringBootProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class A_PaymentGateway_Though_Value
{
    //1.
    @Value("${payment-gateway.type}")
    private String type;
    @Value("${payment-gateway.retry-count}")
    private  int retryCount;
    public String gettype()
    {
        return type;
    }
    public int getretryCount()
    {
        return retryCount;
    }
    //2.
    String CollegeName; int Score;
    A_PaymentGateway_Though_Value(@Value("${payment-gateway.college-name}")String CollegeName, @Value("${payment-gateway.score}")int Score)
    {
        this.CollegeName=CollegeName;
        this.Score=Score;
    }
    //3.
    @Value("${payment-gateway.district:Lakhimpur}") // Fallback used when no value is configured.
    String District;
    @Value("${payment-gateway.village:J.B Ganj Kheri}")
    String Village;
    public void print()
    {
        System.out.println("===================@Value==================");
        System.out.println(gettype());
        System.out.println(getretryCount());
        System.out.println(CollegeName);
        System.out.println(Score);
        System.out.println(District);
        System.out.println(Village);
    }
}
