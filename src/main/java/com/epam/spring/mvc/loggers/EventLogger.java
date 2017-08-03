package com.epam.spring.mvc.loggers;

import java.io.IOException;

public interface EventLogger {

    void logEvent(Event event) throws IOException;
}
