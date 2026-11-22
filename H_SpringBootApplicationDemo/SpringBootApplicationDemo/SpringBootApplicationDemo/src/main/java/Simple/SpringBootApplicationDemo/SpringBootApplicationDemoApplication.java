package Simple.SpringBootApplicationDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //@ComponentScan,@SpringBootConfiguration,@EnableAutoConfiguration.

public class SpringBootApplicationDemoApplication
{

	public static void main(String[] args)
	{
		ApplicationContext context=SpringApplication.run(SpringBootApplicationDemoApplication.class, args);
		OrderService order=context.getBean(OrderService.class);
		order.orderService();
	}
}
