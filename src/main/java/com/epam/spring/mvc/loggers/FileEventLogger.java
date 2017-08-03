package com.epam.spring.mvc.loggers;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) throws IOException {
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        FileUtils.writeStringToFile(file, event.toString());
    }

    /**
     * for spring bean
     * @throws IOException
     */
    private void init() throws IOException{
        this.file = new File(getClass().getClassLoader().getResource(fileName).getFile());

        if (!file.canWrite()){
            throw new IOException();
        }
    }
}
