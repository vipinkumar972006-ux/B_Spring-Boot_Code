package core_use.NotificationService;

public class SMSnotificationSerivce implements NotificationService
{
     @Override
    public void  sendNotification()
    {
        System.out.println("SMS notification sent");
    }
}
