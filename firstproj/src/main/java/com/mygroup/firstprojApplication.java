package com.mygroup;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.mygroup.resources.firstprojResource;
import com.mygroup.health.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class firstprojApplication extends Application<firstprojConfiguration> {
//    private static final Logger LOGGER =
//            LoggerFactory.getLogger(firstprojApplication.class);

    public static void main(final String[] args) throws Exception {
        new firstprojApplication().run(args);
    }

    @Override
    public String getName() {
        return "firstproj";
    }
    @Override
    public void initialize(final Bootstrap<firstprojConfiguration> bootstrap) {

        //loads additional components
        //prepares the runtime environment of application
    }

    @Override
    public void run(final firstprojConfiguration configuration,
                    final Environment environment) {
//        LOGGER.info("Method firstprojApplication#run() called");
        System.out.println("Application is running");
        // TODO: implement application

        final firstprojResource resource = new firstprojResource(
                configuration.getTemplate(),
                configuration.getDefaultName(),
                configuration.getDefaultAlias()
        );
        environment.jersey().register(resource);
    }

}
