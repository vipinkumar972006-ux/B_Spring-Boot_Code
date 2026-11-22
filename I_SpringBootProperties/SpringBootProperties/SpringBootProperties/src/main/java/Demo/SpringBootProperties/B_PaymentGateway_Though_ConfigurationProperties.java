package Demo.SpringBootProperties;

import org.springframework.stereotype.Component;

@Component
public class B_PaymentGateway_Though_ConfigurationProperties
{
    private C_ConfigurationProperties c_configurationProperties;
    B_PaymentGateway_Though_ConfigurationProperties(C_ConfigurationProperties c_configurationProperties)
    {
        this.c_configurationProperties=c_configurationProperties;
    }
    public String gettype()
    {
        return c_configurationProperties.getType();
    }
    public int getretryCount()
    {
        return c_configurationProperties.getRetryCount();
    }
    public String getCollegeName() { return c_configurationProperties.getCollegeName(); }
    public long getRollnumber() { return c_configurationProperties.getRollnumber(); }
    public String getDistrict() { return c_configurationProperties.getDistrict(); }
    public String getVillage() { return c_configurationProperties.getVillage(); }
    public  void print()
    {
        System.out.println("===================@ConfigurationProperties====");
        System.out.println(gettype());
        System.out.println(getretryCount());
        System.out.println(getCollegeName());
        System.out.println(getRollnumber());
        System.out.println(getDistrict());
        System.out.println(getVillage());
    }
}
