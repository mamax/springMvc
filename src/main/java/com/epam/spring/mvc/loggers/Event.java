package com.epam.spring.mvc.loggers;

import java.text.DateFormat;
import java.util.Date;

public class Event {

    private int id;
    private String msg;
    private Date data;
    private DateFormat df;

    public Event(Date data, DateFormat df) {
        this.data = data;
        this.df = df;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", df=" + df +
                '}';
    }

}
