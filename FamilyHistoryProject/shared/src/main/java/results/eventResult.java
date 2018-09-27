package results;

import java.util.ArrayList;

import model.event;

/**
 * Created by Admin on 2/14/17.
 *
 *  ArrayList<event> events list of events
 */

public class eventResult {

    ArrayList<event> events = null;
    private String message;

    public eventResult() {
        events = new ArrayList<event>();
    }

    public void addEvent(event event) {
        events.add(event);
    }

    public void setEvents(ArrayList<event> events) {
        this.events = events;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<event> getEvents() {
        return events;
    }
}

