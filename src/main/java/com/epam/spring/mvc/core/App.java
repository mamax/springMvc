package com.epam.spring.mvc.core;

import com.epam.spring.mvc.beans.Client;
import com.epam.spring.mvc.loggers.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class App {

    private Client client;
    private Map<EventType, EventLogger> loggers;
    private EventLogger eventLogger;

    public App(Client client, Map<EventType, EventLogger> loggers, EventLogger eventLogger) {
        this.client = client;
        this.loggers = loggers;
        this.eventLogger = eventLogger;
    }

    private void logEvent(EventType type, String msg) throws IOException {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        Event event = new Event(message, new Date(), new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));

        EventLogger logger = loggers.get(type);

        if (logger == null){
            logger = new CacheFileEventLogger("log.txt", 5);
        }
        else if (type == EventType.INFO){
            logger = new ConsoleEventLogger();
        }
        else if (type == EventType.ERROR){
            logger = new ConsoleEventLogger();
        }

        logger.logEvent(event);
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = context.getBean("app", App.class);

        app.logEvent(EventType.INFO,"Some event for user 1");
        app.logEvent(EventType.ERROR,"Some event for user 11");
        app.logEvent(EventType.INFO,"Some event for user 22");

        ConfigurableApplicationContext context1 = (ConfigurableApplicationContext) context;
        context1.close();
    }
}
