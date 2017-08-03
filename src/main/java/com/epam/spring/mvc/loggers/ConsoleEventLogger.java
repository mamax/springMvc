package com.epam.spring.mvc.loggers;

import java.io.IOException;

public class ConsoleEventLogger implements EventLogger{

    public void logEvent(Event event) throws IOException {
        System.out.println(event.toString());
    }
}
