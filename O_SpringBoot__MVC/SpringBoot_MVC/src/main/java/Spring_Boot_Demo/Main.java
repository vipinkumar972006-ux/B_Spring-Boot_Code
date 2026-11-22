package Spring_Boot_Demo;

import Spring_Boot_Demo.Config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args) throws LifecycleException {
        //Boiler plate.
        Tomcat tomcat=new Tomcat();
        tomcat.setPort(8080);
        // tomcat es port ko lisen kar sake us ke liye connector chahiye.
        tomcat.getConnector();

        String contextPath="";
        String baseDoc=new File("src/main/webapp").getAbsolutePath();
        Context context=tomcat.addContext(contextPath,baseDoc);
        //IOC Container app
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.setServletContext(context.getServletContext());
        springContext.register(WebConfig.class);
        springContext.refresh();

        //Dispatcher Servlet
        DispatcherServlet dispatcherServlet=new DispatcherServlet(springContext);
        Tomcat.addServlet(context,"dispatcherServlet",dispatcherServlet);

        context.addServletMappingDecoded("/","dispatcherServlet");

        tomcat.start();
        System.out.println("Tomcat started on port 8080");
        tomcat.getServer().await();
    }
}
