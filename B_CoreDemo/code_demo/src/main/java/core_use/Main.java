package core_use;

import core_use.NotificationService.EmailService;
import core_use.NotificationService.NotificationService;
import core_use.NotificationService.PopUpnotificationService;

public class Main 
{
    public static void main(String[] args) 
    {
        NotificationService notification=new PopUpnotificationService();
        orderservice order =new orderservice(notification);
        order.placeorder();
     }
}
