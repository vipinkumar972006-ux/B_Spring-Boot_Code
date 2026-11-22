package Spring_Boot_Demo.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("Spring_Boot_Demo")
@EnableWebMvc
public class WebConfig
{

}
