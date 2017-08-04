package com.epam.spring.mvc.loggers;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String fileName;
    protected File file;
    public StringBuffer sbf = new StringBuffer();

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) throws IOException {
        sbf.append(event.toString());

        FileUtils.writeStringToFile(file, sbf.toString());
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
