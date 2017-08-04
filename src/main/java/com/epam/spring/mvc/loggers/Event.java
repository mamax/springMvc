package com.epam.spring.mvc.loggers;

import java.text.DateFormat;
import java.util.Date;

public class Event {

    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    @Override
    public String toString() {
        return "Event{" +
                "msg='" + msg + '\'' +
                ", date=" + date +
                ", dateFormat=" + dateFormat.format(date) +
                '}' + "\n";
    }

    public Event(String msg, Date date, DateFormat dateFormat) {
        this.msg = msg;
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    @Override
//    public String toString() {
//        return dateFormat.format(date);
//    }

}
