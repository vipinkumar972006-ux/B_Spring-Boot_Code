package Demo.SpringBootProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class A_SpringBootPropertiesApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(A_SpringBootPropertiesApplication.class, args);
		//===========================@Value=============================
//		A_PaymentGateway_Though_Value pay=context.getBean(A_PaymentGateway_Though_Value.class);
//		System.out.println("===================@Value==================");
//		//1.
//		System.out.println(pay.gettype());
//		System.out.println(pay.getretryCount());
//		//2.
//		System.out.println(pay.CollegeName);
//		System.out.println(pay.Score);
//		//3.
//		System.out.println(pay.District);
//		System.out.println(pay.Village);
		//=========================@ConfigurationProperties============
//		B_PaymentGateway_Though_ConfigurationProperties properties=context.getBean(B_PaymentGateway_Though_ConfigurationProperties.class);
//		System.out.println("===================@ConfigurationProperties====");
//		System.out.println(properties.gettype());
//		System.out.println(properties.getretryCount());
//		System.out.println(properties.getCollegeName());
//		System.out.println(properties.getRollnumber());
//		System.out.println(properties.getDistrict());
//		System.out.println(properties.getVillage());

	}
}
