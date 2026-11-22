package Demo.SpringBootProperties;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements ApplicationRunner
{
    private final A_PaymentGateway_Though_Value a_paymentGateway_though_value;
    private final B_PaymentGateway_Though_ConfigurationProperties b_paymentGateway_though_configurationProperties;

    DemoRunner(A_PaymentGateway_Though_Value a_paymentGateway_though_value,
               B_PaymentGateway_Though_ConfigurationProperties b_paymentGateway_though_configurationProperties)
    {
        this.a_paymentGateway_though_value=a_paymentGateway_though_value;
        this.b_paymentGateway_though_configurationProperties=b_paymentGateway_though_configurationProperties;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        a_paymentGateway_though_value.print();
        b_paymentGateway_though_configurationProperties.print();
    }
}
