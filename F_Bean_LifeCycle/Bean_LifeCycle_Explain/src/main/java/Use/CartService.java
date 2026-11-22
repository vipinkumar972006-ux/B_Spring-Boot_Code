package Use;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class CartService //implements InitializingBean
{
    Map<Integer,String> mp;
    public CartService()
    {
        mp=new HashMap<>();
        System.out.println("CartService Constructor called");
    }
//    @Override //Spring Call Karega.
//    public void afterPropertiesSet() throws Exception
//    {
//        System.out.println("Bean is Ready");
//        System.out.println("Initilization callback");
//        mp.put(1,"Vipin");
//        mp.put(2,"Anand");
//    }
     @PostConstruct // Es method ko spring khud call karega.
    public void start()
    {
        hari();
        System.out.println("Bean si Ready");
        mp.put(1,"Varsha");
        mp.put(2,"Vimal");
    }
    @PreDestroy
    public void stop()
    {
        System.out.println("Bean Stop");
    }
   // @PostConstruct  // Ek class me ek hi siraf @PostConstruct ho sakta hai.
    public void hari()
    {
        System.out.println("Jay Shree Ram");
        System.out.println("Hari method called");
    }
//    @PreDestroy
//    public void stop()
//    {
//        System.out.println("Bean Stop");
//    }
    public String getValue(int key)
    {
        return mp.get(key);
    }
}
