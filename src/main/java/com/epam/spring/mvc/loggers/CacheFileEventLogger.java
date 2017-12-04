package com.epam.spring.mvc.loggers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    private int cacheSize;
    private List<Event> cache = new ArrayList<Event>();

    @Override
    public void logEvent(Event event) throws IOException {
        cache.add(event);

        if(cache.size() == cacheSize){
            writeEventsFromCache(cache);
            cache.clear();
        }
    }

    private void writeEventsFromCache(List<Event> cache) throws IOException {
        for ( Event e : cache) {
            sbf.append(e.toString());
            writeStringToFile();
        }
    }

    public void destroy() throws IOException {
        if( !cache.isEmpty() ){
            writeEventsFromCache(cache);
        }
    }


}
