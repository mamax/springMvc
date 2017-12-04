package com.epam.spring.mvc.loggers;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;
    protected StringBuffer sbf = new StringBuffer();

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) throws IOException {
        sbf.append(event.toString());
        writeStringToFile();
    }

    protected void writeStringToFile() throws IOException {
        FileUtils.writeStringToFile(this.file = new File(getClass().getClassLoader().getResource(fileName).getFile()), sbf.toString());
    }

    /**
     * for spring bean
     * @throws IOException
     */
    protected void init() throws IOException{
        this.file = new File(getClass().getClassLoader().getResource(fileName).getFile());

        if (!file.canWrite()){
            throw new IOException();
        }
    }
}
