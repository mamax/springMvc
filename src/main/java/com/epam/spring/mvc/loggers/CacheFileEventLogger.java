package com.epam.spring.mvc.loggers;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Maksym_Mazurkevych on 4/7/2016.
 */
public class CacheFileEventLogger extends FileEventLogger {

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    int cacheSize;
    List<Event> cache;

    public void logEvent(Event event) throws IOException {
        cache.add(event);

        if(cache.size() == cacheSize){
            writeEventsFromCache(file, cache);
            cache.clear();
        }
    }

    private void writeEventsFromCache(File file, List<Event> cache) throws IOException {
        for (int i = 0; i < cache.size(); i++) {
            FileUtils.writeStringToFile(file, cache.get(i).toString());
        }
    }

    public void destroy() throws IOException {
        if( !cache.isEmpty() ){
            writeEventsFromCache(file, cache);
        }
    }


}
