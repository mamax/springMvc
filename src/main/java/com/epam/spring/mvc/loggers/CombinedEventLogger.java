package com.epam.spring.mvc.loggers;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class CombinedEventLogger implements EventLogger{

    private Collection<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) throws IOException {
        for (EventLogger e :loggers){
            e.logEvent(event);
        }
    }
}
