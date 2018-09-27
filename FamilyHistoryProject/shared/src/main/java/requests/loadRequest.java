package requests;

import model.event;
import model.person;
import model.user;

/**
 * Created by Admin on 2/14/17.
 * “users”: [ /* Array of User objects  ],
 “persons”: [ /* Array of Person objects  ],
 “events”: [ /* Array of Event objects ]
 */

public class loadRequest {
    user users[];
    person persons[];
    event events[];

    public loadRequest(model.user[] users, model.person[] persons, model.event[] events) {
        this.users = users;
        this.persons = persons;
        this.events = events;
    }

    public model.user[] getUsers() {
        return users;
    }

    public model.person[] getPersons() {
        return persons;
    }

    public model.event[] getEvents() {
        return events;
    }
}

