package spring_core_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // ye class spring ki setting hai . yahi se rule dekhega.
@ComponentScan("spring_core_practice") // es package me jaha par @Component class hai unhe dhudo.
public class AppConfig 
{
    @Bean // es method ka object handle karo,spring par kaha .
    public User creatuser()
    {
        return new User("Vipin",20);
    }
    
}
