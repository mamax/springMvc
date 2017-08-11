package com.epam.spring.mvc.loggers;

import java.io.IOException;

public abstract class EventLogger {

    public abstract void logEvent(Event event) throws IOException;
}
