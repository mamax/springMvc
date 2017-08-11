package com.epam.spring.mvc.loggers;

import java.io.IOException;
import java.util.ArrayList;

public class CombinedEventLogger extends EventLogger{

    ArrayList<Event> loggers = new ArrayList();

    public CombinedEventLogger(ArrayList<Event> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) throws IOException {
        for (Event e :loggers){
            e.getMsg();
        }
    }
}
