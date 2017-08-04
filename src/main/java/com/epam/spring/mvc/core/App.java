package com.epam.spring.mvc.core;

import com.epam.spring.mvc.beans.Client;
import com.epam.spring.mvc.loggers.Event;
import com.epam.spring.mvc.loggers.FileEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

    private Client client;
    private FileEventLogger fileEventLogger;

    public App(Client client, FileEventLogger fileEventLogger) {
        this.client = client;
        this.fileEventLogger = fileEventLogger;
    }

    private void logEvent(String msg) throws IOException {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        Event event = new Event(message, new Date(), new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
        fileEventLogger.logEvent(event);
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = context.getBean("app", App.class);

        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 11");
        app.logEvent("Some event for user 22");

        ConfigurableApplicationContext context1 = (ConfigurableApplicationContext) context;
        context1.close();
    }
}
