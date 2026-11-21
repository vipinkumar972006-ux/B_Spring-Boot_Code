package core_use;

import core_use.NotificationService.NotificationService;

public class orderservice 
{
    NotificationService notification;
    orderservice(NotificationService notification)
    {
        this.notification=notification;
    }
    public void placeorder()
    {
        System.out.println("Order placed");
        notification.sendNotification();
    }    
}
