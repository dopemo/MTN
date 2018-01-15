package satti.ibraheem.restEasy;
 
import org.glassfish.jersey.filter.LoggingFilter;

import org.glassfish.jersey.server.ResourceConfig;
 
import satti.ibraheem.restEasy.provider.AuthenticationFilter;
import satti.ibraheem.restEasy.provider.GsonMessageBodyHandler;
 
public class CustomApplication extends ResourceConfig
{
    public CustomApplication()
    {
        packages("satti.ibraheem.restEasy");
        register(LoggingFilter.class);
        register(GsonMessageBodyHandler.class);
 
        //Register Auth Filter here
        register(AuthenticationFilter.class);
    }
}